package ferus.tigris;

public class Client {
    public static void main(String[] args) {
        RestApiClient client = new RestApiClient(new RestReader());
        IQuery iQuery = new PopulationQuery();
        IResponse response = client.run(iQuery);

        System.out.println(response.toString());
    }
}
