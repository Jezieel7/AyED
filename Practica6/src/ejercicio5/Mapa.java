package ejercicio5;

import ejercicio3.*;
import tp02.ejercicio2.*;

public class Mapa {
	private Grafo<String> mapaCiudades;
	
	public Mapa(Grafo<String> mapaCiudades) {
		super();
		this.setMapaCiudades(mapaCiudades);
	}
	
	public Grafo<String> getMapaCiudades() {
		return mapaCiudades;
	}

	public void setMapaCiudades(Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}



	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		boolean marca[] = new boolean[this.getMapaCiudades().listaDeVertices().tamanio() + 1];// array de marcas //+1 tamanio xq es un lista(al array comienza en 0)
		for (int i = 1; i < marca.length; i++) {
			marca[i] = false;
		} // Iniciamos las marcas en false porque no se visito ninguno
		// creo la lista de strings que va a tener mi camino
		ListaGenerica<String> lisCiudades = new ListaEnlazadaGenerica<>();
		//creo lista de vertices
		ListaGenerica<Vertice<String>> lisVertices = this.getMapaCiudades().listaDeVertices();
		lisVertices.comenzar();
		while (!lisVertices.fin()) {
			Vertice<String> v = lisVertices.proximo();
			if (v.dato().equals(ciudad1)) {
				devolverCamino(v, this.getMapaCiudades(), lisCiudades, marca, ciudad2);
				break;
			}  
		}
		return lisCiudades;
	}
	
	private boolean devolverCamino(Vertice<String> vertice, Grafo<String> grafo,
	ListaGenerica<String> lisCiudades, boolean[] marca, String ciudad2) {
		//se agrega al nombre del vertice a la lista del camino
		lisCiudades.agregarFinal(vertice.dato());
		marca[grafo.listaDeVertices().posicion(vertice)] = true;
		//copio la lista de adyacentes en adyacentes 
		ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vertice);
		adyacentes.comenzar();

		if (vertice.dato().equals(ciudad2)) {
			return true;
		}

		boolean parar = false;
		//mientras haya adyacentes en la lista
		while (!adyacentes.fin() && !parar) {
			Vertice<String> nextvert = adyacentes.proximo().verticeDestino();
			//si el adyacente no se visito, se hace una recursion
			if (!marca[grafo.listaDeVertices().posicion(nextvert)]) {
				parar = devolverCamino(nextvert, grafo, lisCiudades, marca, ciudad2);
			}
		}
		//si parar=false es xq se llego al final y no se encontro el vertice destino, se procede a 
		//quitar el elemento de la lista(el camino), para buscarlo por otro camino
		if (!parar) {
			lisCiudades.eliminarEn(lisCiudades.tamanio());
		}
		return parar;
	}
	
	ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
		boolean marca[] = new boolean[this.getMapaCiudades().listaDeVertices().tamanio() + 1];// array de marcas
		for (int i = 1; i < marca.length; i++) {
			marca[i] = false;
		} // Iniciamos las marcas en false porque no se visito ninguno
		ListaGenerica<String> lisCiudades = new ListaEnlazadaGenerica<>();
		ListaGenerica<Vertice<String>> lisVertices = this.getMapaCiudades().listaDeVertices();
		lisVertices.comenzar();
		while (!lisVertices.fin()) {
			Vertice<String> v = lisVertices.proximo();
			if (v.dato().equals(ciudad1)) {
				devolverCaminoExceptuando(v, this.getMapaCiudades(), lisCiudades, marca, ciudad2, ciudades);
				break;
			}
		}
		return lisCiudades;
	}

	private boolean devolverCaminoExceptuando(Vertice<String> vert, Grafo<String> grafo,
	ListaGenerica<String> lisCiudades, boolean[] marca, String finCamino, ListaGenerica<String> ciudades) {
		
		marca[grafo.listaDeVertices().posicion(vert)] = true;
		//agrego nodo a la lista del camino
		lisCiudades.agregarFinal(vert.dato());
		ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vert);
		adyacentes.comenzar();
		//si no es final de la lista
		if (vert.dato().equals(finCamino)) {
			return true;
		}

		boolean parar = false;
		while (!adyacentes.fin()&&!parar) {
			Vertice<String> nextvert = adyacentes.proximo().verticeDestino();
			//mientras el vertice proximo no este en la lista de vertices en laque no puede pasar y el vertice
			//no este marcado como visitado
			if (!ciudades.incluye(nextvert.dato()) && !marca[grafo.listaDeVertices().posicion(nextvert)]) {
				parar = devolverCaminoExceptuando(nextvert, grafo, lisCiudades, marca, finCamino, ciudades);
			}
		}
		if (!parar) {
			lisCiudades.eliminarEn(lisCiudades.tamanio());//Se elimina por camino incorrecto
			marca[grafo.listaDeVertices().posicion(vert)] = false;//Para camino futuro
		}
		return parar;
	}
	
	ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		boolean marca[] = new boolean[this.getMapaCiudades().listaDeVertices().tamanio() + 1];// array de marcas
		for (int i = 1; i < marca.length; i++) {
			marca[i] = false;
		} // Iniciamos las marcas en false porque no se visito ninguno
		ListaGenerica<String> caminoMin = new ListaEnlazadaGenerica<>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		ListaGenerica<Vertice<String>> lisv = this.getMapaCiudades().listaDeVertices();
		lisv.comenzar();
		while (!lisv.fin()) {
			Vertice<String> v = lisv.proximo();
			if (v.dato().equals(ciudad1)) {
				caminoMasCorto(v, this.getMapaCiudades(), camino, caminoMin, marca, ciudad2);
				break;
			}
		}
		return caminoMin;
	}

	private void caminoMasCorto(Vertice<String> vert, Grafo<String> grafo, ListaGenerica<String> camino,
	ListaGenerica<String> caminoMin, boolean[] marca, String finCamino) {
		camino.agregarFinal(vert.dato());
		marca[grafo.listaDeVertices().posicion(vert)] = true;
		ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vert);
		adyacentes.comenzar();

		if (vert.dato().equals(finCamino)) {
			if (caminoMin.esVacia() || caminoMin.tamanio() > camino.tamanio()) {
				camino.guardarEnCamino(camino, caminoMin);
			}
		}
		while (!adyacentes.fin()) {
			Vertice<String> nextvert = adyacentes.proximo().verticeDestino();
			if (!marca[grafo.listaDeVertices().posicion(nextvert)]) {
				caminoMasCorto(nextvert, grafo, camino, caminoMin, marca, finCamino);
			}
		}
		camino.eliminarEn(camino.tamanio());
		marca[grafo.listaDeVertices().posicion(vert)] = false;
	}
	
	ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		boolean marca[] = new boolean[this.getMapaCiudades().listaDeVertices().tamanio() + 1];// array de marcas
		for (int i = 1; i < marca.length; i++) {
			marca[i] = false;
		} // Iniciamos las marcas en false porque no se visito ninguno
		ListaGenerica<String> caminosincargar = new ListaEnlazadaGenerica<>();
		ListaGenerica<Vertice<String>> lisv = this.getMapaCiudades().listaDeVertices();
		lisv.comenzar();
		while (!lisv.fin()) {
			Vertice<String> v = lisv.proximo();
			if (v.dato().equals(ciudad1)) {
				caminoSinCargarCombustible(v, this.getMapaCiudades(), caminosincargar, marca, ciudad2, tanqueAuto);
				break;
			}
		}
		return caminosincargar;
	}

	private boolean caminoSinCargarCombustible(Vertice<String> vert, Grafo<String> grafo,
	ListaGenerica<String> caminosincargar, boolean[] marca, String finCamino, int tanqueAuto) {
		caminosincargar.agregarFinal(vert.dato());
		marca[grafo.listaDeVertices().posicion(vert)] = true;
		ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vert);
		adyacentes.comenzar();

		if (vert.dato().equals(finCamino)) {
			return true;
		}

		boolean parar = false;
		while (!adyacentes.fin()&& !parar) {
			Arista<String> ari = adyacentes.proximo();
			Vertice<String> nextvert = ari.verticeDestino();
			if (!marca[grafo.listaDeVertices().posicion(nextvert)]) {
				if (tanqueAuto > ari.peso()) {
					parar = caminoSinCargarCombustible(nextvert, grafo, caminosincargar, marca, finCamino, tanqueAuto - ari.peso());
				}
			}
		}
		if (!parar) {
			caminosincargar.eliminarEn(caminosincargar.tamanio());
			marca[grafo.listaDeVertices().posicion(vert)] = false;
		}
		return parar;
	}
	
	ListaGenerica<String> caminoMenosCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		boolean marca[] = new boolean[this.getMapaCiudades().listaDeVertices().tamanio() + 1];// array de marcas
		for (int i = 1; i < marca.length; i++) {
			marca[i] = false;
		} // Iniciamos las marcas en false porque no se visito ninguno
		ListaYDatos<String> camino = new ListaYDatos<>();
		ListaYDatos<String> caminomincargar = new ListaYDatos<>();
		ListaGenerica<Vertice<String>> lisv = this.getMapaCiudades().listaDeVertices();
		lisv.comenzar();
		while (!lisv.fin()) {
			Vertice<String> v = lisv.proximo();
			if (v.dato().equals(ciudad1)) {
				caminoMenosCargarCombustible(v, this.getMapaCiudades(), camino, caminomincargar, marca, ciudad2, tanqueAuto,
						tanqueAuto);
				break;
			}
		}
		return caminomincargar.getLista();

	}

	private void caminoMenosCargarCombustible(Vertice<String> vert, Grafo<String> grafo, ListaYDatos<String> camino,
	ListaYDatos<String> caminomincargar, boolean[] marca, String finCamino, int tanqueAuto, int tanquemaximo) {

		camino.getLista().agregarFinal(vert.dato());
		marca[grafo.listaDeVertices().posicion(vert)] = true;
		ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(vert);
		adyacentes.comenzar();

		if (vert.dato().equals(finCamino)) {
			if (caminomincargar.getLista().esVacia() || caminomincargar.getNum() > camino.getNum()) {
				caminomincargar.setNum(camino.getNum());
				camino.getLista().guardarEnCamino(camino.getLista(), caminomincargar.getLista());
			}
		}

		while (!adyacentes.fin()) {
			Arista<String> ari = adyacentes.proximo();
			Vertice<String> nextvert = ari.verticeDestino();

			if (!marca[grafo.listaDeVertices().posicion(nextvert)]) {
				if (tanquemaximo >= ari.peso()) {
					if (tanqueAuto >= ari.peso()) {//Si no cargo nafta en la ciudad
						caminoMenosCargarCombustible(nextvert, grafo, camino, caminomincargar, marca, finCamino,
								tanqueAuto - ari.peso(), tanquemaximo);
					} else {//Si cargo nafta en la ciudad
						camino.setNum(camino.getNum() + 1);
						caminoMenosCargarCombustible(nextvert, grafo, camino, caminomincargar, marca, finCamino,
								tanquemaximo - ari.peso(), tanquemaximo);
					}
				}
			}
		}
		camino.getLista().eliminarEn(camino.getLista().tamanio());
		marca[grafo.listaDeVertices().posicion(vert)] = false;
	}
}
