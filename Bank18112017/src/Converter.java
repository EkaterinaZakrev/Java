import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Converter implements Convertion {


    public Converter() throws IOException {
    }
/*
    public class Staff {

        String Cur_Abbreviation;
        String Cur_OfficialRate;

    }

    String usd = HTTPcur.getCur("USD");
    String eur = HTTPcur.getCur("EUR");
    String rub = HTTPcur.getCur("RUB");

    Gson gs = new Gson();

    //JSON from String to Object
    HTTPcur.Staff objusd = gs.fromJson(usd, HTTPcur.Staff.class);
    HTTPcur.Staff objeur = gs.fromJson(eur, HTTPcur.Staff.class);
    HTTPcur.Staff objrub = gs.fromJson(rub, HTTPcur.Staff.class);




    Map<Currency, Double> sss = new HashMap<Currency, Double>();

    {
        sss.put(Currency.BYN,1.00);
        sss.put(Currency.USD,Double.parseDouble(objusd.Cur_OfficialRate));
        sss.put(Currency.EUR,Double.parseDouble(objeur.Cur_OfficialRate));
        sss.put(Currency.RUB,Double.parseDouble(objrub.Cur_OfficialRate) / 100);

    }

*/
    Map<Currency, Double> sss = new HashMap<Currency, Double>();
    {
        sss.put(Currency.BYN,1.00);
        sss.put(Currency.USD,2.00);
        sss.put(Currency.EUR,2.50);
        sss.put(Currency.RUB,0.3 / 100);

    }

    public double fromCurrencytoBYN(double summ,Currency currency){
        return summ*sss.get(currency);
    }

    public double fromBYNtoCurrency(double summ,Currency currency){

        return summ/sss.get(currency);
    }

    public double fromCurrencytoCurrency(double summ,Currency from, Currency to){

        double summainBYN=fromCurrencytoBYN(summ,from);
        return fromBYNtoCurrency(summainBYN,to);
    }

}