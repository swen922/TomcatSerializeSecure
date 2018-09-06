package app;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

public class ReadJsonAuth extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        boolean loginOK = false;

        byte[] input = new byte[req.getContentLength()];

        try (ServletInputStream sin = req.getInputStream()) {
            int c = 0;
            int count = 0;
            while ((c = sin.read(input, count, (input.length - count))) > 0) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        resp.setStatus(HttpServletResponse.SC_OK);

        String received = new String(input);
        ObjectMapper mapper = new ObjectMapper();
        MockProjectsListAuth mpla = mapper.readValue(received, MockProjectsListAuth.class);
        String login = mpla.getLogin();
        String pass = mpla.getPass();

        if ((Users.allUsers.containsKey(login)) && (Users.allUsers.get(login).equals(pass))) {
            Map<Integer, Double> receivedMap = mpla.getMapToSerialize();
            receivedMap.forEach((k,v)-> {
                Projects.changedUsers.put(k, v);
            });
            loginOK = true;
        }
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()))) {
            if (loginOK) {
                out.write("Data updated");
            }
            else {
                out.write("Failed update Data");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
