package ferus.tigris;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class RestApiClient {
    public static final String DATAUSA_API_DATA_URL = "https://datausa.io/api/data";
    private RestReader restReader;

    public RestApiClient(RestReader restReader) {
        this.restReader = restReader;
    }

    public IResponse run(IQuery query) {
        try {
            JSONObject responseJSON = restReader.read(new URL(DATAUSA_API_DATA_URL + "?" + "drilldowns=Nation&measures=Population"));
            return new TypicalResponse(responseJSON);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new TypicalResponse(new JSONObject());
    }

}
