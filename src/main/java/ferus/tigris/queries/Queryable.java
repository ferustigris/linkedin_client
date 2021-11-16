package ferus.tigris.queries;

public interface Queryable {

    /**
     * Base url of the API.
     *
     * @return base url.
     */
    String getBaseUrl();

    /**
     * Creates a full request url with current query string.
     *
     * @return string url that can be used to GET.
     */
    String getRequestUrl();
}
