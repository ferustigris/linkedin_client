package ferus.tigris;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class QueryTests {

    @Test
    void populationDefaultQuery() {
        final Map<String, String> defaultExpectedParams = Map.of(
                "measures", "Population"
        );
        PopulationQuery query = new PopulationQuery();
        Map<String, String> params = query.getParams();
        assertEquals(defaultExpectedParams, params);
    }

    @Test
    void populationDrilldownsQuery() {
        final Map<String, String> defaultExpectedParams = Map.of(
                "drilldowns", "Nation",
                "measures", "Population"
        );
        PopulationQuery query = new PopulationQuery();
        query.drillDown("Nation");
        Map<String, String> params = query.getParams();
        assertEquals(defaultExpectedParams, params);
    }

}
