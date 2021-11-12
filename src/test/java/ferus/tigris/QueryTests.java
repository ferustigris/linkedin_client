package ferus.tigris;

import ferus.tigris.queries.BaseQuery;
import ferus.tigris.queries.DataUsaQuery;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryTests {

    public static final String API_DATA = "https://datausa.io/api/data";

    @Test
    void populationDefaultQuery() {
        final Map<String, String> defaultExpectedParams = Map.of(
                "measures", "Population"
        );
        BaseQuery query = new DataUsaQuery(API_DATA);
        Map<String, String> params = query.getParams();
        assertEquals(defaultExpectedParams, params);
    }

    @Test
    void populationDrilldownsQuery() {
        final Map<String, String> defaultExpectedParams = Map.of(
                "drilldowns", "Nation",
                "measures", "Population"
        );
        BaseQuery query = new DataUsaQuery(API_DATA);
        query.drillDown("Nation");
        Map<String, String> params = query.getParams();
        assertEquals(defaultExpectedParams, params);
    }

}
