package ejercicio3;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Estudiante[] estudiantes = new Estudiante[2];
		for(int i = 0; i < 2; i++) {
			int comision = s.nextInt();
			s.nextLine();
			estudiantes[i] = new Estudiante(s.nextLine(), s.nextLine(), comision, s.nextLine(), s.nextLine());
		}
		
		Profesor[] profesores = new Profesor[3];
		for(int i = 0; i < 3; i++)
			profesores[i] = new Profesor(s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine());
		
		for(int i = 0; i < 2; i++)
			System.out.println(estudiantes[i].tusDatos());
		
		for(int i = 0; i < 3; i++)
			System.out.println(profesores[i].tusDatos());
		s.close();
	}
}
