package ferus.tigris;

import org.json.simple.JSONObject;

class TypicalResponse implements Responsable {
    private final JSONObject responseBody;

    public TypicalResponse(JSONObject responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public JSONObject getJSON() {
        return responseBody;
    }

    @Override
    public String toString() {
        return super.toString() + responseBody.toJSONString();
    }
}
