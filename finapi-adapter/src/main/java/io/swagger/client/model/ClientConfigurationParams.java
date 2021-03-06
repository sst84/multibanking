/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.46.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Client configuration parameters
 */
@ApiModel(description = "Client configuration parameters")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-14T19:12:52.919Z")
public class ClientConfigurationParams {
  @SerializedName("userNotificationCallbackUrl")
  private String userNotificationCallbackUrl = null;

  @SerializedName("userSynchronizationCallbackUrl")
  private String userSynchronizationCallbackUrl = null;

  @SerializedName("refreshTokensValidityPeriod")
  private Integer refreshTokensValidityPeriod = null;

  @SerializedName("userAccessTokensValidityPeriod")
  private Integer userAccessTokensValidityPeriod = null;

  @SerializedName("clientAccessTokensValidityPeriod")
  private Integer clientAccessTokensValidityPeriod = null;

  public ClientConfigurationParams userNotificationCallbackUrl(String userNotificationCallbackUrl) {
    this.userNotificationCallbackUrl = userNotificationCallbackUrl;
    return this;
  }

   /**
   * Callback URL to which finAPI sends the notification messages that are triggered from the automatic batch update of the users&#39; bank connections. This field is only relevant if the automatic batch update is enabled for your client. For details about what the notification messages look like, please see the documentation in the &#39;Notification Rules&#39; section. finAPI will call this URL with HTTP method POST. Note that the response of the call is not processed by finAPI. Also note that while the callback URL may be a non-secured (http) URL on the finAPI sandbox or alpha environment, it MUST be a SSL-secured (https) URL on the finAPI live system.&lt;p&gt;The maximum allowed length of the URL is 512. If you have previously set a callback URL and now want to clear it (thus disabling user-related notifications altogether), you can pass an empty string (\&quot;\&quot;).
   * @return userNotificationCallbackUrl
  **/
  @ApiModelProperty(value = "Callback URL to which finAPI sends the notification messages that are triggered from the automatic batch update of the users' bank connections. This field is only relevant if the automatic batch update is enabled for your client. For details about what the notification messages look like, please see the documentation in the 'Notification Rules' section. finAPI will call this URL with HTTP method POST. Note that the response of the call is not processed by finAPI. Also note that while the callback URL may be a non-secured (http) URL on the finAPI sandbox or alpha environment, it MUST be a SSL-secured (https) URL on the finAPI live system.<p>The maximum allowed length of the URL is 512. If you have previously set a callback URL and now want to clear it (thus disabling user-related notifications altogether), you can pass an empty string (\"\").")
  public String getUserNotificationCallbackUrl() {
    return userNotificationCallbackUrl;
  }

  public void setUserNotificationCallbackUrl(String userNotificationCallbackUrl) {
    this.userNotificationCallbackUrl = userNotificationCallbackUrl;
  }

  public ClientConfigurationParams userSynchronizationCallbackUrl(String userSynchronizationCallbackUrl) {
    this.userSynchronizationCallbackUrl = userSynchronizationCallbackUrl;
    return this;
  }

   /**
   * Callback URL for user synchronization. This field should be set if you - as a finAPI customer - have multiple clients using finAPI. In such case, all of your clients will share the same user base, making it possible for a user to be created in one client, but then deleted in another. To keep the client-side user data consistent in all clients, you should set a callback URL for each client. finAPI will send a notification to the callback URL of each client whenever a user of your user base gets deleted. Note that finAPI will send a deletion notification to ALL clients, including the one that made the user deletion request to finAPI. So when deleting a user in finAPI, a client should rely on the callback to delete the user on its own side. &lt;p&gt;The notification that finAPI sends to the clients&#39; callback URLs will be a POST request, with this body: &lt;pre&gt;{    \&quot;userId\&quot; : string // contains the identifier of the deleted user    \&quot;event\&quot; : string // this will always be \&quot;DELETED\&quot; }&lt;/pre&gt;&lt;br/&gt;Note that finAPI does not process the response of this call. Also note that while the callback URL may be a non-secured (http) URL on the finAPI sandbox or alpha system, it MUST be a SSL-secured (https) URL on the live system.&lt;/p&gt;As long as you have just one client, you can ignore this field and let it be null. However keep in mind that in this case your client will not receive any callback when a user gets deleted - so the deletion of the user on the client-side must not be forgotten. Of course you may still use the callback URL even for just one client, if you want to implement the deletion of the user on the client-side via the callback from finAPI.&lt;p&gt; The maximum allowed length of the URL is 512. If you have previously set a callback URL and now want to clear it (thus disabling user synchronization related notifications for this client), you can pass an empty string (\&quot;\&quot;).
   * @return userSynchronizationCallbackUrl
  **/
  @ApiModelProperty(value = "Callback URL for user synchronization. This field should be set if you - as a finAPI customer - have multiple clients using finAPI. In such case, all of your clients will share the same user base, making it possible for a user to be created in one client, but then deleted in another. To keep the client-side user data consistent in all clients, you should set a callback URL for each client. finAPI will send a notification to the callback URL of each client whenever a user of your user base gets deleted. Note that finAPI will send a deletion notification to ALL clients, including the one that made the user deletion request to finAPI. So when deleting a user in finAPI, a client should rely on the callback to delete the user on its own side. <p>The notification that finAPI sends to the clients' callback URLs will be a POST request, with this body: <pre>{    \"userId\" : string // contains the identifier of the deleted user    \"event\" : string // this will always be \"DELETED\" }</pre><br/>Note that finAPI does not process the response of this call. Also note that while the callback URL may be a non-secured (http) URL on the finAPI sandbox or alpha system, it MUST be a SSL-secured (https) URL on the live system.</p>As long as you have just one client, you can ignore this field and let it be null. However keep in mind that in this case your client will not receive any callback when a user gets deleted - so the deletion of the user on the client-side must not be forgotten. Of course you may still use the callback URL even for just one client, if you want to implement the deletion of the user on the client-side via the callback from finAPI.<p> The maximum allowed length of the URL is 512. If you have previously set a callback URL and now want to clear it (thus disabling user synchronization related notifications for this client), you can pass an empty string (\"\").")
  public String getUserSynchronizationCallbackUrl() {
    return userSynchronizationCallbackUrl;
  }

