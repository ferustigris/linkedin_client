package ferus.tigris.queries;

import ferus.tigris.repos.ApisRepository;

/**
 * Creates a specific API query by its name.
 */
public class QueryFactory {
    private static ApisRepository apisRepo = new ApisRepository();

    public Queryable createQuery(String apiName) {
        String apiUrl = apisRepo.getApiUrlByName(apiName);

        switch (apiName) {
            case "github": return new GithubQuery(apiUrl);
            case "datausa": return new DataUsaQuery(apiUrl);
            default:
                System.out.println("API name is absent: " + apiName);
        }
        return null;
    }
}
