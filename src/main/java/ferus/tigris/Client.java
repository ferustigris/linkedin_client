package ferus.tigris;

import ferus.tigris.client.Responsible;
import ferus.tigris.client.RestApiClient;
import ferus.tigris.client.RestReader;
import ferus.tigris.queries.*;
import ferus.tigris.repos.ApisRepository;

import java.util.Arrays;

public class Client {
    private static final ApisRepository apisRepo = new ApisRepository();
    private static final QueryFactory queryFactory = new QueryFactory();
    public static final String API_ARG = "--api=";
    public static final String ENDPOINT_ARG = "--endpoint=";
    public static final String CLIENT_APP = "ferus.tigris.Client";

    public static void main(String[] args) {
        if (args.length == 0) {
            // list of available APIs
            System.out.println(apisRepo);
            System.out.println("Usage: java " + CLIENT_APP + " --help");
            System.exit(0);
        } else if ("--help".equals(args[0])) {
            System.out.println("Usage: java " + CLIENT_APP + " [" + API_ARG + "api-name] [" + ENDPOINT_ARG + "endpoint-name] [params...]");
            System.exit(1);
        }

        BaseQuery query = null;
        // find out which API to instantiate
        if (args[0].startsWith(API_ARG)) {
            String apiName = args[0].substring(API_ARG.length());
            query = (BaseQuery) queryFactory.createQuery(apiName);
            if (query == null) {
                System.out.println("Not defined API: " + apiName);
                System.exit(1);
            }
            System.out.println("API to query: " + query.getBaseUrl());
        } else {
            System.out.println("Set up API name in --api parameter.");
            System.exit(1);
        }

        if (args.length == 1) {
            // list of queries available for the chosen API
            System.out.println("Available endpoints:\n\t" +
                    String.join(", \n\t", query.endpoints()));
            System.exit(0);
        }

        if (args[1].startsWith(ENDPOINT_ARG)) {
            String apiName = args[0].substring(API_ARG.length());
            String endpoint = args[1].substring(ENDPOINT_ARG.length());
            String[] params = Arrays.copyOfRange(args, 2, 2 + args.length - 2);
            query = (BaseQuery) queryFactory.createQuery(apiName, endpoint, params);
            System.out.println("Request: " + query.getRequestUrl());
        }

        // instantiate the chosen query and execute it
        RestApiClient client = new RestApiClient(new RestReader());
        Responsible response = client.run(query);
        // presenting the results
        System.out.println("Response:\n" + response.toString());
    }
}
