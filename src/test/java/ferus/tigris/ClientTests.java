package ferus.tigris;

import ferus.tigris.queries.Queryable;
import ferus.tigris.client.Responsible;
import ferus.tigris.client.RestApiClient;
import ferus.tigris.client.RestReader;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTests {
    // in good sense of the word :)
    public static final String DATA_USA_DEFAULT =
            "https://datausa.io/api/data?drilldowns=Nation&measures=Population";

    @Test
    void runQuery() throws IOException, ParseException {
        Queryable query = mock(Queryable.class);
        when(query.getRequestUrl()).thenReturn(DATA_USA_DEFAULT);
        JSONObject obj = new JSONObject();
        obj.put("name","foo");

        RestReader restReader = mock(RestReader.class);
        RestApiClient client = new RestApiClient(restReader);
        when(restReader.read(new URL(DATA_USA_DEFAULT))).thenReturn(obj);

        Responsible response = client.run(query);
        when(restReader.read(any())).thenReturn(obj);
        JSONAware json = response.getJSON();

        assertEquals(obj, json);
    }
}
