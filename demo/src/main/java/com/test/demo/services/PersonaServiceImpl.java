package com.test.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.entity.Persona;
import com.test.demo.repository.PersonaDao;

import jakarta.transaction.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDao personaDao;
	
	@Override
	@Transactional
	public List<Persona> findAll() {
		return (List<Persona>) personaDao.findAll();
	}


}