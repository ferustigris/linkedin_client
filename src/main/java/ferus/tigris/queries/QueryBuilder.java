package ferus.tigris.queries;

/**
 * Allows using Builder pattern to create a query.
 */
public class QueryBuilder {
    private String path;
    private String[] properties;

    public QueryBuilder() {
        super();
    }

    public QueryBuilder addEndpoint(String path) {
        this.path = path;
        return this;
    }

    public QueryBuilder addEndpoint(String path, String... properties) {
        this.path = path;
        this.properties = properties;
        return this;
    }

    public GithubQuery buildGithubQuery() {
        return new GithubQuery(path, properties);
    }

    public DataUsaQuery buildDataUsaQuery() {
        return new DataUsaQuery(path, properties);
    }
}
