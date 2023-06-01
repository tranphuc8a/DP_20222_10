package utils;

import java.io.*;

public class PostAPI extends ApplicationProgrammingInterface{

    @Override
    public void allowMethods() throws Exception {
        super.allowMethods();
        allowMethods("PATCH");
    }

    @Override
    public void setRequestMethod() throws Exception {
        conn.setRequestMethod("PATCH");
    }

    @Override
    public void writeDate(String data) throws Exception {
        super.writeDate(data);

        Writer writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        writer.write(data);
        writer.close();
    }

    @Override
    public String readData() throws Exception {
        BufferedReader in;
        String inputLine;
        if (conn.getResponseCode() / 100 == 2) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);
        in.close();
        LOGGER.info("Respone Info: " + response.toString());
        return response.toString();
    }
}
