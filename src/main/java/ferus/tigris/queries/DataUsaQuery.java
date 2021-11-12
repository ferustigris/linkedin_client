package ferus.tigris.queries;

/**
 *
 */
public class DataUsaQuery extends BaseQuery {

    public DataUsaQuery(String baseUrl) {
        super(baseUrl);
        params.put("measures", "Population");
    }
}
