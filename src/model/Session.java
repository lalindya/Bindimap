package model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Session {

    @JsonProperty("endTimeUtc")
    private String endTimeUtc;
    @JsonProperty("startTimeUtc")
    private String startTimeUtc;
    @JsonProperty("startTimeLocal")
    private String startTimeLocal;
    @JsonProperty("path")
    private List<SessionEvent> path = null;
    @JsonProperty("sessionId")
    private String sessionId;
    @JsonProperty("userId")
    private String userId;

    @JsonProperty("endTimeUtc")
    public String getEndTimeUtc() {
        return endTimeUtc;
    }

    @JsonProperty("endTimeUtc")
    public void setEndTimeUtc(String endTimeUtc) {
        this.endTimeUtc = endTimeUtc;
    }

    @JsonProperty("startTimeLocal")
    public String getStartTimeLocal() {
        return startTimeLocal;
    }

    @JsonProperty("startTimeLocal")
    public void setStartTimeLocal(String startTimeLocal) {
        this.startTimeLocal = startTimeLocal;
    }

    @JsonProperty("path")
    public List<SessionEvent> getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(List<SessionEvent> path) {
        this.path = path;
    }

    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("startTimeUtc")
    public String getStartTimeUtc() {
        return startTimeUtc;
    }

    @JsonProperty("startTimeUtc")
    public void setStartTimeUtc(String startTimeUtc) {
        this.startTimeUtc = startTimeUtc;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
