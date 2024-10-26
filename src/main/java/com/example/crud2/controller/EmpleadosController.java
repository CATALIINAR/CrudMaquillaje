package com.example.crud2.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.crud2.services.EmpleadosServices;
import com.example.crud2.entities.EmpleadosEntity;

@RestController
@RequestMapping("/api/v1/empleados")

public class EmpleadosController {
    private final EmpleadosServices empleadosServices;

    @Autowired
    public EmpleadosController( EmpleadosServices empleadosServices) {
        this.empleadosServices = empleadosServices;
    }

    //Método para obtener todos los empleado
    @GetMapping
    public List<EmpleadosEntity> getCountries(){
        return empleadosServices.getAllCountries();
    }

    //Método para obtener un empleado por id
    @GetMapping("/{id}")
    public Optional<EmpleadosEntity> getCountry(@PathVariable UUID id){
        return empleadosServices.getCountryById(id);
    }

    //Método para crear un empleado
    @PostMapping
    public String createCountry(){

        return "POST COUNTRY";
    }

    ////Método para actualizar un empleado
    @PutMapping("/{id}")
    public String updateCountry(@PathVariable UUID id){
        empleadosServices.updateCountry(id);
        return "PUT COUNTRY";
    }

    //Método para eliminar un empleado
    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable UUID id){
        empleadosServices.deleteCountry(id);
        return "DELETE COUNTRY";
    }
}
