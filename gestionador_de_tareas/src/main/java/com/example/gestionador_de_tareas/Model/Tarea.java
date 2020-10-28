package com.example.gestionador_de_tareas.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tarea {
    private Integer id;
    private String tarea;
    private Date fecha;
    private Boolean estado = false;
 
    public Tarea() {
  
    }
 
    public Tarea(Integer id, String tarea, Date fecha, Boolean estado) {
         this.id = id;
         this.tarea = tarea;
         this.fecha = fecha;
         this.estado = estado;
    }
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
 

    public String getTarea() {
        return tarea;
    }
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
 
    
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
 

    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    } 
}