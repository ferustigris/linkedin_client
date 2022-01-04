package ferus.tigris;

import ferus.tigris.client.Responsable;
import ferus.tigris.client.RestApiClient;
import ferus.tigris.client.RestReader;
import ferus.tigris.queries.*;
import ferus.tigris.repos.ApisRepository;

public class Client {
    private final ApisRepository apisRepo = new ApisRepository();
    private final QueryFactory queryFactory = new QueryFactory();

    public String getReposList() {
        return apisRepo.toString();
    }

    public Client() {}

    public BaseQuery getQuery(String apiName) {
        return (BaseQuery) queryFactory.createQuery(apiName);
    }

    public Responsable runQuery(BaseQuery query) {
        // instantiate the chosen query and execute it
        RestApiClient client = new RestApiClient(new RestReader());
        return client.run(query);
    }
}
