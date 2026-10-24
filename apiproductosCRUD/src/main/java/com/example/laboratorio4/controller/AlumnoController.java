package com.example.laboratorio4.controller;

import com.example.laboratorio4.model.Alumno;
import com.example.laboratorio4.service.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public List<Alumno> listar() {
        return alumnoService.listar();                       // 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> buscarPorId(@PathVariable Long id) {
        return alumnoService.buscarPorId(id)
                .map(ResponseEntity::ok)                     // 200
                .orElse(ResponseEntity.notFound().build());  // 404
    }

    @PostMapping
    public ResponseEntity<Alumno> registrar(@RequestBody Alumno alumno) {
        Alumno creado = alumnoService.guardar(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);   // 201
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Long id, @RequestBody Alumno alumno) {
        return alumnoService.actualizar(id, alumno)
                .map(ResponseEntity::ok)                     // 200
                .orElse(ResponseEntity.notFound().build());  // 404
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (alumnoService.eliminar(id)) {
            return ResponseEntity.noContent().build();       // 204
        }
        return ResponseEntity.notFound().build();            // 404
    }
}
