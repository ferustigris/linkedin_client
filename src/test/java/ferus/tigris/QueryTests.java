package ferus.tigris;

import ferus.tigris.queries.BaseQuery;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryTests {

    @Test
    void populationDefaultQuery() {
        final Map<String, String> defaultExpectedParams = Map.of(
                "measures", "Population"
        );
        BaseQuery query = new BaseQuery();
        Map<String, String> params = query.getParams();
        assertEquals(defaultExpectedParams, params);
    }

    @Test
    void populationDrilldownsQuery() {
        final Map<String, String> defaultExpectedParams = Map.of(
                "drilldowns", "Nation",
                "measures", "Population"
        );
        BaseQuery query = new BaseQuery();
        query.drillDown("Nation");
        Map<String, String> params = query.getParams();
        assertEquals(defaultExpectedParams, params);
    }

}
