package model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class Position {

    @JsonProperty("x")
    private Double x;
    @JsonProperty("y")
    private Double y;

    // @JsonProperty("x")
    public Double getX() {
        return x;
    }

    // @JsonProperty("x")
    public void setX(Double x) {
        this.x = x;
    }

    // @JsonProperty("x")
    @JsonIgnore
    public void setX(String x) {
        this.x = Double.parseDouble(x);
    }

    // @JsonProperty("y")
    public Double getY() {
        return y;
    }

    // @JsonProperty("y")
    public void setY(Double y) {
        this.y = y;
    }

    // @JsonProperty("y")
    @JsonIgnore
    public void setY(String y) {
        this.y = Double.parseDouble(y);
    }
}
