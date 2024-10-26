package com.example.crud2.services;

import com.example.crud2.entities.EmpleadosEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class EmpleadosServices {
    private List<EmpleadosEntity> empleados;

    public EmpleadosServices() {
        empleados = new ArrayList<>();
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Carlos", "Florez", 25, "cajero"));

    }
    public List<EmpleadosEntity> getAllCountries() {
        return empleados;
    }

    public Optional<EmpleadosEntity> getCountryById(UUID id) {
        return empleados.stream().filter(country -> country.getId().equals(id)).findFirst();
    }

    public EmpleadosEntity createCountry(EmpleadosEntity country) {
        country.setId(UUID.randomUUID());
        empleados
                .add(country);
        return country;
    }
    public Optional<EmpleadosEntity> updateCountry(UUID id, EmpleadosEntity updatedCountry) {
        for (int i = 0; i < empleados.size(); i++) {
            ClientesEntity country = empleados.get(i);
            if (country.getId().equals(id)) {
                updatedCountry.setId(id);
                empleados.set(i, updatedCountry);
                return Optional.of(updatedCountry);
            }
        }
        return Optional.empty();
    }

    public boolean deleteCountry(UUID id) {
        return empleados.removeIf(country -> country.getId().equals(id));
    }
}
