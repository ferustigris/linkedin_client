package ferus.tigris.client;

import org.json.simple.JSONAware;

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
