/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pacientes.controllers;

import com.example.pacientes.entity.Paciente;
import com.example.pacientes.services.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacientesService pacientesService;

    @GetMapping("/{nss}")
    public Paciente getPacienteNSS(@PathVariable Long nss) {
        return pacientesService.getPacienteNSS(nss);
    }

    @GetMapping("/nss/{nss}/contrasenia/{contrasenia}")
    public Paciente getPacienteNSSContrasenia(@PathVariable Long nss, @PathVariable String contrasenia) {
        return pacientesService.getPacienteNSSContrasenia(nss, contrasenia);
    }
    
    @GetMapping("/email/{email}/contrasenia/{contrasenia}")
    public Paciente getEmailAndContrasenia(@PathVariable String email, @PathVariable String contrasenia) {
        return pacientesService.getPaciente(email, contrasenia);
    }

}
