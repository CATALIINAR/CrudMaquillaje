package com.example.crud2.services;

import com.example.crud2.entities.ClientesEntity;
import com.example.crud2.entities.ProductosEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class ProductosServices {
    private List<ProductosEntity> productos;

    public ProductosServices() {
        productos = new ArrayList<>();
        productos.add(new ProductosEntity(UUID.randomUUID(), "Pestañina", "facial", 10.500,15));

    }
    public List<ProductosEntity> getAllCountries() {
        return productos;
    }

    public Optional<ProductosEntity> getCountryById(UUID id) {
        return productos.stream().filter(country -> country.getId().equals(id)).findFirst();
    }

    public ProductosEntity createCountry(ProductosEntity country) {
        country.setId(UUID.randomUUID());
        productos
                .add(country);
        return country;
    }
    public Optional<ProductosEntity> updateCountry(UUID id, ProductosEntity updatedCountry) {
        for (int i = 0; i < productos.size(); i++) {
            ClientesEntity country = productos.get(i);
            if (country.getId().equals(id)) {
                updatedCountry.setId(id);
                productos.set(i, updatedCountry);
                return Optional.of(updatedCountry);
            }
        }
        return Optional.empty();
    }

    public boolean deleteCountry(UUID id) {
        return productos.removeIf(country -> country.getId().equals(id));
    }

}
