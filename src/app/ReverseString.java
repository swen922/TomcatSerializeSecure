package app;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;

public class ReverseString extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        int len = req.getContentLength();
        byte[] input = new byte[len];

        ServletInputStream sin = req.getInputStream();
        int c = 0;
        int count = 0;
        while ((c = sin.read(input, count, (input.length - count))) > 0) {
            count += 1;
        }
        sin.close();

        String inString = new String(input);
        String decoded = URLDecoder.decode(inString, "UTF-8");

        String reversed = new StringBuilder(decoded).reverse().toString();

        resp.setStatus(HttpServletResponse.SC_OK);
        OutputStreamWriter out = new OutputStreamWriter(resp.getOutputStream());
        out.write(reversed);
        out.flush();
        out.close();

    }
}
