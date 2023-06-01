package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetAPI extends ApplicationProgrammingInterface{
    @Override
    public void setRequestMethod() throws Exception {
        conn.setRequestMethod("GET");
    }

    @Override
    public void setProperty(String token) throws Exception {
        conn.setRequestProperty("Authorization", "Bearer " + token);
    }

    @Override
    public String readData() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder respone = new StringBuilder(); // ising StringBuilder for the sake of memory and performance
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        respone.append(inputLine + "\n");
        in.close();
        LOGGER.info("Respone Info: " + respone.substring(0, respone.length() - 1).toString());
        return respone.substring(0, respone.length() - 1).toString();
    }
}
