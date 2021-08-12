package tp04.ejercicio1;

import tp02.ejercicio2.ListaGenerica;

public class EjercicioCinco {
	public static Double devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol){
		double maxPromedio = 0.00; int nivel = 0; double nivelPromedio = 0.00; int cantNodos = 0;
        ColaGenerica <ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral <AreaEmpresa>> ();
        cola.encolar(arbol);
        cola.encolar(null);
        while(!cola.esVacia()){
            ArbolGeneral<AreaEmpresa> ar = cola.desencolar();
            if(ar != null){
            	nivel += ar.getDato().getTardanzaTransmision();
            	cantNodos++;
                ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = ar.getHijos();
                hijos.comenzar();
                while(!hijos.fin()){
                    ArbolGeneral<AreaEmpresa> hijo = hijos.proximo();
                    if(!hijo.esVacio())
                        cola.encolar(hijo);
                }
                
            }
            else if(!cola.esVacia()) {
            	cola.encolar(null);
                if(cantNodos > 0)
                	nivelPromedio = (nivel / cantNodos);
            	maxPromedio = Math.max(maxPromedio, nivelPromedio);
                nivel = 0;
                cantNodos = 0;
            }else if(cola.esVacia()) {
                if(cantNodos > 0)
                	nivelPromedio = (nivel / cantNodos);
            	maxPromedio = Math.max(maxPromedio, nivelPromedio);
            }
        }
        return maxPromedio;
	}
}
