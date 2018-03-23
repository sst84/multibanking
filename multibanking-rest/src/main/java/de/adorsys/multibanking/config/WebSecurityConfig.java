package de.adorsys.multibanking.config;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;

import de.adorsys.sts.tokenauth.BearerToken;
import de.adorsys.sts.tokenauth.BearerTokenValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import de.adorsys.multibanking.encrypt.UserSecret;
import de.adorsys.multibanking.service.SecretClaimDecryptionService;
import de.adorsys.sts.filter.JWTAuthenticationFilter;
import de.adorsys.sts.token.authentication.TokenAuthenticationService;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    private SecretClaimDecryptionService secretClaimDecryptionService ;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/management/health").permitAll()
                .antMatchers("/management/info").permitAll()
                .antMatchers("/management/**").hasAuthority("admin")
                .antMatchers("/").permitAll()
                .antMatchers("/pop").permitAll()
                .antMatchers("/api-docs/**").permitAll()
                .antMatchers("/v2/api-docs/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/pop/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/bank/**").permitAll()
                .antMatchers("/api/v1/direct/**").permitAll()
                .antMatchers("/api/v1/image/**").permitAll()
                .antMatchers("/api/v1/**").authenticated()
                .anyRequest().denyAll()
                .and().cors();
       http
                .addFilterBefore(new JWTAuthenticationFilter(tokenAuthenticationService), BasicAuthenticationFilter.class);
    }

    @Autowired
    private BearerTokenValidator bearerTokenValidator;

    @Bean
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public BearerToken getBearerToken(HttpServletRequest request) {
        String token = request.getHeader(BearerTokenValidator.HEADER_KEY);
        BearerToken bearerToken = bearerTokenValidator.extract(token);
        return bearerToken ;
    }

    @Bean
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Principal getPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Bean
    @Primary
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserSecret getRequestScopeUserSecret() {
        String userSecret = secretClaimDecryptionService.decryptSecretClaim();
        return new UserSecret(userSecret);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setExposedHeaders(Collections.singletonList("Location"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}