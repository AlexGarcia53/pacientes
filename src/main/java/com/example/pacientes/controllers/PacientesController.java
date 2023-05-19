/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pacientes.controllers;

import com.example.pacientes.dtos.PacienteResponse;
import com.example.pacientes.entity.Paciente;
import com.example.pacientes.services.PacientesService;
import com.example.pacientes.dtos.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacientesService pacientesService;
    
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<WrapperResponse<PacienteResponse>> login(@RequestBody Paciente paciente) {
        try{
            PacienteResponse responsePaciente = pacientesService.login(paciente.getEmail(), paciente.getContrasenia());
            WrapperResponse<PacienteResponse> response = new WrapperResponse<>("Sesion iniciada", responsePaciente);
            return response.createResponse(HttpStatus.OK);
        }catch(Exception e){
            WrapperResponse<PacienteResponse> response = new WrapperResponse<>(e.getMessage(), null);
            return response.createResponse(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<WrapperResponse<String>> register(@RequestBody Paciente paciente){
        try{
            pacientesService.register(paciente);
            WrapperResponse<String> response = new WrapperResponse<>("Registro exitoso!!!", null);
            return response.createResponse(HttpStatus.OK);
        }catch (Exception e){
            WrapperResponse<String> response = new WrapperResponse<>(e.getMessage(), null);
            return response.createResponse(HttpStatus.NOT_FOUND);
        }
    }
}
