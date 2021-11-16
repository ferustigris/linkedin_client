package ferus.tigris.queries;

import java.util.*;

public class BaseQuery implements Queryable, SchemaAware {
    protected final String baseUrl;
    protected final String path;
    protected final Map<String, Map<String, String>> endpoints = new HashMap<>();

    public BaseQuery(String baseUrl) {
        this(baseUrl, "", null);
    }

    public BaseQuery(String baseUrl, String path) {
        this(baseUrl, path, null);
    }

    public BaseQuery(String baseUrl, String path, String... properties) {
        this.baseUrl = baseUrl;
        this.path = path;
        Map<String, String> params = parseParams(properties);
        endpoints.put(this.path, params);
    }

    /**
     * Parse properties if any.
     *
     * @param properties to parse
     * @return map of name-value pairs or null.
     */
    protected Map<String, String> parseParams(String... properties) {
        if (properties != null) {
            Map<String, String> temp = new HashMap<>();
            for (String nameValue : properties) {
                String[] split = nameValue.trim().split("=");
                temp.put(split[0].trim(), split[1].trim());
            }
            return temp;
        }
        return null;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    protected String getQueryString() {
        return path;
    }

    /**
     * Params that used in the query to create {@link #getQueryParams()}.
     *
     * @return map of the params.
     */
    public Map<String, String> getParams() {
        Map<String, String> empty = Collections.emptyMap();
        Map<String, String> params = endpoints.getOrDefault(path, empty);
        return params != null ? params : empty;
    }

    protected String getQueryParams() {
        String queryParams = getParams().entrySet().stream()
                .map((entry) -> entry.getKey() + "=" + entry.getValue())
                .reduce((k, v) -> k + "&" + v).orElse(null);
        return queryParams != null ? "?" + queryParams : "";
    }

    @Override
    public String getRequestUrl() {
        return getBaseUrl() + getQueryString() + getQueryParams();
    }

    @Override
    public List<String> endpoints() {
        return new ArrayList<>(endpoints.keySet());
    }

    @Override
    public Map<String, String> parameters(String endpoint) {
        return endpoints.getOrDefault(endpoint, null);
    }
}