  public void setUserSynchronizationCallbackUrl(String userSynchronizationCallbackUrl) {
    this.userSynchronizationCallbackUrl = userSynchronizationCallbackUrl;
  }

  public ClientConfigurationParams refreshTokensValidityPeriod(Integer refreshTokensValidityPeriod) {
    this.refreshTokensValidityPeriod = refreshTokensValidityPeriod;
    return this;
  }

   /**
   * The validity period that newly requested refresh tokens initially have (in seconds). The value must be greater than or equal to 60, or 0. A value of 0 means that the tokens never expire (Unless explicitly invalidated, e.g. by revocation , or when a user gets locked, or when the password is reset for a user).
   * @return refreshTokensValidityPeriod
  **/
  @ApiModelProperty(value = "The validity period that newly requested refresh tokens initially have (in seconds). The value must be greater than or equal to 60, or 0. A value of 0 means that the tokens never expire (Unless explicitly invalidated, e.g. by revocation , or when a user gets locked, or when the password is reset for a user).")
  public Integer getRefreshTokensValidityPeriod() {
    return refreshTokensValidityPeriod;
  }

  public void setRefreshTokensValidityPeriod(Integer refreshTokensValidityPeriod) {
    this.refreshTokensValidityPeriod = refreshTokensValidityPeriod;
  }

  public ClientConfigurationParams userAccessTokensValidityPeriod(Integer userAccessTokensValidityPeriod) {
    this.userAccessTokensValidityPeriod = userAccessTokensValidityPeriod;
    return this;
  }

   /**
   * The validity period that newly requested access tokens for users initially have (in seconds). The value must be greater than or equal to 60, or 0. A value of 0 means that the tokens never expire.
   * @return userAccessTokensValidityPeriod
  **/
  @ApiModelProperty(value = "The validity period that newly requested access tokens for users initially have (in seconds). The value must be greater than or equal to 60, or 0. A value of 0 means that the tokens never expire.")
  public Integer getUserAccessTokensValidityPeriod() {
    return userAccessTokensValidityPeriod;
  }

  public void setUserAccessTokensValidityPeriod(Integer userAccessTokensValidityPeriod) {
    this.userAccessTokensValidityPeriod = userAccessTokensValidityPeriod;
  }

  public ClientConfigurationParams clientAccessTokensValidityPeriod(Integer clientAccessTokensValidityPeriod) {
    this.clientAccessTokensValidityPeriod = clientAccessTokensValidityPeriod;
    return this;
  }

   /**
   * The validity period that newly requested access tokens for clients initially have (in seconds). The value must be greater than or equal to 60, or 0. A value of 0 means that the tokens never expire.
   * @return clientAccessTokensValidityPeriod
  **/
  @ApiModelProperty(value = "The validity period that newly requested access tokens for clients initially have (in seconds). The value must be greater than or equal to 60, or 0. A value of 0 means that the tokens never expire.")
  public Integer getClientAccessTokensValidityPeriod() {
    return clientAccessTokensValidityPeriod;
  }

  public void setClientAccessTokensValidityPeriod(Integer clientAccessTokensValidityPeriod) {
    this.clientAccessTokensValidityPeriod = clientAccessTokensValidityPeriod;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientConfigurationParams clientConfigurationParams = (ClientConfigurationParams) o;
    return Objects.equals(this.userNotificationCallbackUrl, clientConfigurationParams.userNotificationCallbackUrl) &&
        Objects.equals(this.userSynchronizationCallbackUrl, clientConfigurationParams.userSynchronizationCallbackUrl) &&
        Objects.equals(this.refreshTokensValidityPeriod, clientConfigurationParams.refreshTokensValidityPeriod) &&
        Objects.equals(this.userAccessTokensValidityPeriod, clientConfigurationParams.userAccessTokensValidityPeriod) &&
        Objects.equals(this.clientAccessTokensValidityPeriod, clientConfigurationParams.clientAccessTokensValidityPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userNotificationCallbackUrl, userSynchronizationCallbackUrl, refreshTokensValidityPeriod, userAccessTokensValidityPeriod, clientAccessTokensValidityPeriod);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientConfigurationParams {\n");
    
    sb.append("    userNotificationCallbackUrl: ").append(toIndentedString(userNotificationCallbackUrl)).append("\n");
    sb.append("    userSynchronizationCallbackUrl: ").append(toIndentedString(userSynchronizationCallbackUrl)).append("\n");
    sb.append("    refreshTokensValidityPeriod: ").append(toIndentedString(refreshTokensValidityPeriod)).append("\n");
    sb.append("    userAccessTokensValidityPeriod: ").append(toIndentedString(userAccessTokensValidityPeriod)).append("\n");
    sb.append("    clientAccessTokensValidityPeriod: ").append(toIndentedString(clientAccessTokensValidityPeriod)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

