package ferus.tigris.queries;

import java.util.List;
import java.util.Map;

/**
 * Public contract for API queries implementation that provides
 * meta-information about the API, like available endpoints, parameters
 * of requests, etc.
 */
public interface SchemaAware {
    /**
     * Retrieves list of supported endpoints.
     * @return list of endpoints.
     */
    List<String> endpoints();

    /**
     * Retrieves parameters acceptable per an endpoint.
     * @param endpoint to retrieve params
     * @return map of name-value pairs of params.
     */
    Map<String, String> parameters(String endpoint);
}
