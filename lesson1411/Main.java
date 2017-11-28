package by.home.lesson1411;

import java.io.IOException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
			
		try{
			int a = enterIntNum();
			System.out.println(a);
			double b = enterDoubleNum();
			System.out.println(b);
			int c=a/0;
			System.out.println(c);
		}catch(EnterException e){
			System.out.println(e.getMessage());
			System.err.println(e.getMessage());
		}catch(ArithmeticException e){
			System.err.println(e.getMessage());
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
				
	}
	
	public static int enterIntNum() throws EnterException {
		Scanner scan = new Scanner(System.in);
		System.out.println("¬ведите целое число");
		if(scan.hasNextInt()){
			return scan.nextInt();
		}else{
			throw new EnterException("вы ввели не целое число"); 
		}
		
	}
public static int enterDoubleNum() throws EnterException {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("¬ведите дробное число");
		if(scan.hasNextDouble()){
			return scan.nextInt();
		}else{
			throw new EnterException("вы ввели не дробное число"); 
		}
		
				
	}

}
