package ferus.tigris.queries;

import java.util.Map;

public interface Queryable {
    /**
     * Base url that the query uses to access the API.
     *
     * @return base url of the API.
     */
    String getAPIBaseUrl();

    /**
     * Path variables and/or query url-params.
     *
     * @return query string that both with {{@link #getAPIBaseUrl()}}
     * allows to create a request to the API.
     */
    String getQueryString();

    /**
     * Params that used in the query to create {@link #getQueryString()}.
     *
     * @return map of the params.
     */
    Map<String, String> getParams();

    /**
     * Params from {@link #getParams()} in form on url.
     *
     * @return url query params.
     */
    String getQueryParams();

    /**
     * Creates a full request url with current query string.
     *
     * @return string url that can be used to GET.
     */
    String getRequestUrl();
}
