package com.example.gestionador_de_tareas.Controller;

import com.example.gestionador_de_tareas.Model.Tarea;
import com.example.gestionador_de_tareas.Model.repository.TareaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class TareaController {
    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping("/tareas")
    public @ResponseBody Iterable<Tarea> getAllEmployees() {
        return tareaRepository.findAll();
    }

    @GetMapping("/tareas/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable(value = "id") Integer tareaID) {
        Tarea tarea = tareaRepository.findById(tareaID)
          .orElseThrow();
        return ResponseEntity.ok().body(tarea);
    }

    @GetMapping("/tareas/buscar/{buscar}")
    public @ResponseBody Iterable<Tarea> getTareaByParam(@PathVariable(value = "buscar") String buscar) {
        return tareaRepository.buscarTarea(buscar);
       
    }

    @PostMapping("/tareas")
    public ResponseEntity<Tarea> createEmployee(@Validated @RequestBody Tarea tarea) {
        final Tarea savedTarea = tareaRepository.save(tarea);
        return ResponseEntity.ok(savedTarea);
    }

    @PutMapping("/tareas/{id}")
    public ResponseEntity<Tarea> updateEmployee(@PathVariable(value = "id") Integer tareaID,
         @Validated @RequestBody Tarea tareaDetails){
            Tarea tarea = tareaRepository.findById(tareaID)
        .orElseThrow();

        tarea.setTarea(tareaDetails.getTarea());
        tarea.setFecha(tareaDetails.getFecha());
        tarea.setEstado(tareaDetails.getEstado());
        final Tarea updatedTarea = tareaRepository.save(tarea);
        return ResponseEntity.ok(updatedTarea);
    }

    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable(value = "id") Integer tareaID){
        Tarea tarea = tareaRepository.findById(tareaID)
       .orElseThrow();
       tareaRepository.delete(tarea);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}