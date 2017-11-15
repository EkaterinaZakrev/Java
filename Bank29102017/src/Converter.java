public class Converter implements Convertion{
    public double fromCurrencytoUSD(double summ,Currency currency){
        if(currency==Currency.BYN){
            return summ/1.9;
        }if(currency==Currency.RUB){
            return  summ/0.033;
        }if(currency==Currency.USD){
            return summ;
        }if(currency==Currency.EUR){
            return summ/2.3;
        }
        return 0;
    }

    public double fromUSDtoCurrency(double summ,Currency currency){
        if(currency==Currency.BYN){
            return summ*1.9;
        }if(currency==Currency.EUR){
            return summ*2.3;
        }if(currency== Currency.RUB){
            return summ*0.033;
        }if(currency==Currency.USD){
            return  summ;
        }
        return 0;
    }

    public double fromCurrencytoCurrency(double summa,Currency from, Currency to){
        double summainUSD=fromCurrencytoUSD(summa,from);
        return fromUSDtoCurrency(summainUSD,to);
    }

}
