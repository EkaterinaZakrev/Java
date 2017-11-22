import com.google.gson.Gson;

import java.io.IOException;

public class Courses {

    public Courses (){};

    static double USD;
    static double EUR;
    static double RUB;

    public class Staff {

        private String Cur_Abbreviation;
        private String Cur_OfficialRate;
        private int Cur_ID;
    }

    public static void makeCur(Currency currency) throws IOException {

        String usd = HTTPcur.getCur(String.valueOf(Currency.USD));
        String eur = HTTPcur.getCur(String.valueOf(Currency.EUR));
        String rub = HTTPcur.getCur(String.valueOf(Currency.RUB));
        Gson gs = new Gson();

        //JSON from String to Object
        Staff objusd = gs.fromJson(usd, Staff.class);
        Staff objeur = gs.fromJson(eur, Staff.class);
        Staff objrub = gs.fromJson(rub, Staff.class);

        USD = Double.parseDouble(objusd.Cur_OfficialRate);
        EUR = Double.parseDouble(objeur.Cur_OfficialRate);
        RUB = Double.parseDouble(objrub.Cur_OfficialRate)/100;
    }
}
