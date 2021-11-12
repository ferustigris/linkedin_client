package ferus.tigris.queries;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

class TypicalResponse implements Responsable {
    private final JSONAware responseBody;

    public TypicalResponse(JSONAware responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public JSONAware getJSON() {
        return responseBody;
    }

    @Override
    public String toString() {
        return super.toString() + responseBody.toJSONString();
    }
}
