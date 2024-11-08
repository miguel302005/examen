package com.demodj.demo_examen.services;



import com.demodj.demo_examen.models.Estudiantes;
import com.demodj.demo_examen.repository.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    private EstudiantesRepository estudiantesRepository;

    public List<Estudiantes> listarEstudiantes() {
        return estudiantesRepository.findAll();
    }

    public Estudiantes obtenerEstudiantePorId(Long id) {
        return estudiantesRepository.findById(id).orElse(null);
    }

    public Estudiantes guardarEstudiante(Estudiantes estudiantes) {
        return estudiantesRepository.save(estudiantes);
    }

    public void eliminarEstudiante(Long id) {
        estudiantesRepository.deleteById(id);
    }
}
