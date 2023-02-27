package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {
	private static final Logger LOG= LoggerFactory.getLogger(MainInterfacesFuncionales.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//1. Supplier
		LOG.info("1.SUPPLIER");
		//Clases
		IPersonaSupplier<String>supplie1= new PersonaSupplierImpl();
		LOG.info("Supplier Clase:"+ supplie1.getNombre());
		
		//Lambdas
		IPersonaSupplier<String>supplier2 = () -> "Reymon2";
		LOG.info("Supplier Lambda:"+ supplier2.getNombre());
		
		IPersonaSupplier<Integer>supplier3 = () -> Integer.valueOf(5);
		LOG.info("Supplier Lambda:"+ supplier3.getNombre());
		
		IPersonaSupplier<Persona> supplie4= ()-> {
		 Persona per = new Persona();
		 per.setApellido("Beltran");
		 per.setNombre("Alexander");
		 return per;
		
		};
		LOG.info("Supplier Lambda:"+ supplie4.getNombre());
		
		IPersonaSupplier<Persona>supplier5 = new IPersonaSupplier2Impl();
		LOG.info("Supplier Lambda:"+ supplier5.getNombre());
		
		///////////////////Java Library
		LOG.info("1.1 Java Supplier");
		LOG.info("1.JAVA SUPPLIER");


		Stream<String> lista =Stream.generate(()->"Reymon2"
			//Metodo HiOrder--> Puedo ver un dato, calculo
		).limit(10); //Genera un stream con maximo 10 elementos
		lista.forEach(cadena-> LOG.info(cadena));
		
		/////////////////////////
		// 2. CONSUMER
		LOG.info("2.CONSUMER");
		//Clase 
		IPersonaConsumer<String, Integer> consumer1= new PersonaConsumerImpl();
		consumer1.accept("Procesa este dato", Integer.valueOf(5));
		
		//Lambda
		IPersonaConsumer<String, Integer>consumer2 = (cadena,numero) ->{
		LOG.info("mensaje a: "+cadena);
		LOG.info("mensaje b: "+cadena);
		LOG.info("mensaje c: "+numero);
		
		
		};
		consumer2.accept("Procesa este dato 3", Integer.valueOf(13));
	
		IPersonaConsumer<Integer, Integer> consumer3= (valor1, valor2)-> {
			Integer valor3 = valor1.intValue()+valor2.intValue();
			LOG.info("valor 3 =" +valor3);
		};
		consumer3.accept(Integer.valueOf(5), Integer.valueOf(13));
		
		LOG.info("2.1 Java Consumer");
		List<Integer> listaNum = Arrays.asList(1,2,3,4,5,9,85,74,58,99);
		listaNum.forEach(numero -> LOG.info("valor:"+numero));
		
		for(Integer val: listaNum) {
			LOG.info("valorTraid: "+val);
		}
		
	//3. Predicate
	LOG.info("3. PREDICATE");
	
	//Lambdas -Ejemplos
	IPersonaPredicate<String> predicate1 = cadena->cadena.contains("Z");
	LOG.info("Predicate:"+predicate1.evaluar("Reymon"));
	
	IPersonaPredicate<Integer> predicate2 = numero->{
		if(numero.intValue()>10) {
			return true;
			
		}else {
			return false;
		}
	};
	LOG.info("Predicate2: "+predicate2.evaluar(Integer.valueOf(11)));
///////////////////Java Library
	LOG.info("3.1 Java Predicate");
	Stream<Integer> listaFiltrada=listaNum.stream().filter(numero-> numero >=3);
	listaFiltrada.forEach(numero -> LOG.info("Valor: "+numero));
	
	//4. Function
	LOG.info("4.Function");
	//Lambdas
	IPersonaFunction<String, Integer> function = numero-> "Valor: "+ numero.toString();
	LOG.info(function.aplicar(10));
	
	IPersonaFunction<Ciudadano, Persona> function2 = per-> { //Recibe una persona y retorna un ciudadano
		Ciudadano ciu = new Ciudadano();
		ciu.setNombreCompleto(per.getNombre()+" "+per.getApellido());
		ciu.setCiudad("Quito");
		return ciu;
	};
	Persona per1 = new Persona();
	per1.setNombre("Reymon");
	per1.setApellido("Hidalgo");
	Ciudadano ciudadanoConver = function2.aplicar(per1);
	LOG.info("Ciudadano convertido: "+ciudadanoConver);
///////////////////Java Library
	LOG.info("4.1 Java Function");
	Stream<String> listaCambiada =listaNum.stream().map(numero -> {
		Integer valFinal =numero +1;
		String cadena = "num: "+valFinal.toString();
		return cadena;
	});
	listaCambiada.forEach(cadena->LOG.info(cadena));
	
	//5. UnaryOperator
	LOG.info("5.UnaryOperator");
	//Lambdas
	IPersonaUnaryOperator<String> unary = cadena -> {
		String cadeFinal = cadena.concat("-subfijo");
		return cadeFinal;
	};
	LOG.info("UnaryOperator: "+unary.aplicar("Alexander")
	);
	//NO hay UNA LIBRERIA DE ESTA INTERFAZ EN JAVA
	}
}