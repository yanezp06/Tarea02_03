package com.backend.tarea.repository;

import com.backend.tarea.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Puedes añadir métodos personalizados si es necesario
}
