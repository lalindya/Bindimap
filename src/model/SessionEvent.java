package model;

import org.codehaus.jackson.annotate.JsonProperty;

public class SessionEvent {

    @JsonProperty("userTimeUtc")
    private String userTimeUtc;
    @JsonProperty("position")
    private Position position;

    @JsonProperty("userTimeUtc")
    public String getUserTimeUtc() {
        return userTimeUtc;
    }

    @JsonProperty("userTimeUtc")
    public void setUserTimeUtc(String userTimeUtc) {
        this.userTimeUtc = userTimeUtc;
    }

    @JsonProperty("position")
    public Position getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Position position) {
        this.position = position;
    }

}
