package ferus.tigris;

import ferus.tigris.client.Responsable;
import ferus.tigris.queries.BaseQuery;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;

public class VerboseClient implements ClientQueriable {
    private ClientQueriable client;

    public VerboseClient(ClientQueriable client) {
        this.client = client;
    }

    @Override
    public String getReposList() {
        System.out.println("getting repositories list...");
        return client.getReposList();
    }

    @Override
    public BaseQuery getQuery(String apiName) {
        System.out.println("creating query object...");
        BaseQuery query = client.getQuery(apiName);
        if (query == null) {
            System.out.println("API name is absent: " + apiName + ". Cannot create query object");
        }
        return query;
    }

    @Override
    public Responsable runQuery(BaseQuery query) throws IOException, ParseException {
        System.out.println("Running query...");
        try {
            return client.runQuery(query);
        } catch (MalformedURLException e) {
            System.out.println("fail to find end point url:");
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            System.out.println("fail to read remote data:");
            e.printStackTrace();
            throw e;
        } catch (ParseException e) {
            System.out.println("fail to parse the data:");
            e.printStackTrace();
            throw e;
        }
    }
}
