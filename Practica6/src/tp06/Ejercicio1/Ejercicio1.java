package tp06.Ejercicio1;

public class Ejercicio1 {
	/*Bajo qué condiciones usaría una Matriz de Adyacencias en lugar de una
	 * Lista de Adyacencias para representar un grafo.
	 * Y una Lista de Adyacencias en lugar de una Matriz de Adyacencias. Fundamentar.
	 
	 * Matriz de adyacencias: Esta representación es útil para grafos con número
	   de vértices pequeño, o grafos densos
	   Costo espacial: O (|V|^2)
	   Comprobar si una arista (u, v) pertenece a E -> consultar posicion A(u, v)
	   Costo de tiempo T(|V|,|E|) = O(1)
	   Grafo denso = |E| = o(|V|^2)
	   
	   Lista de adyacencias:
	   Costo espacial, sea dirigido o no: O (|V|+|E|) .
	   Representación apropiada para grafos con |E| menor que |V|^2.
	   Desventaja: si se quiere comprobar si una arista (u,v)
       pertenece pertenece a E -> buscar v en la lista de adyacencia adyacencia de u.
       Costo temporal T (|V|,|E|) será O (Grado G) incluido O (|V|).
       Grafo disperso = |E| = o(|V|)
       Resulta apropiado realizar la estimacion del orden de ejecucion
	  para algoritmos de grafos densos en funcion del T(|V|,|E|) = O(1)
	  
	  
	  1C
	  La matriz resultante seria cuadrada y simetrica, ya que la dimension es de VxV
	  Y se puede ir de un nodo a otro y viceversa.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
