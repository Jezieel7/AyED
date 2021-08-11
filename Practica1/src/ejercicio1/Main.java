package ejercicio1;

public class Main {
	
	public static void conFor(int num1, int num2) {
		for(int i = num1; i <= num2; i++) {
			System.out.println(i);
		}
	}
	
	public static void conWhile(int num1, int num2) {
		int i = num1;
		while(i <= num2) {
			System.out.println(i);
			i++;
		}
	}
	
	public static void sinEstructurasIterativas(int num1, int num2) {
		if(num1 <= num2) {
			System.out.println(num1);
			sinEstructurasIterativas((num1+1), num2);
		}
	}
	
	public static void main(String[] args) {
		conFor(5, 10);
		conWhile(15, 20);
		sinEstructurasIterativas(25, 30);
	}
}
