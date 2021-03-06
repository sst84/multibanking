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

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.BadCredentialsError;
import io.swagger.client.model.Bank;
import io.swagger.client.model.BankList;
import io.swagger.client.model.ErrorMessage;
import io.swagger.client.model.PageableBankList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BanksApi {
    private ApiClient apiClient;

    public BanksApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BanksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getAndSearchAllBanks
     * @param ids A comma-separated list of bank identifiers. If specified, then only banks whose identifier match any of the given identifiers will be regarded. The maximum number of identifiers is 1000. (optional)
     * @param search If specified, then only those banks will be contained in the result whose &#39;name&#39;, &#39;blz&#39;, &#39;bic&#39; or &#39;city&#39; contains the given search string (the matching works case-insensitive). If no banks contain the search string in any of the regarded fields, then the result will be an empty list. Note that you may also pass an IBAN in this field, in which case finAPI will try to find the related bank in its database and regard only this bank for the search. Also note: If the given search string consists of several terms (separated by whitespace), then ALL of these terms must apply to a bank in order for it to get included into the result. (optional)
     * @param isSupported If specified, then only supported (in case of &#39;true&#39; value) or unsupported (in case of &#39;false&#39; value) banks will be regarded. (optional)
     * @param pinsAreVolatile If specified, then only those banks will be regarded that have the given value (true or false) for their &#39;pinsAreVolatile&#39; field. (optional)
     * @param supportedDataSources Comma-separated list of data sources. Possible values: WEB_SCRAPER,FINTS_SERVER. If this parameter is specified, then only those banks will be regarded in the search that support ALL of the given data sources. Note that this does NOT imply that those data sources must be the only data sources that are supported by a bank. (optional)
     * @param location Comma-separated list of two-letter country codes (ISO 3166 ALPHA-2). If set, then only those banks will be regarded in the search that are located in the specified countries. Notes: Banks which do not have a location set (i.e. international institutes) will ALWAYS be regarded in the search, independent of what you specify for this field. When you pass a country code that doesn&#39;t exist in the ISO 3166 ALPHA-2 standard, then the service will respond with 400 BAD_REQUEST. (optional)
     * @param isTestBank If specified, then only those banks will be regarded that have the given value (true or false) for their &#39;isTestBank&#39; field. (optional)
     * @param page Result page that you want to retrieve. (optional, default to 1)
     * @param perPage Maximum number of records per page. Can be at most 500. NOTE: Due to its validation and visualization, the swagger frontend might show very low performance, or even crashes, when a service responds with a lot of data. It is recommended to use a HTTP client like Postman or DHC instead of our swagger frontend for service calls with large page sizes. (optional, default to 20)
     * @param order Determines the order of the results. You can order the results by &#39;id&#39;, &#39;name&#39;, &#39;blz&#39;, &#39;bic&#39; or &#39;popularity&#39;. The default order for all services is &#39;id,asc&#39;. You can also order by multiple properties. In that case the order of the parameters passed is important. Example: &#39;/banks?order&#x3D;name,desc&amp;order&#x3D;id,asc&#39; will return banks ordered by &#39;name&#39; (descending), where banks with the same &#39;name&#39; are ordered by &#39;id&#39; (ascending). The general format is: &#39;property[,asc|desc]&#39;, with &#39;asc&#39; being the default value. Please note that ordering by multiple fields is not supported in our swagger frontend, but you can test this feature with any HTTP tool of your choice (e.g. postman or DHC).  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getAndSearchAllBanksCall(List<Long> ids, String search, Boolean isSupported, Boolean pinsAreVolatile, List<String> supportedDataSources, List<String> location, Boolean isTestBank, Integer page, Integer perPage, List<String> order, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/banks";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (ids != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "ids", ids));
        if (search != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("search", search));
        if (isSupported != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("isSupported", isSupported));
        if (pinsAreVolatile != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("pinsAreVolatile", pinsAreVolatile));
        if (supportedDataSources != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "supportedDataSources", supportedDataSources));
        if (location != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "location", location));
        if (isTestBank != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("isTestBank", isTestBank));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (perPage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("perPage", perPage));
        if (order != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "order", order));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "finapi_auth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAndSearchAllBanksValidateBeforeCall(List<Long> ids, String search, Boolean isSupported, Boolean pinsAreVolatile, List<String> supportedDataSources, List<String> location, Boolean isTestBank, Integer page, Integer perPage, List<String> order, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getAndSearchAllBanksCall(ids, search, isSupported, pinsAreVolatile, supportedDataSources, location, isTestBank, page, perPage, order, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get and search all banks
     * Get and search banks from finAPI&#39;s database of banks. Must pass the authorized user&#39;s access_token, or your client&#39;s access_token. You can set optional search criteria to get only those banks that you are interested in. If you do not specify any search criteria, then this service functions as a &#39;get all&#39; service.
     * @param ids A comma-separated list of bank identifiers. If specified, then only banks whose identifier match any of the given identifiers will be regarded. The maximum number of identifiers is 1000. (optional)
     * @param search If specified, then only those banks will be contained in the result whose &#39;name&#39;, &#39;blz&#39;, &#39;bic&#39; or &#39;city&#39; contains the given search string (the matching works case-insensitive). If no banks contain the search string in any of the regarded fields, then the result will be an empty list. Note that you may also pass an IBAN in this field, in which case finAPI will try to find the related bank in its database and regard only this bank for the search. Also note: If the given search string consists of several terms (separated by whitespace), then ALL of these terms must apply to a bank in order for it to get included into the result. (optional)
     * @param isSupported If specified, then only supported (in case of &#39;true&#39; value) or unsupported (in case of &#39;false&#39; value) banks will be regarded. (optional)
     * @param pinsAreVolatile If specified, then only those banks will be regarded that have the given value (true or false) for their &#39;pinsAreVolatile&#39; field. (optional)
     * @param supportedDataSources Comma-separated list of data sources. Possible values: WEB_SCRAPER,FINTS_SERVER. If this parameter is specified, then only those banks will be regarded in the search that support ALL of the given data sources. Note that this does NOT imply that those data sources must be the only data sources that are supported by a bank. (optional)
     * @param location Comma-separated list of two-letter country codes (ISO 3166 ALPHA-2). If set, then only those banks will be regarded in the search that are located in the specified countries. Notes: Banks which do not have a location set (i.e. international institutes) will ALWAYS be regarded in the search, independent of what you specify for this field. When you pass a country code that doesn&#39;t exist in the ISO 3166 ALPHA-2 standard, then the service will respond with 400 BAD_REQUEST. (optional)
     * @param isTestBank If specified, then only those banks will be regarded that have the given value (true or false) for their &#39;isTestBank&#39; field. (optional)
     * @param page Result page that you want to retrieve. (optional, default to 1)
     * @param perPage Maximum number of records per page. Can be at most 500. NOTE: Due to its validation and visualization, the swagger frontend might show very low performance, or even crashes, when a service responds with a lot of data. It is recommended to use a HTTP client like Postman or DHC instead of our swagger frontend for service calls with large page sizes. (optional, default to 20)
     * @param order Determines the order of the results. You can order the results by &#39;id&#39;, &#39;name&#39;, &#39;blz&#39;, &#39;bic&#39; or &#39;popularity&#39;. The default order for all services is &#39;id,asc&#39;. You can also order by multiple properties. In that case the order of the parameters passed is important. Example: &#39;/banks?order&#x3D;name,desc&amp;order&#x3D;id,asc&#39; will return banks ordered by &#39;name&#39; (descending), where banks with the same &#39;name&#39; are ordered by &#39;id&#39; (ascending). The general format is: &#39;property[,asc|desc]&#39;, with &#39;asc&#39; being the default value. Please note that ordering by multiple fields is not supported in our swagger frontend, but you can test this feature with any HTTP tool of your choice (e.g. postman or DHC).  (optional)
     * @return PageableBankList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PageableBankList getAndSearchAllBanks(List<Long> ids, String search, Boolean isSupported, Boolean pinsAreVolatile, List<String> supportedDataSources, List<String> location, Boolean isTestBank, Integer page, Integer perPage, List<String> order) throws ApiException {
        ApiResponse<PageableBankList> resp = getAndSearchAllBanksWithHttpInfo(ids, search, isSupported, pinsAreVolatile, supportedDataSources, location, isTestBank, page, perPage, order);
        return resp.getData();
    }

    /**
     * Get and search all banks
     * Get and search banks from finAPI&#39;s database of banks. Must pass the authorized user&#39;s access_token, or your client&#39;s access_token. You can set optional search criteria to get only those banks that you are interested in. If you do not specify any search criteria, then this service functions as a &#39;get all&#39; service.
     * @param ids A comma-separated list of bank identifiers. If specified, then only banks whose identifier match any of the given identifiers will be regarded. The maximum number of identifiers is 1000. (optional)
     * @param search If specified, then only those banks will be contained in the result whose &#39;name&#39;, &#39;blz&#39;, &#39;bic&#39; or &#39;city&#39; contains the given search string (the matching works case-insensitive). If no banks contain the search string in any of the regarded fields, then the result will be an empty list. Note that you may also pass an IBAN in this field, in which case finAPI will try to find the related bank in its database and regard only this bank for the search. Also note: If the given search string consists of several terms (separated by whitespace), then ALL of these terms must apply to a bank in order for it to get included into the result. (optional)
     * @param isSupported If specified, then only supported (in case of &#39;true&#39; value) or unsupported (in case of &#39;false&#39; value) banks will be regarded. (optional)
     * @param pinsAreVolatile If specified, then only those banks will be regarded that have the given value (true or false) for their &#39;pinsAreVolatile&#39; field. (optional)
     * @param supportedDataSources Comma-separated list of data sources. Possible values: WEB_SCRAPER,FINTS_SERVER. If this parameter is specified, then only those banks will be regarded in the search that support ALL of the given data sources. Note that this does NOT imply that those data sources must be the only data sources that are supported by a bank. (optional)
     * @param location Comma-separated list of two-letter country codes (ISO 3166 ALPHA-2). If set, then only those banks will be regarded in the search that are located in the specified countries. Notes: Banks which do not have a location set (i.e. international institutes) will ALWAYS be regarded in the search, independent of what you specify for this field. When you pass a country code that doesn&#39;t exist in the ISO 3166 ALPHA-2 standard, then the service will respond with 400 BAD_REQUEST. (optional)
     * @param isTestBank If specified, then only those banks will be regarded that have the given value (true or false) for their &#39;isTestBank&#39; field. (optional)
     * @param page Result page that you want to retrieve. (optional, default to 1)
     * @param perPage Maximum number of records per page. Can be at most 500. NOTE: Due to its validation and visualization, the swagger frontend might show very low performance, or even crashes, when a service responds with a lot of data. It is recommended to use a HTTP client like Postman or DHC instead of our swagger frontend for service calls with large page sizes. (optional, default to 20)
     * @param order Determines the order of the results. You can order the results by &#39;id&#39;, &#39;name&#39;, &#39;blz&#39;, &#39;bic&#39; or &#39;popularity&#39;. The default order for all services is &#39;id,asc&#39;. You can also order by multiple properties. In that case the order of the parameters passed is important. Example: &#39;/banks?order&#x3D;name,desc&amp;order&#x3D;id,asc&#39; will return banks ordered by &#39;name&#39; (descending), where banks with the same &#39;name&#39; are ordered by &#39;id&#39; (ascending). The general format is: &#39;property[,asc|desc]&#39;, with &#39;asc&#39; being the default value. Please note that ordering by multiple fields is not supported in our swagger frontend, but you can test this feature with any HTTP tool of your choice (e.g. postman or DHC).  (optional)
     * @return ApiResponse&lt;PageableBankList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PageableBankList> getAndSearchAllBanksWithHttpInfo(List<Long> ids, String search, Boolean isSupported, Boolean pinsAreVolatile, List<String> supportedDataSources, List<String> location, Boolean isTestBank, Integer page, Integer perPage, List<String> order) throws ApiException {
        com.squareup.okhttp.Call call = getAndSearchAllBanksValidateBeforeCall(ids, search, isSupported, pinsAreVolatile, supportedDataSources, location, isTestBank, page, perPage, order, null, null);
        Type localVarReturnType = new TypeToken<PageableBankList>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get and search all banks (asynchronously)
     * Get and search banks from finAPI&#39;s database of banks. Must pass the authorized user&#39;s access_token, or your client&#39;s access_token. You can set optional search criteria to get only those banks that you are interested in. If you do not specify any search criteria, then this service functions as a &#39;get all&#39; service.
     * @param ids A comma-separated list of bank identifiers. If specified, then only banks whose identifier match any of the given identifiers will be regarded. The maximum number of identifiers is 1000. (optional)
     * @param search If specified, then only those banks will be contained in the result whose &#39;name&#39;, &#39;blz&#39;, &#39;bic&#39; or &#39;city&#39; contains the given search string (the matching works case-insensitive). If no banks contain the search string in any of the regarded fields, then the result will be an empty list. Note that you may also pass an IBAN in this field, in which case finAPI will try to find the related bank in its database and regard only this bank for the search. Also note: If the given search string consists of several terms (separated by whitespace), then ALL of these terms must apply to a bank in order for it to get included into the result. (optional)
     * @param isSupported If specified, then only supported (in case of &#39;true&#39; value) or unsupported (in case of &#39;false&#39; value) banks will be regarded. (optional)
     * @param pinsAreVolatile If specified, then only those banks will be regarded that have the given value (true or false) for their &#39;pinsAreVolatile&#39; field. (optional)
     * @param supportedDataSources Comma-separated list of data sources. Possible values: WEB_SCRAPER,FINTS_SERVER. If this parameter is specified, then only those banks will be regarded in the search that support ALL of the given data sources. Note that this does NOT imply that those data sources must be the only data sources that are supported by a bank. (optional)
     * @param location Comma-separated list of two-letter country codes (ISO 3166 ALPHA-2). If set, then only those banks will be regarded in the search that are located in the specified countries. Notes: Banks which do not have a location set (i.e. international institutes) will ALWAYS be regarded in the search, independent of what you specify for this field. When you pass a country code that doesn&#39;t exist in the ISO 3166 ALPHA-2 standard, then the service will respond with 400 BAD_REQUEST. (optional)
     * @param isTestBank If specified, then only those banks will be regarded that have the given value (true or false) for their &#39;isTestBank&#39; field. (optional)
     * @param page Result page that you want to retrieve. (optional, default to 1)
     * @param perPage Maximum number of records per page. Can be at most 500. NOTE: Due to its validation and visualization, the swagger frontend might show very low performance, or even crashes, when a service responds with a lot of data. It is recommended to use a HTTP client like Postman or DHC instead of our swagger frontend for service calls with large page sizes. (optional, default to 20)
     * @param order Determines the order of the results. You can order the results by &#39;id&#39;, &#39;name&#39;, &#39;blz&#39;, &#39;bic&#39; or &#39;popularity&#39;. The default order for all services is &#39;id,asc&#39;. You can also order by multiple properties. In that case the order of the parameters passed is important. Example: &#39;/banks?order&#x3D;name,desc&amp;order&#x3D;id,asc&#39; will return banks ordered by &#39;name&#39; (descending), where banks with the same &#39;name&#39; are ordered by &#39;id&#39; (ascending). The general format is: &#39;property[,asc|desc]&#39;, with &#39;asc&#39; being the default value. Please note that ordering by multiple fields is not supported in our swagger frontend, but you can test this feature with any HTTP tool of your choice (e.g. postman or DHC).  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAndSearchAllBanksAsync(List<Long> ids, String search, Boolean isSupported, Boolean pinsAreVolatile, List<String> supportedDataSources, List<String> location, Boolean isTestBank, Integer page, Integer perPage, List<String> order, final ApiCallback<PageableBankList> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAndSearchAllBanksValidateBeforeCall(ids, search, isSupported, pinsAreVolatile, supportedDataSources, location, isTestBank, page, perPage, order, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PageableBankList>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getBank
     * @param id Identifier of requested bank (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getBankCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/banks/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "finapi_auth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getBankValidateBeforeCall(Long id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getBank(Async)");
        }
        

        com.squareup.okhttp.Call call = getBankCall(id, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a bank
     * Get a single bank from finAPI&#39;s database of banks. You have to pass the bank&#39;s identifier, and either the authorized user&#39;s access_token, or your client&#39;s access token.
     * @param id Identifier of requested bank (required)
     * @return Bank
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Bank getBank(Long id) throws ApiException {
        ApiResponse<Bank> resp = getBankWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Get a bank
     * Get a single bank from finAPI&#39;s database of banks. You have to pass the bank&#39;s identifier, and either the authorized user&#39;s access_token, or your client&#39;s access token.
     * @param id Identifier of requested bank (required)
     * @return ApiResponse&lt;Bank&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Bank> getBankWithHttpInfo(Long id) throws ApiException {
        com.squareup.okhttp.Call call = getBankValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<Bank>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a bank (asynchronously)
     * Get a single bank from finAPI&#39;s database of banks. You have to pass the bank&#39;s identifier, and either the authorized user&#39;s access_token, or your client&#39;s access token.
     * @param id Identifier of requested bank (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getBankAsync(Long id, final ApiCallback<Bank> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getBankValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Bank>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getMultipleBanks
     * @param ids Comma-separated list of identifiers of requested banks (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @deprecated
     */
    @Deprecated
    public com.squareup.okhttp.Call getMultipleBanksCall(List<Long> ids, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/banks/{ids}"
            .replaceAll("\\{" + "ids" + "\\}", apiClient.escapeString(ids.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "finapi_auth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @Deprecated
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getMultipleBanksValidateBeforeCall(List<Long> ids, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'ids' is set
        if (ids == null) {
            throw new ApiException("Missing the required parameter 'ids' when calling getMultipleBanks(Async)");
        }
        

        com.squareup.okhttp.Call call = getMultipleBanksCall(ids, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get multiple banks
     * Get a list of multiple banks from finAPI&#39;s database of banks. You have to pass a list of bank identifiers, and either the authorized user&#39;s access_token, or your client&#39;s access token. Note that banks whose identifiers do not exist will not be contained in the result (If this applies to all of the given identifiers, then the result will be an empty list).&lt;br/&gt;&lt;br/&gt;&lt;b&gt;WARNING&lt;/b&gt;: This service is deprecated and will be removed at some point. If you want to get multiple banks, please instead use the service &#39;Get and search all banks&#39; and pass a comma-separated list of identifiers with the parameter &#39;ids&#39;.
     * @param ids Comma-separated list of identifiers of requested banks (required)
     * @return BankList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @deprecated
     */
    @Deprecated
    public BankList getMultipleBanks(List<Long> ids) throws ApiException {
        ApiResponse<BankList> resp = getMultipleBanksWithHttpInfo(ids);
        return resp.getData();
    }

    /**
     * Get multiple banks
     * Get a list of multiple banks from finAPI&#39;s database of banks. You have to pass a list of bank identifiers, and either the authorized user&#39;s access_token, or your client&#39;s access token. Note that banks whose identifiers do not exist will not be contained in the result (If this applies to all of the given identifiers, then the result will be an empty list).&lt;br/&gt;&lt;br/&gt;&lt;b&gt;WARNING&lt;/b&gt;: This service is deprecated and will be removed at some point. If you want to get multiple banks, please instead use the service &#39;Get and search all banks&#39; and pass a comma-separated list of identifiers with the parameter &#39;ids&#39;.
     * @param ids Comma-separated list of identifiers of requested banks (required)
     * @return ApiResponse&lt;BankList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @deprecated
     */
    @Deprecated
    public ApiResponse<BankList> getMultipleBanksWithHttpInfo(List<Long> ids) throws ApiException {
        com.squareup.okhttp.Call call = getMultipleBanksValidateBeforeCall(ids, null, null);
        Type localVarReturnType = new TypeToken<BankList>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get multiple banks (asynchronously)
     * Get a list of multiple banks from finAPI&#39;s database of banks. You have to pass a list of bank identifiers, and either the authorized user&#39;s access_token, or your client&#39;s access token. Note that banks whose identifiers do not exist will not be contained in the result (If this applies to all of the given identifiers, then the result will be an empty list).&lt;br/&gt;&lt;br/&gt;&lt;b&gt;WARNING&lt;/b&gt;: This service is deprecated and will be removed at some point. If you want to get multiple banks, please instead use the service &#39;Get and search all banks&#39; and pass a comma-separated list of identifiers with the parameter &#39;ids&#39;.
     * @param ids Comma-separated list of identifiers of requested banks (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @deprecated
     */
    @Deprecated
    public com.squareup.okhttp.Call getMultipleBanksAsync(List<Long> ids, final ApiCallback<BankList> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getMultipleBanksValidateBeforeCall(ids, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<BankList>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
