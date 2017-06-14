/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admisiones.bean;

/**
 *
 * @author Jose.suspes
 */
public class InformacionAcudiente {
    
    private Parentesco parentesco;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String celular;
    private String email;
    private long idAcudiente;

    public InformacionAcudiente() {
        
        parentesco=new Parentesco();
    }

    
    
    
    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIdAcudiente() {
        return idAcudiente;
    }

    public void setIdAcudiente(long idAcudiente) {
        this.idAcudiente = idAcudiente;
    }
}
