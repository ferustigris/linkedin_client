package ferus.tigris;

import ferus.tigris.client.Responsable;
import ferus.tigris.queries.BaseQuery;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ClientApp {

    public static void main(String[] args) throws IOException, ParseException {
        ClientQueriable client = new Client();
        BaseQuery query = null;

        for(String arg: args) {
            if ("--help".equals(arg)) {
                System.out.println("Usage: java ferus.tigris.Client [--help] [--verbose|-v] [--api=api-name] [--query=query-params...]");
                System.exit(1);
            } else if ("--verbose".equals(arg) || "-v".equals(arg)) {
                System.out.println("Change the verbosity..");
                client = new VerboseClient(client);
            } else if (arg.startsWith("--api=")) {
                // find out which API to instantiate
                String apiName = arg.substring(6);
                query = client.getQuery(apiName);
                if (query == null) {
                    System.out.println("Not defined API: " + apiName);
                    System.exit(1);
                }
                System.out.println("API to query: " + query.getRequestUrl());
            }
        }

        // Check if application configured correctly
        if (args.length == 0) {
            // list of available APIs
            System.out.println(client.getReposList());
            System.exit(0);
        } else if (query == null) {
            System.out.println("Set up API name in --api parameter.");
            System.exit(1);
        } else if (args.length == 1) {
            // list of queries available for the chosen API
            System.out.println("Available endpoints:\n\t" +
                    String.join(", \t", query.endpoints()));
            System.exit(0);
        }

        Responsable response = client.runQuery(query);
        // presenting the results
        System.out.println(response.toString());
    }
}
