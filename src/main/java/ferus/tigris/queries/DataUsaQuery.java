package ferus.tigris.queries;

/**
 * Queryies datausa.io public API.
 */
public class DataUsaQuery extends BaseQuery {
    public static final String API_DATA = "https://datausa.io/api/data";

    public DataUsaQuery() {
        super(API_DATA);
        params.put("measures", "Population");
    }

    public DataUsaQuery(String properties) {
        super(API_DATA, properties);
    }

    public DataUsaQuery(String path, String... properties) {
        super(API_DATA, path, properties);
    }

    public void drillDown(String param) {
        params.put("drilldowns", param);
    }
}
