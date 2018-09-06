package app;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect
public class MockProjectsList {

    @JsonDeserialize(as = HashMap.class)
    Map<Integer, Double> mapToSerialize = new HashMap<>();

    public MockProjectsList() {
    }

    public Map<Integer, Double> getMapToSerialize() {
        return mapToSerialize;
    }

    public void setMapToSerialize(Map<Integer, Double> mapToSerialize) {
        this.mapToSerialize = mapToSerialize;
    }

    public void putToMap(Integer i, Double d) {
        mapToSerialize.put(i, d);
    }

}

