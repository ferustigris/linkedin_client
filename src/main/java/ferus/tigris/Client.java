package ferus.tigris;

import ferus.tigris.client.Responsable;
import ferus.tigris.client.RestApiClient;
import ferus.tigris.client.RestReader;
import ferus.tigris.queries.*;
import ferus.tigris.repos.ApisRepository;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Client implements ClientQueriable {
    private final ApisRepository apisRepo = new ApisRepository();
    private final QueryFactory queryFactory = new QueryFactory();

    @Override
    public String getReposList() {
        return apisRepo.toString();
    }

    @Override
    public BaseQuery getQuery(String apiName) {
        return (BaseQuery) queryFactory.createQuery(apiName);
    }

    @Override
    public Responsable runQuery(BaseQuery query) throws IOException, ParseException {
        // instantiate the chosen query and execute it
        RestApiClient client = new RestApiClient(new RestReader());
        return client.run(query);
    }
}
