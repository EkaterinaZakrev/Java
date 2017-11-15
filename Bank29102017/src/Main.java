import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {

        Count a1 = new Count();
        a1.currency=Currency.BYN;
        a1.sum=1000;

        Count a2=new Count();
        a2.currency=Currency.USD;
        a2.sum=1000;
        a1.deposit(500,a2);
        System.out.println(a1.sum);
        System.out.println(a2.sum);


    }

}
