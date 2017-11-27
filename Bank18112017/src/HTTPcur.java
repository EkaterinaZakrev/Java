import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class HTTPcur {


    public HTTPcur() throws IOException {
    }

    public static String getCur(String dsfsdf) throws IOException {
        String url = "http://www.nbrb.by/API/ExRates/Rates/"+dsfsdf+"?ParamMode=2";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String s = response.toString();


        System.out.println(s);
        return s;
    }

    public class Staff {

        String Cur_Abbreviation;
        String Cur_OfficialRate;

    }


}
