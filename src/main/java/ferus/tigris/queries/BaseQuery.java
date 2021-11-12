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

    @Override
    public String getAPIBaseUrl() {
        return baseUrl;
    }

    @Override
    public String getQueryString() {
        return path;
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public String getQueryParams() {
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
