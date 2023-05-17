package com.example.pacientes.dtos;

public record PacienteResponse(Long id, String nombre, int edad, String token,
                               String email, Long nss) {
}
