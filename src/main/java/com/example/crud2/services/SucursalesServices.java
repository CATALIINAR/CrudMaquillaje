package com.example.crud2.services;

import com.example.crud2.entities.ClientesEntity;
import com.example.crud2.entities.SucursalesEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class SucursalesServices {
    private List<SucursalesEntity> sucursales;

    public SucursalesServices() {
        sucursales = new ArrayList<>();
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Bella Rosa", "Bogota", "Calle 26 N 67-32"));

    }
    public List<SucursalesEntity> getAllCountries() {
        return sucursales;
    }

    public Optional<SucursalesEntity> getCountryById(UUID id) {
        return sucursales.stream().filter(country -> country.getId().equals(id)).findFirst();
    }

    public SucursalesEntity createCountry(SucursalesEntity country) {
        country.setId(UUID.randomUUID());
        sucursales.add(country);
        return country;
    }

    public Optional<SucursalesEntity> updateCountry(UUID id, SucursalesEntity updatedCountry) {
        for (int i = 0; i < sucursales.size(); i++) {
            ClientesEntity country = sucursales.get(i);
            if (country.getId().equals(id)) {
                updatedCountry.setId(id);
                sucursales.set(i, updatedCountry);
                return Optional.of(updatedCountry);
            }
        }
        return Optional.empty();
    }

    public boolean deleteCountry(UUID id) {
        return sucursales.removeIf(country -> country.getId().equals(id));
    }

}
