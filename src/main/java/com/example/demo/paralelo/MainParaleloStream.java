package com.example.demo.paralelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainParaleloStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> idEstudiantes = new ArrayList<>();
		
		for(int i=0; i<100; i++) {
			idEstudiantes.add(i);
		}
		idEstudiantes.forEach(numero -> System.out.println("Estudiante:"+numero)); //Metodo HighOrder
		//EL LOG.info es para ver la la hora y fecha exacta de esa ejecución
		
		//Luego, procesamos el estudiante
		long tiempoInicial = System.currentTimeMillis();
		List<String> listaFinal = idEstudiantes.parallelStream().map(id->procesarIdEstudiante(id)).collect(Collectors.toList());

		long tiempoFinal = System.currentTimeMillis();
		//Vamos a ver el tiempo que tardó la ejecución
		long variacionTiempo = (tiempoFinal - tiempoInicial)/1000;
		listaFinal.forEach(cadena -> System.out.println(cadena));
		System.out.println("Tiempo de ejecución: "+variacionTiempo+" segundos");
	}

	public static String procesarIdEstudiante(Integer idEstudiante) {
		//Vamos a convertir los enteros a Strings
		String idConvertido = "E"+idEstudiante.toString();
		//Luego, insertamos en la base
		System.out.println("Insertando Estudiante: "+idConvertido+" con el hilo: "+  Thread.currentThread().getName());
		//Vamos a decir que se tarde 1 segundo--> Simulamos con TimeUnit
		try {
			TimeUnit.SECONDS.sleep(1); //Digo que se inserta en 1 segundo pero depende de los hilos del pc
			
		}catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		return idConvertido;
		
	}

}
