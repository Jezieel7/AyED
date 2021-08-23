package ejercicio5;

import tp02.ejercicio2.*;
import tp02.ejercicio3.ColaGenerica;
import ejercicio3.*;

public class Recorridos<T> {
	//Tiempo del recorrido en profundidad O(|V| + |E|)
	public void dfs(Grafo<T> grafo){
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		for (int i=1; i<=grafo.listaDeVertices().tamanio();i++){
			if (!marca[i])
				this.dfs(i, grafo, marca);
		}
	}
	private void dfs(int i, Grafo<T> grafo, boolean[] marca){
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		System.out.println(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()){
			int j = ady.proximo().verticeDestino().getPosicion();
			if(!marca[j]){
					this.dfs(j, grafo, marca);
			}
		}
	}
	
	public ListaEnlazadaGenerica<Vertice<T>> dfsGuardaVerticesVisitados(Grafo<T> grafo){
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaEnlazadaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();
		for(int i=1; i<=grafo.listaDeVertices().tamanio();i++){
			if (!marca[i])
				this.dfsGuardaVerticesVisitados(i, grafo, lis, marca);
		}
		return lis;
	}
	private void dfsGuardaVerticesVisitados(int i, Grafo<T> grafo, ListaEnlazadaGenerica<Vertice<T>> lis, boolean[] marca){
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		lis.agregarFinal(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()){
			int j = ady.proximo().verticeDestino().getPosicion();
			if (!marca[j]){
				this.dfsGuardaVerticesVisitados(j, grafo, lis, marca);
			}
		}
	}
	
	//Tiempo del recorrido en amplitud O(|V| + |E|)
	public void bfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		for (int i = 1; i <= marca.length; i++) {
			if (!marca[i])
				this.bfs(i, grafo, marca); //las listas empiezan en la pos 1
		}
	}
	
	private void bfs(int i, Grafo<T> grafo, boolean[] marca) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while(!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			System.out.println(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if(!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
		}
	}
	
	public ListaEnlazadaGenerica<Vertice<T>> bfsGuardaVerticesVisitados(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaEnlazadaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();
		for (int i = 1; i <= marca.length; i++) {
			if (!marca[i])
				this.bfsGuardaVerticesVisitados(i, grafo, marca, lis); //las listas empiezan en la pos 1
		}
		return lis;
	}
	
	private void bfsGuardaVerticesVisitados(int i, Grafo<T> grafo, boolean[] marca, ListaEnlazadaGenerica<Vertice<T>> lis) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while(!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			lis.agregarFinal(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if(!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
		}
	}
	
	public ListaGenerica<ListaGenerica<Vertice<T>>> dfsConCosto(Grafo<T> grafo){
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		ListaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();
		ListaGenerica<ListaGenerica<Vertice<T>>> recorridos = new ListaEnlazadaGenerica<ListaGenerica<Vertice<T>>>();
		int costo = 0;
		for(int i=1; i<=grafo.listaDeVertices().tamanio();i++){
			lis = new ListaEnlazadaGenerica<Vertice<T>>();
			lis.agregarFinal(grafo.listaDeVertices().elemento(i));
			marca[i]= true;
			this.dfsConCosto(i, grafo, lis, marca, costo, recorridos);
			marca[i] = false;
		}
		return recorridos;
	}
	
	private void dfsConCosto(int i, Grafo<T> grafo, ListaGenerica<Vertice<T>> lis, boolean[] marca, int costo, ListaGenerica<ListaGenerica<Vertice<T>>> recorridos){
		Vertice<T> vDestino = null; int p = 0, j = 0;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()){
			Arista<T> arista = ady.proximo();
			j = arista.verticeDestino().getPosicion();
			if (!marca[j]){
				p = arista.peso();
				if((costo + p) <= 10) {
					vDestino = arista.verticeDestino();
					lis.agregarFinal(vDestino);
					marca[j] = true;
					if((costo + p) == 10)
						recorridos.agregarFinal(lis.clonar());
					else
						this.dfsConCosto(j, grafo, lis, marca, costo+p, recorridos);
					lis.eliminar(vDestino);
					marca[j] = false;
				}
			}
		}
	}
	
	public int bfsVirusTiempoInfeccion(Grafo<T> grafo, Vertice<T> inicial) {
		int tiempo = 0;
		boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()+1];
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
		visitados[inicial.getPosicion()] = true;
		q.encolar(inicial);
		q.encolar(null);
		while(!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			if(v != null) {
				ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
				ady.comenzar();
				while(!ady.fin()) {
					Arista<T> a = ady.proximo();
					Vertice<T> w = a.verticeDestino();
					if(!visitados[w.getPosicion()]) {
						visitados[w.getPosicion()] = true;
						q.encolar(w);
					}
				}
			}else if(!q.esVacia()) {
				tiempo++;
				q.encolar(null);
			}
		}
		return tiempo;
	}
}
