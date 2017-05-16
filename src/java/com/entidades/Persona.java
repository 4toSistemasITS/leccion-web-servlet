/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bianca_Valentina
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPkPersona", query = "SELECT p FROM Persona p WHERE p.pkPersona = :pkPersona")
    , @NamedQuery(name = "Persona.findByNombreApellido", query = "SELECT p FROM Persona p WHERE p.nombreApellido = :nombreApellido")
    , @NamedQuery(name = "Persona.findByEspecialidad", query = "SELECT p FROM Persona p WHERE p.especialidad = :especialidad")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_persona")
    private Integer pkPersona;
    @Basic(optional = false)
    @Column(name = "nombre_apellido")
    private String nombreApellido;
    @Basic(optional = false)
    @Column(name = "especialidad")
    private String especialidad;

    public Persona() {
    }

    public Persona(Integer pkPersona) {
        this.pkPersona = pkPersona;
    }

    public Persona(Integer pkPersona, String nombreApellido, String especialidad) {
        this.pkPersona = pkPersona;
        this.nombreApellido = nombreApellido;
        this.especialidad = especialidad;
    }

    public Integer getPkPersona() {
        return pkPersona;
    }

    public void setPkPersona(Integer pkPersona) {
        this.pkPersona = pkPersona;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkPersona != null ? pkPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.pkPersona == null && other.pkPersona != null) || (this.pkPersona != null && !this.pkPersona.equals(other.pkPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.Persona[ pkPersona=" + pkPersona + " ]";
    }
    
}
