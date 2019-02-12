package app;

import app.MockProjectsList;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonAutoDetect
public class MockDataWrapper {

    @JsonDeserialize(as = Integer.class)
    private int numberOne;

    @JsonDeserialize(as = HashMap.class)
    private Map<Integer, MockProjectsList> myMap = new HashMap<>();

    @JsonDeserialize(as = ArrayList.class)
    private List<String> names = new ArrayList<>();

    public int getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }

    public Map<Integer, MockProjectsList> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<Integer, MockProjectsList> myMap) {
        this.myMap = myMap;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "MockDataWrapper{" +
                "numberOne=" + numberOne + "\n" +
                ", myMap=" + myMap + "\n" +
                ", names=" + names +
                '}' + "\n";
    }
}
