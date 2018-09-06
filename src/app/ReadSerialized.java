package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReadSerialized extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        try {
            byte[] input = new byte[req.getContentLength()];

            ServletInputStream sin = req.getInputStream();
            int c = 0;
            int count = 0;
            while ((c = sin.read(input, count, (input.length - count))) > 0) {

                count += 1;
            }
            sin.close();

            String received = new String(input);

            ObjectMapper mapper = new ObjectMapper();
            MockProjectsList mplReceived = mapper.readValue(received, MockProjectsList.class);

            Map<Integer, Double> sourceMap = mplReceived.getMapToSerialize();
            Map<Integer, Double> modifiedMap = new HashMap<>();
            sourceMap.forEach((k,v)-> modifiedMap.put(k, v * 2));

            mplReceived.setMapToSerialize(modifiedMap);

            String mapSerialized = mapper.writeValueAsString(mplReceived);

            resp.setStatus(200);
            OutputStreamWriter out = new OutputStreamWriter(resp.getOutputStream());
            out.write(mapSerialized);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
