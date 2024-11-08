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
        clientes.add(new ClientesEntity(UUID.randomUUID(), "Laura", "González", 28));
        clientes.add(new ClientesEntity(UUID.randomUUID(), "Andrés", "Martínez", 32));
        clientes.add(new ClientesEntity(UUID.randomUUID(), "María", "Pérez", 23));
        clientes.add(new ClientesEntity(UUID.randomUUID(), "Juan", "Rodríguez", 30));
        clientes.add(new ClientesEntity(UUID.randomUUID(), "Camila", "Ramírez", 27));
        clientes.add(new ClientesEntity(UUID.randomUUID(), "Diego", "Hernández", 35));
        clientes.add(new ClientesEntity(UUID.randomUUID(), "Daniela", "Jiménez", 29));
        clientes.add(new ClientesEntity(UUID.randomUUID(), "Felipe", "López", 26));
        clientes.add(new ClientesEntity(UUID.randomUUID(), "Valentina", "Morales", 24));
        clientes.add(new ClientesEntity(UUID.randomUUID(), "Santiago", "Castro", 31));


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
