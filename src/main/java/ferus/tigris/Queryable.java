package ferus.tigris;

import java.util.Map;

public interface Queryable {
    String getQueryString();
    Map<String, String> getParams();
}
