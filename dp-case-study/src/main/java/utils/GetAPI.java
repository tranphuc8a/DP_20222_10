package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetAPI extends ApplicationProgrammingInterface{
    @Override
    public void setRequestMethod() throws Exception {
        conn.setRequestMethod("GET");
    }

    @Override
    public void prepareData(String token) throws Exception {
        conn.setRequestProperty("Authorization", "Bearer " + token);
    }

    @Override
    public BufferedReader getBufferedReader() throws Exception {
        return new BufferedReader(new InputStreamReader(conn.getInputStream()));
    }
}
