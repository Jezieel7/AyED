package ejercicio2;

import tp02.ejercicio2.*;
import java.util.Scanner;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ListaEnlazadaGenerica<Estudiante> l = new ListaEnlazadaGenerica<Estudiante>();
		l.comenzar();
		for(int i=0; i<4; i++){
			int comision = s.nextInt();
			s.nextLine();
			Estudiante e = new Estudiante(s.nextLine(), s.nextLine(), comision, s.nextLine(), s.nextLine());
			l.agregarFinal(e);
		}
		for(int i=0; i<l.tamanio(); i++)
			System.out.println(l.proximo().tusDatos());
		s.close();
	}

}
