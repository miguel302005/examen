package com.demodj.demo_examen.contollers;




import com.demodj.demo_examen.models.Estudiantes;
import com.demodj.demo_examen.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudiantesController {
    @Autowired
    private EstudianteService estudiantesService;

    @GetMapping
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudiantesService.listarEstudiantes());
        return "estudiantes/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeCreacion(Model model) {
        model.addAttribute("estudiante", new Estudiantes());
        return "estudiantes/formulario";
    }

    @PostMapping
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiantes estudiante) {
        estudiantesService.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        model.addAttribute("estudiante", estudiantesService.obtenerEstudiantePorId(id));
        return "estudiantes/formulario";
    }

    @PostMapping("/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiantes estudiante) {
        estudiante.setId(id);
        estudiantesService.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudiantesService.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
