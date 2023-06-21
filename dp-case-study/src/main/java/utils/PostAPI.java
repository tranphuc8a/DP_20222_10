package utils;

import java.io.*;
import java.net.HttpURLConnection;

public class PostAPI extends ApplicationProgrammingInterface{

    @Override
    public void setRequestMethod() throws Exception {
        conn.setRequestMethod("PATCH");
    }

    @Override
    public void prepareData(String data) throws Exception {
        Writer writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        writer.write(data);
        writer.close();
    }

    @Override
    protected HttpURLConnection setupConnection(String url) throws IOException {
        allowMethods("PATCH");
        return super.setupConnection(url);
    }

    @Override
    public BufferedReader getBufferedReader() throws Exception {
        BufferedReader in;
        if (conn.getResponseCode() / 100 == 2) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        return in;
    }
}
