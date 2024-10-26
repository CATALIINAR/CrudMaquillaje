package com.example.crud2.services;

import com.example.crud2.entities.ClientesEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientesServices {
    private List<ClientesEntity> clientes;

    public ClientesServices() {
        clientes = new ArrayList<>();
        clientes.add(new ClientesEntity(UUID.randomUUID(), "Carlos", "Florez", 25));

    }

    public List<ClientesEntity> getAllCountries() {
        return clientes;
    }

    public Optional<ClientesEntity> getCountryById(UUID id) {
        return clientes.stream().filter(country -> country.getId().equals(id)).findFirst();
    }

    public ClientesEntity createCountry(ClientesEntity country) {
        country.setId(UUID.randomUUID());
        clientes.add(country);
        return country;
    }

    public Optional<ClientesEntity> updateCountry(UUID id, ClientesEntity updatedCountry) {
        for (int i = 0; i < clientes.size(); i++) {
            ClientesEntity country = clientes.get(i);
            if (country.getId().equals(id)) {
                updatedCountry.setId(id);
                clientes.set(i, updatedCountry);
                return Optional.of(updatedCountry);
            }
        }
        return Optional.empty();
    }

    public boolean deleteCountry(UUID id) {
        return clientes.removeIf(country -> country.getId().equals(id));
    }
}