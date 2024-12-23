package com.backend.tarea.repository;

import com.backend.tarea.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Puedes añadir métodos personalizados si es necesario
}