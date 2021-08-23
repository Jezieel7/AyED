package ejercicio5;

import tp02.ejercicio2.*;
import ejercicio3.*;

public class Parcial {
	   ListaGenerica<String> resolver(Grafo<String> ciudades, String origen, String destino, int distanciaEvitar, String ciudadTransitar){
		   boolean pasoPorCiudad = false;
		   boolean marca[] = new boolean[ciudades.listaDeVertices().tamanio() + 1];// array de marcas
			for (int i = 1; i < marca.length; i++) {
				marca[i] = false;
			} // Iniciamos las marcas en false porque no se visito ninguno
			ListaGenerica<String> lisCiudades = new ListaEnlazadaGenerica<>();
			ListaGenerica<Vertice<String>> lisVertices = ciudades.listaDeVertices();
			lisVertices.comenzar();
			while (!lisVertices.fin()) {
				Vertice<String> v = lisVertices.proximo();
				if (v.dato().equals(origen)) {
					resolver(v, ciudades, lisCiudades, marca, destino, distanciaEvitar, ciudadTransitar, pasoPorCiudad);
					break;
				}
			}
			return lisCiudades;
		}

		private boolean resolver(Vertice<String> vert, Grafo<String> grafo,
		ListaGenerica<String> lisCiudades, boolean[] marca, String finCamino, int distanciaEvitar, String ciudadTransitar, boolean pasoPorCiudad) {
			marca[grafo.listaDeVertices().posicion(vert)] = true;
			//agrego nodo a la lista del camino
			lisCiudades.agregarFinal(vert.dato());
			ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vert);
			adyacentes.comenzar();
			if (vert.dato().equals(finCamino) && pasoPorCiudad) {
				return true;
			}
			boolean parar = false;
			while (!adyacentes.fin()&&!parar) {
				Arista<String> ari = adyacentes.proximo();
				Vertice<String> nextvert = adyacentes.proximo().verticeDestino();
				if(ciudadTransitar == nextvert.dato())
					pasoPorCiudad = true;
				if (!marca[grafo.listaDeVertices().posicion(nextvert)]) {
					if(distanciaEvitar >= ari.peso()) {
						parar = resolver(nextvert, grafo, lisCiudades, marca, finCamino, distanciaEvitar - ari.peso(), ciudadTransitar, pasoPorCiudad);
					}
				}
			}
			if (!parar) {
				lisCiudades.eliminarEn(lisCiudades.tamanio());//Se elimina por camino incorrecto
				marca[grafo.listaDeVertices().posicion(vert)] = false;//Para camino futuro
			}
			return parar;
		}
}
