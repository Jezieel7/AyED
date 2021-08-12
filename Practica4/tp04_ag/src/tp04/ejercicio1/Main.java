package tp04.ejercicio1;
//		    8
//	    /       \
//	  3          5
//	/ | \      / | \ 
//  4 7  6    1  9  10
//	  |
//	  2

import tp02.ejercicio2.*;

public class Main {
	public static void main (String [] args) {
//		ArbolGeneral<Integer> arbol8= new ArbolGeneral <Integer> (8);
//		ArbolGeneral<Integer> arbol3= new ArbolGeneral <Integer> (3);
//		ArbolGeneral<Integer> arbol5= new ArbolGeneral <Integer> (5);
//		ArbolGeneral<Integer> arbol4= new ArbolGeneral <Integer> (4);
//		ArbolGeneral<Integer> arbol7= new ArbolGeneral <Integer> (7);
//		ArbolGeneral<Integer> arbol6= new ArbolGeneral <Integer> (6);
//		ArbolGeneral<Integer> arbol1= new ArbolGeneral <Integer> (1);
//		ArbolGeneral<Integer> arbol2= new ArbolGeneral <Integer> (2);
//		ArbolGeneral<Integer> arbol9= new ArbolGeneral <Integer> (9);
//		ArbolGeneral<Integer> arbol10= new ArbolGeneral <Integer> (10);
//		ArbolGeneral<Integer> arbol11= new ArbolGeneral <Integer> (100);
//	
//		arbol8.agregarHijo (arbol3);
//		arbol8.agregarHijo (arbol5);
//
//		arbol3.agregarHijo (arbol4);
//		arbol3.agregarHijo (arbol7);
//		arbol3.agregarHijo (arbol6);
//
//		arbol5.agregarHijo (arbol1);
//		arbol5.agregarHijo (arbol9);
//		arbol5.agregarHijo (arbol10);
//
//		arbol7.agregarHijo (arbol2);
//	
//		arbol2.agregarHijo(arbol11);
//
//		System.out.println("El camino es: " + arbol8.altura());
//		System.out.println("El camino es: " + arbol8.altura2());
//		System.out.println("El nivel del dato en el arbol es: " + arbol8.nivel(8));
//		System.out.println("El nivel del dato en el arbol es: " + arbol8.nivel(2));
//		System.out.println("El nivel del dato en el arbol es: " + arbol8.nivel(70));
//		System.out.println("El ancho del arbol es: " + arbol8.ancho());
//		
//		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
//		lista = arbol8.recorridoPorNiveles();
//		lista.comenzar();
//		for(int i = 0; i < lista.tamanio(); i++){
//			System.out.println(lista.proximo());
//		}
//		
//		System.out.println("Que onda perro, es ancestro? " + arbol8.esAncestro(5, 9));
//		System.out.println("Que onda perro, es ancestro? " + arbol8.esAncestro(8, 8));
//		System.out.println("Que onda perro, es ancestro? " + arbol8.esAncestro(7, 2));
//		System.out.println("Que onda perro, es ancestro? " + arbol8.esAncestro(5, 4));
		
//		AreaEmpresa arbolito8 = new AreaEmpresa("a", 8);
//		ArbolGeneral<AreaEmpresa> arbol8= new ArbolGeneral <AreaEmpresa> (arbolito8);
//		AreaEmpresa arbolito13 = new AreaEmpresa("b", 3);
//		ArbolGeneral<AreaEmpresa> arbol3= new ArbolGeneral <AreaEmpresa> (arbolito13);
//		AreaEmpresa arbolito15 = new AreaEmpresa("c", 5);
//		ArbolGeneral<AreaEmpresa> arbol5= new ArbolGeneral <AreaEmpresa> (arbolito15);
//		AreaEmpresa arbolito14 = new AreaEmpresa("d", 4);
//		ArbolGeneral<AreaEmpresa> arbol4= new ArbolGeneral <AreaEmpresa> (arbolito14);
//		AreaEmpresa arbolito7 = new AreaEmpresa("e", 7);
//		ArbolGeneral<AreaEmpresa> arbol7= new ArbolGeneral <AreaEmpresa> (arbolito7);
//		AreaEmpresa arbolito6 = new AreaEmpresa("f", 6);
//		ArbolGeneral<AreaEmpresa> arbol6= new ArbolGeneral <AreaEmpresa> (arbolito6);
//		AreaEmpresa arbolito1 = new AreaEmpresa("g", 1);
//		ArbolGeneral<AreaEmpresa> arbol1= new ArbolGeneral <AreaEmpresa> (arbolito1);
//		AreaEmpresa arbolito12 = new AreaEmpresa("h", 2);
//		ArbolGeneral<AreaEmpresa> arbol2= new ArbolGeneral <AreaEmpresa> (arbolito12);
//		AreaEmpresa arbolito9 = new AreaEmpresa("i", 9);
//		ArbolGeneral<AreaEmpresa> arbol9= new ArbolGeneral <AreaEmpresa> (arbolito9);
//		AreaEmpresa arbolito10 = new AreaEmpresa("j", 10);
//		ArbolGeneral<AreaEmpresa> arbol10= new ArbolGeneral <AreaEmpresa> (arbolito10);
//	
//		arbol8.agregarHijo (arbol3);
//		arbol8.agregarHijo (arbol5);
//
//		arbol3.agregarHijo (arbol4);
//		arbol3.agregarHijo (arbol7);
//		arbol3.agregarHijo (arbol6);
//
//		arbol5.agregarHijo (arbol1);
//		arbol5.agregarHijo (arbol9);
//		arbol5.agregarHijo (arbol10);
//
//		arbol7.agregarHijo (arbol2);
//		
//		System.out.println(EjercicioCinco.devolverMaximoPromedio(arbol8));
		
		System.out.println("Creando hijos del arbol");
		System.out.println("---------------------------------");
		ArbolGeneral<Double> a1 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a2 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a3 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a4 = new ArbolGeneral<Double>(0.0);
		System.out.println("creando lista con los hijos del arbol");
		System.out.println("---------------------------------");
		ListaGenerica<ArbolGeneral<Double>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<Double>>();
		System.out.println("agrego a la lista");
		System.out.println("---------------------------------");
		hijos.agregarFinal(a1);
		hijos.agregarFinal(a2);
		hijos.agregarFinal(a3);
		hijos.agregarFinal(a4);
		System.out.println("Creando ARBOL");
		System.out.println("---------------------------------");
		ArbolGeneral<Double> arbol = new ArbolGeneral<Double>(0.0,hijos);
		System.out.println("Creando MAS hijos del arbol");
		System.out.println("---------------------------------");
		ListaGenerica<ArbolGeneral<Double>> hijos_a2 = new ListaEnlazadaGenerica<ArbolGeneral<Double>>();
		ListaGenerica<ArbolGeneral<Double>> hijos_a3 = new ListaEnlazadaGenerica<ArbolGeneral<Double>>();
		ListaGenerica<ArbolGeneral<Double>> hijos_a6 = new ListaEnlazadaGenerica<ArbolGeneral<Double>>();
		ListaGenerica<ArbolGeneral<Double>> hijos_a9 = new ListaEnlazadaGenerica<ArbolGeneral<Double>>();
		ArbolGeneral<Double> a5 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a6 = new ArbolGeneral<Double>(0.0);
		hijos_a2.agregarFinal(a5);
		ArbolGeneral<Double> hijo6 = new ArbolGeneral<Double>(0.0);
		hijos_a6.agregarFinal(hijo6);
		a6.setHijos(hijos_a6);
		System.out.println("---------------------------------");
		hijos_a2.agregarFinal(a6);
		a2.setHijos(hijos_a2);
		System.out.println("---------------------------------");
		ArbolGeneral<Double> a7 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a8 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a9 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> a10 = new ArbolGeneral<Double>(0.0);
		hijos_a3.agregarFinal(a7);
		hijos_a3.agregarFinal(a8);
		ArbolGeneral<Double> hijo9p1 = new ArbolGeneral<Double>(0.0);
		ArbolGeneral<Double> hijo9p2 = new ArbolGeneral<Double>(0.0);
		System.out.println("---------------------------------");
		hijos_a9.agregarFinal(hijo9p1);
		hijos_a9.agregarFinal(hijo9p2);
		a9.setHijos(hijos_a9);
		System.out.println("---------------------------------");
		hijos_a3.agregarFinal(a9);
		hijos_a3.agregarFinal(a10);
		a3.setHijos(hijos_a3);
		System.out.println("---------------------------------");
		RedAguaPotable redAgua = new RedAguaPotable(arbol);
		Double minCaudal = redAgua.minimoCaudal(1000);
		System.out.println("---------------------------------");
		System.out.println("Minimo caudal: "+minCaudal);
	}
}