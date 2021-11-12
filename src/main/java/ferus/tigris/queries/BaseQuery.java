package ferus.tigris.queries;

import java.util.HashMap;
import java.util.Map;

public class BaseQuery implements Queryable {
    protected final String baseUrl;
    protected final String path;
    protected final Map<String, String> params = new HashMap<>();

    public BaseQuery(String baseUrl) {
        this(baseUrl, "", null);
    }

    public BaseQuery(String baseUrl, String path) {
        this(baseUrl, path, null);
    }

    public BaseQuery(String baseUrl, String path, String... properties) {
        this.baseUrl = baseUrl;
        this.path = path;
        // parse properties if any
        if (properties != null) {
            for (String nameValue : properties) {
                String[] split = nameValue.trim().split("=");
                params.put(split[0].trim(), split[1].trim());
            }
        }
    }

    protected String getAPIBaseUrl() {
        return baseUrl;
    }

    protected String getQueryString() {
        return path;
    }

    /**
     * Params that used in the query to create {@link #getQueryString()}.
     *
     * @return map of the params.
     */
    public Map<String, String> getParams() {
        return params;
    }

    protected String getQueryParams() {
        String queryParams = params.entrySet().stream()
                .map((entry) -> entry.getKey() + "=" + entry.getValue())
                .reduce((k, v) -> k + "&" + v).orElse(null);
        return queryParams != null ? "?" + queryParams : "";
    }

    @Override
    public String getRequestUrl() {
        return getAPIBaseUrl() + getQueryString() + getQueryParams();
    }
}
