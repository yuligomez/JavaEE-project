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
    private String nomnbre;
    private String email;
    private String teleofono;

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nomnbre=" + nomnbre + ", email=" + email + ", teleofono=" + teleofono + '}';
    }

    
    public Persona() {
    }
       
       
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }



    public String getNomnbre() {
        return nomnbre;
    }

    public void setNomnbre(String nomnbre) {
        this.nomnbre = nomnbre;
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
    
    
}
