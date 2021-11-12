package ferus.tigris.queries;

public interface Queryable {

    /**
     * Creates a full request url with current query string.
     *
     * @return string url that can be used to GET.
     */
    String getRequestUrl();
}
