public class Count {

    double balans;
    double sum;
    Currency currency;
    public Count (){};

    void deposit(double sum,Count acc){
        Convertion conv = new Converter();
        acc.sum=acc.sum-conv.fromCurrencytoCurrency(sum,currency,acc.currency);
        this.sum=this.sum+sum;
    }
}
