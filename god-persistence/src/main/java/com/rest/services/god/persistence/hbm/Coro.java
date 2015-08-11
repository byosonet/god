/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.god.persistence.hbm;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author User
 */
public class Coro {
    private int idCoro;
    private String nombre;
    private String autor;
    private Date fechaAct;
    private Clob descripcion;
    
    public Coro(){
        
    }
    
    public Coro(int idcoro, String nombre, String autor, Date fechaAct, Clob descripcion){
        this.idCoro = idcoro;
        this.nombre = nombre;
        this.autor = autor;
        this.fechaAct = fechaAct;
        this.descripcion = descripcion;
    }

    public int getIdCoro() {
        return idCoro;
    }

    public void setIdCoro(int idCoro) {
        this.idCoro = idCoro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public Clob getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Clob descripcion) {
        this.descripcion = descripcion;
    }

    
    public String getDataClob(Clob descripcion) throws SQLException, IOException{
        return this.readClob(descripcion);
    }
    
    public String readClob(Clob clob) throws SQLException, IOException {
        StringBuilder sb = new StringBuilder((int) clob.length());
        Reader r = clob.getCharacterStream();
        char[] cbuf = new char[2048];
        int n;
        while ((n = r.read(cbuf, 0, cbuf.length)) != -1) {
            sb.append(cbuf, 0, n);
        }
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return "Coro{" + "idCoro=" + idCoro + ", nombre=" + nombre + ", autor=" + autor + ", fechaAct=" + fechaAct + ", descripcion=" + descripcion + '}';
    }

}
