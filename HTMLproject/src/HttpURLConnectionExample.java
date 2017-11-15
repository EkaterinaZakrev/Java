
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class HttpURLConnectionExample {


    public static void main(String[] args)throws IOException{


        String usd = getCur("USD");
        String eur = getCur("EUR");
        String rub = getCur("RUB");

        Gson gs = new Gson();

        //JSON from String to Object
        Staff objusd = gs.fromJson(usd, HttpURLConnectionExample.Staff.class);
        Staff objeur = gs.fromJson(eur, HttpURLConnectionExample.Staff.class);
        Staff objrub = gs.fromJson(rub, HttpURLConnectionExample.Staff.class);

        System.out.println(objusd.Cur_Abbreviation);
        System.out.println(objusd.Cur_OfficialRate);
        System.out.println(objeur.Cur_Abbreviation);
        System.out.println(objeur.Cur_OfficialRate);
        System.out.println(objrub.Cur_Abbreviation);
        System.out.println(objrub.Cur_OfficialRate);

        Map<String, String> sss = new HashMap<>();
        sss.put(objusd.Cur_Abbreviation,objusd.Cur_OfficialRate);
        sss.put(objeur.Cur_Abbreviation,objeur.Cur_OfficialRate);
        sss.put(objrub.Cur_Abbreviation,objrub.Cur_OfficialRate);

        double Usd = Double.parseDouble(sss.get(objusd.Cur_Abbreviation));
        double Eur = Double.parseDouble(sss.get(objeur.Cur_Abbreviation));
        double Rub = Double.parseDouble(sss.get(objrub.Cur_Abbreviation));
        System.out.println(Usd+" "+Eur+" "+Rub);


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

        private String Cur_Abbreviation;
        private String Cur_OfficialRate;
        private int Cur_ID;
    }
}