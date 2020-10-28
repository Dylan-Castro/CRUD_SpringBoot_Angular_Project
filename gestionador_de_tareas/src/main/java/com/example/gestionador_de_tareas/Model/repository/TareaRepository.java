package com.example.gestionador_de_tareas.Model.repository;

import com.example.gestionador_de_tareas.Model.Tarea;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TareaRepository extends CrudRepository<Tarea, Integer>{
    @Query(value = "select * from tareas where tarea LIKE %:tarea%" , nativeQuery=true)
    Iterable<Tarea> buscarTarea(@Param("tarea") String tarea);
}