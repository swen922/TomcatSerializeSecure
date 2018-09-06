package app;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect
public class MockProjectsListAuth {

    private String login;
    private String pass;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @JsonDeserialize(as = HashMap.class)
    Map<Integer, Double> mapToSerialize = new HashMap<>();

    public MockProjectsListAuth() {
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
