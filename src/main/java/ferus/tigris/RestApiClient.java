package ferus.tigris;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class RestApiClient {
    public static final String DATAUSA_API_DATA_URL = "https://datausa.io/api/data";
    private RestReader restReader;

    public RestApiClient() {
        this.restReader = new RestReader();
    }

    public RestApiClient(RestReader restReader) {
        this.restReader = restReader;
    }

    public IResponse run(IQuery query) {
        try {
            URL url = getUrl(query);
            JSONObject responseJSON = restReader.read(url);
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

    private URL getUrl(IQuery query) throws MalformedURLException {
        String params = query.getParams().entrySet().stream().map((entry) -> entry.getKey() + "=" + entry.getValue())
                .reduce((k, v) -> k + "&" + v).get();
        return new URL(DATAUSA_API_DATA_URL + "?" + params);
    }

}
