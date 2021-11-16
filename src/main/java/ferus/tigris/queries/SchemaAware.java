package ferus.tigris.queries;

import java.util.List;
import java.util.Map;

/**
 * Public contract for API queries implementation that provides
 * meta-information about the API, like available endpoints, parameters
 * of requests, etc.
 */
public interface SchemaAware {
    List<String> endpoints();
    Map<String, String> parameters(String endpoint);
}
