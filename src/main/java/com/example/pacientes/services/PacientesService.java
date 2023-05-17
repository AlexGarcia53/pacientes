/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pacientes.services;

import com.example.pacientes.dtos.PacienteResponse;
import com.example.pacientes.entity.Paciente;
import com.example.pacientes.repositories.PacientesRepository;
import java.util.List;

import com.example.pacientes.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacientesService {

    @Autowired
    private PacientesRepository pacientesRepository;
    @Autowired
    private JWTUtils jwtUtils;

    public PacienteResponse login(String email, String contrasenia) {
        //Obtiene el paciente de la BD
        List<Paciente> pacientes = pacientesRepository.findByCorreoAndContrasenia(email, contrasenia);

        //Arroja un error si el paciente no existe
        if (pacientes.isEmpty()) {
            throw new RuntimeException("El correo o la contraseña no coinciden");
        }

        Paciente paciente = pacientes.get(0);
        //Transforma el paciente para no mandar la contrasenia y si el token
        PacienteResponse pacienteResponse = convertirPacienteAPacienteResponse(paciente);

        return pacienteResponse;
    }

    public void register(Paciente paciente){
        pacientesRepository.save(paciente);
    }

    private PacienteResponse convertirPacienteAPacienteResponse(Paciente paciente){
        String token = jwtUtils.generateToken(paciente);
        System.out.println(token);
        PacienteResponse pacienteResponse = new PacienteResponse(paciente.getId(),
                paciente.getNombre(), paciente.getEdad(), token, paciente.getEmail(), paciente.getNss());
        return pacienteResponse;
    }
}
