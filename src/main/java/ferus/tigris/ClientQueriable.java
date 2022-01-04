package ferus.tigris;

import ferus.tigris.client.Responsable;
import ferus.tigris.queries.BaseQuery;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface ClientQueriable {
    String getReposList();

    BaseQuery getQuery(String apiName);

    Responsable runQuery(BaseQuery query) throws IOException, ParseException;
}
