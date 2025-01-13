/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.backend.tarea;

import com.backend.tarea.model.Cliente;
import com.backend.tarea.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setDocumento("123456789");
        cliente.setEmail("juan.perez@example.com");
        cliente.setTelefono("987654321");
    }

    @Test
    void listarClientes() {
        List<Cliente> clientes = Arrays.asList(cliente);
        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.listarClientes();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    @Test
    void guardarCliente() {
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.guardarCliente(cliente);

        assertNotNull(result);
        assertEquals(cliente.getIdCliente(), result.getIdCliente());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void obtenerClientePorId() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente result = clienteService.obtenerClientePorId(1L);

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        verify(clienteRepository, times(1)).findById(1L);
    }

    @Test
    void eliminarCliente() {
        doNothing().when(clienteRepository).deleteById(1L);

        clienteService.eliminarCliente(1L);

        verify(clienteRepository, times(1)).deleteById(1L);
    }
}
