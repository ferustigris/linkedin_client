package ferus.tigris;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ClientTests {

    @Test
    void runQuery() throws IOException, ParseException {
        IQuery query = new ProfileQuery("Population");
        JSONObject obj = new JSONObject();
        obj.put("name","foo");

        RestReader restReader = mock(RestReader.class);
        RestApiClient client = new RestApiClient(restReader);

        when(restReader.read(any())).thenReturn(obj);
        Responsable response = client.run(query);
        JSONObject json = response.getJSON();
        assertEquals(obj, json);
    }

}
