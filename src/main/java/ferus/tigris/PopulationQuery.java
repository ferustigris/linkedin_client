package ferus.tigris;

import java.util.HashMap;
import java.util.Map;

public class PopulationQuery implements ferus.tigris.IQuery {
    final Map<String, String> params = new HashMap<>();

    public PopulationQuery() {
        params.put("measures", "Population");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    public void drillDown(String param) {
        params.put("drilldowns", param);
    }
}
