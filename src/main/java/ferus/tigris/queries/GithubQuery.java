package ferus.tigris.queries;

/**
 * Queries github.com public API.
 */
public class GithubQuery extends BaseQuery {
    public static final String API_DATA = "https://api.github.com";

    public GithubQuery() {
        super(API_DATA, "/organizations");
        // init meta-info about other endpoints
        this.endpoints.put("/search/code", parseParams("q=addClass+in:file+language:js+repo:jquery/jquery"));
    }

    public GithubQuery(String path) {
        super(API_DATA, path);
    }

    public GithubQuery(String path, String... properties) {
        super(API_DATA, path, properties);
    }
}
