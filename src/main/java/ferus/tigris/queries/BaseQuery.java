package ferus.tigris.queries;

import java.util.HashMap;
import java.util.Map;

public class BaseQuery implements Queryable {
    private final String baseUrl;
    private final Map<String, String> params = new HashMap<>();

    public BaseQuery() {
        this.baseUrl = "https://datausa.io/api/data";
        params.put("measures", "Population");
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
