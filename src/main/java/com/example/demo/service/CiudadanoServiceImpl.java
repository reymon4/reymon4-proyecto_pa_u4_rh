package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.IEstudianteRepo;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {
	@Autowired
	private IEstudianteRepo estudianteRepo;

	@Override
	public Estudiante convertir(Ciudadano ciudadano) {
		LocalDateTime fechaActual = LocalDateTime.now();
		Estudiante estudiante = new Estudiante();
		estudiante.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
		estudiante.setEdad((int) ChronoUnit.YEARS.between(ciudadano.getFechaNacimiento(), fechaActual));
		this.estudianteRepo.insertar(estudiante);
		return estudiante;
	}
}
