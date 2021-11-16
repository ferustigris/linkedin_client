package ferus.tigris.repos;

/**
 * Contains all available APIs that might be queried.
 */
public class ApisRepository {
    // repository of available APIs
    private static final String[] APIS = {
            "https://datausa.io/api/data",
            "https://api.github.com"
    };

    public String getApiUrlByName(String name) {
        for (String api : APIS) {
            if (api.contains(name)) {
                return api;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String list = String.join("\n", APIS);
        return "ApisRepository{\n" + list + "\n}";
    }
}
