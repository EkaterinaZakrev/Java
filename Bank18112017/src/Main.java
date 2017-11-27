import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Clients client = new Clients();
        Clients benefic = new Clients();
        Map<String,String> passwords = new HashMap<>();
        Map<String,Clients> clientsMap = new HashMap<>();


        Clients a1=new Clients("Ivan","Ivanov");
        a1.login="IvanIvanov";
        a1.setPassword("123Kuytr55");
        a1.count.number="31140000003114";
        a1.count.balance=456.25;
        a1.count.currency=Currency.BYN;

        Clients a2=new Clients("Igor","Petrov");
        a2.login="IgorPetrov";
        a2.setPassword("Petr45*76g");
        a2.count.number="31140000003158";
        a2.count.balance=259.32;
        a2.count.currency=Currency.EUR;

        Clients a3=new Clients("Yuriy","Durov");
        a3.login="YuriyDurov";
        a3.setPassword("Reds@oi258");
        a3.count.number="31140000003598";
        a3.count.balance=456.25;
        a3.count.currency=Currency.USD;

        passwords.put(a1.login,a1.getPassword());
        passwords.put(a2.login,a2.getPassword());
        passwords.put(a3.login,a3.getPassword());
        clientsMap.put(a1.login,a1);
        clientsMap.put(a2.login,a2);
        clientsMap.put(a3.login,a3);

        //создание получателей платежей

        Recipient velcom = new Recipient("Velcom");
        velcom.count.number = "3012000025960";
        velcom.count.currency = Currency.BYN;
        velcom.count.balance = 258.06;
        File fileVelcom = new File("C://Java lessons//Recipients//" + velcom.name + ".txt");
        fileVelcom.createNewFile();
        FileWriter fwvelcom = new FileWriter("C://Java lessons//Recipients//" + velcom.name + ".txt", true);
        fwvelcom.write(String.valueOf(velcom));
        fwvelcom.flush();
        Recipient MTC = new Recipient("MTC");
        MTC.count.number = "3012000589854";
        MTC.count.currency = Currency.BYN;
        MTC.count.balance = 5858.06;
        File fileMTC = new File("C://Java lessons//Recipients//" + MTC.name + ".txt");
        fileMTC.createNewFile();
        FileWriter fwMTC = new FileWriter("C://Java lessons//Recipients//" + MTC.name + ".txt", true);
        fwMTC.write(String.valueOf(MTC));
        fwMTC.flush();
        ArrayList<Recipient> allRecipients = new ArrayList<Recipient>();
        allRecipients.add(velcom);
        allRecipients.add(MTC);


        //Вход в программу

        System.out.println("Do you have account?");
        String answer1 = scan.next();
        if (answer1.equalsIgnoreCase("yes")) {
            //проверка на наличие данного клиента в
            System.out.println("Enter login");
            String userlogin = scan.next();
            if(passwords.containsKey(userlogin)){
                System.out.println("Enter password");
                String userpassword = scan.next();
                if(passwords.get(userlogin).equals(userpassword)){
                    System.out.println("You are logged in");
                    client=(Clients)clientsMap.get(userlogin);
                }else{
                    System.out.println("Password is incorrect");
                }
            }else{
                System.out.println("Login is incorrect");
            }
        } else {
            System.out.println("Would you like to create account?");
            String answer2 = scan.next();
            if (answer2.equalsIgnoreCase("yes")) {
                //создание логина и пароля
                System.out.println("Create login");
                client.login = scan.next();
                while (passwords.containsKey(client.login)) {
                    System.out.println("This login is already in use. Try again");
                    System.out.println("Create login");
                    client.login = scan.next();
                }
                System.out.println("Create password");
                client.setPassword(scan.next());
                passwords.remove(client.login, client.getPassword());
                System.out.println(passwords.values());
                passwords.put(client.login, client.getPassword());

                //создание нового пользователя
                System.out.println("Your name?");
                client.name = scan.next();
                System.out.println("Your surname?");
                client.surname = scan.next();
                System.out.println("Select account currency");
                String answer3 = scan.next();
                if (answer3.equalsIgnoreCase("USD")) {
                    client.count.currency = Currency.USD;
                } else if (answer3.equalsIgnoreCase("EUR")) {
                    client.count.currency = Currency.EUR;
                } else if (answer3.equalsIgnoreCase("RUB")) {
                    client.count.currency = Currency.RUB;
                } else if (answer3.equalsIgnoreCase("BYN")) {
                    client.count.currency = Currency.BYN;
                }

                client.makeAccNum();
                client.count.balance = 0.00;
                clientsMap.put(client.login, client);

                File file = new File("C://Java lessons//Clients//" + client.name + client.surname + ".txt");
                file.createNewFile();
                FileWriter fw = new FileWriter("C://Java lessons//Clients//" + client.name + client.surname + ".txt", true);
                fw.write(String.valueOf(client));
                fw.flush();

            } else {
                //выход из программы
                System.out.println("Good bye");
            }

        }

            //операции со счетом

            System.out.println("Select operation with account");
        /*
        1 - пополнить счет
        2 - перевести со счета на счет
        3 - произвести платеж
        4 - выйти из программы
        */

            int answer4 = scan.nextInt();
            if(answer4==1){
                client.count.cashContribution(1000, Currency.USD);
                FileWriter fw = new FileWriter("C://Java lessons//Clients//" + client.name + client.surname + ".txt", true);
                fw.write(String.valueOf(client));
                fw.flush();
            }else if(answer4==2){
                System.out.println("Enter the beneficiary account");
                String answer5 = scan.next();

                //проверка на наличие счета в базе
                if(clientsMap.toString().contains(answer5)) {
                    Clients arr[] = clientsMap.values().toArray(new Clients[clientsMap.size()]);
                    benefic.count.number = answer5;
                    for (int i = 0; i < arr.length; i++) {
                        if (!benefic.count.number.equals(arr[i].count.number)) {
                            continue;
                        } else {
                            benefic = arr[i];
                            System.out.println(client);
                            System.out.println(benefic);
                            System.out.println("Enter sum of payment");
                            double sumpayment = scan.nextDouble();
                            client.count.deposit(sumpayment, (Count) benefic.count);
                            System.out.println(client);
                            System.out.println(benefic);
                        }
                    }
                }else {
                    System.out.println("Unknown account");
                }
            }else if(answer4==3){
                System.out.println("Select the recipient");
                int answer7 = scan.nextInt();
                Recipient recipient = allRecipients.get(answer7);
                System.out.println(client);
                System.out.println(recipient);
                System.out.println("Enter sum of payment");
                double sumpayment = scan.nextDouble();
                client.count.makePayment(sumpayment, recipient.count);
                System.out.println(client);
                System.out.println(recipient);
                FileWriter fw = new FileWriter("C://Java lessons//Clients//" + client.name + client.surname + ".txt", true);
                fw.write(String.valueOf(client));
                fw.flush();
                FileWriter fw1 = new FileWriter("C://Java lessons//Recipients//" + recipient.name + ".txt", true);
                fw1.write(String.valueOf(recipient));
                fw1.flush();
            }else if(answer4==4){
                System.out.println("Good bye");

                /*FileOutputStream fos = new FileOutputStream("C://Java lessons");

                 */

            }



    }
}