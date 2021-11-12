package ferus.tigris.queries;

import java.util.HashMap;
import java.util.Map;

public class BaseQuery implements Queryable {
    protected final String baseUrl;
    protected final Map<String, String> params = new HashMap<>();

    public BaseQuery(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public BaseQuery(String baseUrl, String measures) {
        this.baseUrl = baseUrl;
        params.put("measures", measures);
    }

    @Override
    public String getAPIBaseUrl() {
        return baseUrl;
    }

    @Override
    public String getQueryString() {
        return "";
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

    public void drillDown(String param) {
        params.put("drilldowns", param);
    }
}
