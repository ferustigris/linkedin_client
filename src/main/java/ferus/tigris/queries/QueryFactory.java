package ferus.tigris.queries;

/**
 * Creates a specific API query by its name.
 */
public class QueryFactory {

    public Queryable createQuery(String apiName) {
        switch (apiName) {
            case "github": return new GithubQuery();
            case "datausa": return new DataUsaQuery();
            default:
                System.out.println("API name is absent: " + apiName);
        }
        return null;
    }

    public Queryable createQuery(String apiName, String path, String... params) {
        switch (apiName) {
            case "github": return new GithubQuery(path, params);
            case "datausa": return new DataUsaQuery(path, params);
            default:
                System.out.println("API name is absent: " + apiName);
        }
        return null;
    }
}
