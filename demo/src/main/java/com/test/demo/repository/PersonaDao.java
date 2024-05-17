package com.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.demo.entity.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long> {

}
