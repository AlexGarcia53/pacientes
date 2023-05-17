/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pacientes.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
public class Paciente{
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id_paciente")
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "edad")
    private int edad;
    
    @Column(name = "contrasenia")
    private String contrasenia;
    
    @Column(name = "email")
    private String email;
     
    @Column(name = "nss_paciente")
    private Long nss;


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return contrasenia;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
