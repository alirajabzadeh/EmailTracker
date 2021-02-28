package ir.alirajabzadeh.TrackerTools.EmailTracker;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private static void writeResponse(BufferedWriter outputStream, BufferedInputStream inputStream) throws IOException {
        int binary;
        while ((binary = inputStream.read()) != -1)
            outputStream.write(binary);
        outputStream.flush();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //load your picture , 1x1 transparent picture
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(
                new File("index.png")
        ));

        //set output stream to write the binary of picture on that ( response )
        BufferedWriter out = new BufferedWriter(
                response.getWriter()
        );

        //writing process ...
        writeResponse(out, in);

    }

    public void destroy() {
    }
}