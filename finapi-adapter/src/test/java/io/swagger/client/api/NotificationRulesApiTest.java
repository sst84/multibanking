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


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.BadCredentialsError;
import io.swagger.client.model.ErrorMessage;
import io.swagger.client.model.IdentifierList;
import io.swagger.client.model.NotificationRule;
import io.swagger.client.model.NotificationRuleList;
import io.swagger.client.model.NotificationRuleParams;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for NotificationRulesApi
 */
@Ignore
public class NotificationRulesApiTest {

    private final NotificationRulesApi api = new NotificationRulesApi();

    
    /**
     * Create a new notification rule
     *
     * Create a new notification rule for a specific user. Must pass the user&#39;s access_token.&lt;br/&gt;&lt;br/&gt;Setting up notification rules for a user allows your client application to get notified about changes in the user&#39;s data, e.g. when new transactions were downloaded, an account&#39;s balance has changed, or the user&#39;s banking credentials are no longer correct. Note that currently, this feature is implemented only for finAPI&#39;s automatic batch update, i.e. notification rules are only relevant when the user has activated the automatic updates (and when the automatic batch update is activated in general for your client).&lt;br/&gt;&lt;br/&gt;There are different kinds of notification rules. The kind of a rule is depicted by the &#39;triggerEvent&#39;. The trigger event specifies what data you have to pass when creating a rule (specifically, the contents of the &#39;params&#39; field), on which events finAPI will send notifications to your client application, as well as what data is contained in those notifications. The specifics of the different trigger events are documented in the following article on our Dev Portal: &lt;a href&#x3D;&#39;https://finapi.zendesk.com/hc/en-us/articles/232324608-How-to-create-notification-rules-and-receive-notifications&#39;&gt;How to create notification rules and receive notifications&lt;/a&gt;
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createNotificationRuleTest() throws ApiException {
        NotificationRuleParams body = null;
        NotificationRule response = api.createNotificationRule(body);

        // TODO: test validations
    }
    
    /**
     * Delete all notification rules
     *
     * Delete all notification rules of the user that is authorized by the access_token. Must pass the user&#39;s access_token. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteAllNotificationRulesTest() throws ApiException {
        IdentifierList response = api.deleteAllNotificationRules();

        // TODO: test validations
    }
    
    /**
     * Delete a notification rule
     *
     * Delete a single notification rule of the user that is authorized by the access_token. Must pass the notification rule&#39;s identifier and the user&#39;s access_token.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteNotificationRuleTest() throws ApiException {
        Long id = null;
        api.deleteNotificationRule(id);

        // TODO: test validations
    }
    
    /**
     * Get and search all notification rules
     *
     * Get notification rules of the user that is authorized by the access_token. Must pass the user&#39;s access_token. You can set optional search criteria to get only those notification rules that you are interested in. If you do not specify any search criteria, then this service functions as a &#39;get all&#39; service.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAndSearchAllNotificationRulesTest() throws ApiException {
        List<Long> ids = null;
        String triggerEvent = null;
        Boolean includeDetails = null;
        NotificationRuleList response = api.getAndSearchAllNotificationRules(ids, triggerEvent, includeDetails);

        // TODO: test validations
    }
    
    /**
     * Get a notification rule
     *
     * Get a single notification rule of the user that is authorized by the access_token. Must pass the notification rule&#39;s identifier and the user&#39;s access_token.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getNotificationRuleTest() throws ApiException {
        Long id = null;
        NotificationRule response = api.getNotificationRule(id);

        // TODO: test validations
    }
    
}
