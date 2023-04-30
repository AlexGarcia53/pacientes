/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pacientes.services;

import com.example.pacientes.entity.Paciente;
import com.example.pacientes.repositories.PacientesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacientesService {

    @Autowired
    private PacientesRepository pacientesRepository;

    public Paciente getPaciente(String email, String contrasenia) {
        List<Paciente> pacientes = pacientesRepository.findByCorreoAndContrasenia(email, contrasenia);
        if (pacientes.isEmpty()) {
            return null;
        }
        return pacientes.get(0);
    }

    public Paciente getPacienteNSS(Long nss) {
        List<Paciente> pacientes = pacientesRepository.findByNumeroSeguroSocial(nss);
        if (pacientes.isEmpty()) {
            return null;
        }
        return pacientes.get(0);
    }

    public Paciente getPacienteNSSContrasenia(Long nss, String contrasenia) {
        List<Paciente> pacientes = pacientesRepository.findByNumeroAndContrasenia(nss, contrasenia);
        if (pacientes.isEmpty()) {
            return null;
        }
        return pacientes.get(0);
    }

}
