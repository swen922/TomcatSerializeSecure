package app;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ReadParams extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        byte[] input = new byte[req.getContentLength()];

        ServletInputStream sin = req.getInputStream();
        int c = 0;
        int count = 0;
        while ((c = sin.read(input, count, (input.length - count))) > 0) {

            count += 1;
        }
        sin.close();

        String received = new String(input);

        resp.setStatus(HttpServletResponse.SC_OK);
        OutputStreamWriter out = new OutputStreamWriter(resp.getOutputStream());
        out.write(received);
        out.flush();
        out.close();


    }
}
