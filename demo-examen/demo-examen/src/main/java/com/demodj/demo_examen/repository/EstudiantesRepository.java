package com.demodj.demo_examen.repository;

import com.demodj.demo_examen.models.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesRepository  extends JpaRepository<Estudiantes, Long> {
}
