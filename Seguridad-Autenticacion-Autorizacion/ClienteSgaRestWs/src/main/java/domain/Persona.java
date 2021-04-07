/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {

    private int idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String teleofono;

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona() {
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nomnbre) {
        this.nombre = nomnbre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeleofono() {
        return teleofono;
    }

    public void setTeleofono(String teleofono) {
        this.teleofono = teleofono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", teleofono=" + teleofono + '}';
    }


}
