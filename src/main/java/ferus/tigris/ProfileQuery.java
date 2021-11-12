package ferus.tigris;

import java.util.HashMap;
import java.util.Map;

public class ProfileQuery implements Queryable {
    final Map<String, String> params = new HashMap<>();

    public ProfileQuery() {
        params.put("measures", "Population");
    }

    public ProfileQuery(String measures) {
        params.put("measures", measures);
    }

    @Override
    public String getQueryString() {
        return getParams().entrySet().stream().map((entry) -> entry.getKey() + "=" + entry.getValue())
                .reduce((k, v) -> k + "&" + v).orElseGet(() -> "");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    public void drillDown(String param) {
        params.put("drilldowns", param);
    }
}
