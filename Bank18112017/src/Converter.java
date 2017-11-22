import java.util.HashMap;
import java.util.Map;

public class Converter implements Convertion {

    public static HashMap<Currency,Double> sss = new HashMap<>();
    /*static {
        sss.put(Currency.BYN,1.00);
        sss.put(Currency.USD,Courses.USD);
        sss.put(Currency.EUR,Courses.EUR);
        sss.put(Currency.RUB,Courses.RUB);
    }
*/
    static {
        sss.put(Currency.BYN,1.00);
        sss.put(Currency.USD,2.00);
        sss.put(Currency.EUR,3.00);
        sss.put(Currency.RUB,0.10);
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