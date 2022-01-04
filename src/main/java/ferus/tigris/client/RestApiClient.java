package ferus.tigris.client;

import ferus.tigris.queries.Queryable;
import org.json.simple.JSONAware;
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

    public Responsable run(Queryable query) throws IOException, ParseException {
        URL url = getUrl(query);
        JSONAware responseJSON = restReader.read(url);
        return new TypicalResponse(responseJSON);
    }

    private URL getUrl(Queryable query) throws MalformedURLException {
        String requestUrl = query.getRequestUrl();
        return new URL(requestUrl);
    }

}
