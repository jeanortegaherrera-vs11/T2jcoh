package com.example.laboratorio4.repository;

import com.example.laboratorio4.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository ya trae save, findAll, findById, deleteById, etc.
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
