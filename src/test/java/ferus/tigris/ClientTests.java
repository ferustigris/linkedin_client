package ferus.tigris;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ClientTests {

    @Test
    void runQuery() throws IOException, ParseException {
        Queryable query = mock(Queryable.class);
        when(query.getParams()).thenReturn(Map.of(
                "drilldowns", "Nation",
                "measures", "Population"
        ));
        JSONObject obj = new JSONObject();
        obj.put("name","foo");

        RestReader restReader = mock(RestReader.class);
        RestApiClient client = new RestApiClient(restReader);
        when(restReader.read(new URL("https://datausa.io/api/data?drilldowns=Nation&measures=Population")))
                .thenReturn(obj);

        Responsable response = client.run(query);
        when(restReader.read(any())).thenReturn(obj);
        JSONObject json = response.getJSON();

        assertEquals(obj, json);
    }

}
