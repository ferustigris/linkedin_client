package ferus.tigris;

public class Client {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java rest_api_client Population");
            System.exit(1);
        }

        RestApiClient client = new RestApiClient(new RestReader());
        IQuery iQuery = new ProfileQuery(args[0]);
        Responsable response = client.run(iQuery);

        System.out.println(response.toString());
    }
}
