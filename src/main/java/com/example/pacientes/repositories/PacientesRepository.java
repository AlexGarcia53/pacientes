/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.pacientes.repositories;

import com.example.pacientes.entity.Paciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository

public interface PacientesRepository extends JpaRepository<Paciente, Long> {
    
    @Query("SELECT p FROM Paciente p WHERE p.email = :email AND p.contrasenia = :contrasenia")
    List<Paciente> findByCorreoAndContrasenia(@Param("email") String email, @Param("contrasenia") String contrasenia);
    
    @Query("SELECT p FROM Paciente p WHERE p.email = :email ")
    List<Paciente> findByCorreo(@Param("email") String email);
    
    @Query("SELECT p FROM Paciente p WHERE p.nss = :nss")
    List<Paciente> findByNumeroSeguroSocial(@Param("nss") Long nss);
    
    @Query("SELECT p FROM Paciente p WHERE p.nss = :nss AND p.contrasenia = :contrasenia")
    List<Paciente> findByNumeroAndContrasenia(@Param("nss") Long nss, @Param("contrasenia") String contrasenia);

    
}
