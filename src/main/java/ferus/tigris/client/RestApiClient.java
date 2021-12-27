package ferus.tigris.client;

import ferus.tigris.queries.Queryable;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class RestApiClient {
    private RestReader restReader;

    public RestApiClient() {
        this.restReader = new RestReader();
    }

    public RestApiClient(RestReader restReader) {
        this.restReader = restReader;
    }

    public Responsible run(Queryable query) {
        try {
            URL url = getUrl(query);
            JSONAware responseJSON = restReader.read(url);
            return new TypicalResponse(responseJSON);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return new TypicalResponse(new JSONObject());
    }

    private URL getUrl(Queryable query) throws MalformedURLException {
        String requestUrl = query.getRequestUrl();
        return new URL(requestUrl);
    }

}
