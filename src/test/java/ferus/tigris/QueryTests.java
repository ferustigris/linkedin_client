package ferus.tigris;

import ferus.tigris.queries.BaseQuery;
import ferus.tigris.queries.DataUsaQuery;
import ferus.tigris.queries.GithubQuery;
import ferus.tigris.queries.Queryable;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryTests {

    @Test
    void populationDefaultQuery() {
        final Map<String, String> defaultExpectedParams = Map.of(
                "measures", "Population"
        );
        BaseQuery query = new DataUsaQuery();
        Map<String, String> params = query.getParams();
        assertEquals(defaultExpectedParams, params);
    }

    @Test
    void propertyQuery() {
        final Map<String, String> defaultExpectedParams = Map.of(
                "measures", "Population"
        );
        BaseQuery query = new DataUsaQuery("", "measures=Population");
        Map<String, String> params = query.getParams();
        assertEquals(defaultExpectedParams, params);
    }

    @Test
    void populationDrilldownsQuery() {
        final Map<String, String> defaultExpectedParams = Map.of(
                "drilldowns", "Nation",
                "measures", "Population"
        );
        DataUsaQuery query = new DataUsaQuery();
        query.drillDown("Nation");
        Map<String, String> params = query.getParams();
        assertEquals(defaultExpectedParams, params);
    }

    @Test
    public void testGithubDefaultQuery() {
        Queryable query = new GithubQuery();
        assertEquals(GithubQuery.API_DATA + "/organizations", query.getRequestUrl());
    }
}
