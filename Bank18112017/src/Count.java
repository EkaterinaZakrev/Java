
import java.io.IOException;
import java.io.Serializable;

public class Count implements Serializable{

    double balance;
    Currency currency;


    String number;


    @Override
    public String toString() {
        return "Count{" +
                "number=" + number + ", balance=" + balance +
                ", currency=" + currency +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Count)) return false;

        Count count = (Count) o;

        return number.equals(count.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    public Count (){};
    public Count (String number, Currency currency, double balance){
        this.number=number;
        this.currency=currency;
        this.balance=balance;
    };

    public Count (String number, Currency currency){
        this.number=number;
        this.currency=currency;
    };

    void deposit(double sum,Count acc) throws IOException {
        Convertion conv = new Converter();
        if(balance>sum || balance==sum){
            acc.balance=acc.balance+conv.fromCurrencytoCurrency(sum,currency,acc.currency);
            this.balance=this.balance-sum;
        }else{
            System.out.println("You don't have so much money");
        }
    }


    void makePayment(double sum,Count acc)throws IOException {
        Convertion conv = new Converter();
        double convsum = conv.fromCurrencytoCurrency(sum,acc.currency,currency);
        if(balance>convsum || balance==convsum){
            this.balance=this.balance-convsum;
            acc.balance=acc.balance+sum;
        }else{
            System.out.println("You don't have so much money");
        }
    }

    void cashContribution(double sum,Currency currency) throws IOException {
        Convertion conv = new Converter();
        this.balance=this.balance+conv.fromCurrencytoCurrency(sum,currency,this.currency);
    }

}
