package ferus.tigris;

import ferus.tigris.queries.*;
import ferus.tigris.repos.ApisRepository;

public class Client {
    private static final ApisRepository apisRepo = new ApisRepository();
    private static final QueryFactory queryFactory = new QueryFactory();

    public static void main(String[] args) {
        if (args.length == 0) {
            // list of available APIs
            System.out.println(apisRepo);
            System.exit(0);
        } else if ("--help".equals(args[0])) {
            System.out.println("Usage: java rest_api_client [--api=api-name] [--query=query-params...]");
            System.exit(1);
        }

        Queryable query = null;
        if (args[0].startsWith("--api=")) {
            String apiName = args[0].substring(6);
            query = queryFactory.createQuery(apiName);
            if (query == null) {
                System.exit(1);
            }
        } else {
            System.out.println("API name not found.");
            System.exit(1);
        }

        if (args.length == 1) {
            // list of queries available for the chosen API
            System.out.println(query.getAPIBaseUrl());
            System.exit(0);
        }

        RestApiClient client = new RestApiClient(new RestReader());
        Responsable response = client.run(query);

        System.out.println(response.toString());
    }
}
