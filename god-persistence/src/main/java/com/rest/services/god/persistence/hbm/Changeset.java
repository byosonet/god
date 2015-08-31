package com.rest.services.god.persistence.hbm;

import java.util.Date;

/**
 *
 * @author User
 */
public class Changeset implements java.io.Serializable{
    
    private int idChangeset;
    private String idUsuario;
    private String idMovement;
    private String idCoro;
    private Date fechaMov;
    
    public Changeset(){
    }
    
    public Changeset(int idChangeset, String idUsuario, String idMovement, String idCoro, Date fechaMov){
        this.idChangeset = idChangeset;
        this.idUsuario = idUsuario;
        this.idMovement = idMovement;
        this.idCoro = idCoro;
        this.fechaMov = fechaMov;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(String idMovement) {
        this.idMovement = idMovement;
    }

    public String getIdCoro() {
        return idCoro;
    }

    public void setIdCoro(String idCoro) {
        this.idCoro = idCoro;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public int getIdChangeset() {
        return idChangeset;
    }

    public void setIdChangeset(int idChangeset) {
        this.idChangeset = idChangeset;
    }

    @Override
    public String toString() {
        return "Changeset{" + "idChangeset=" + idChangeset + ", idUsuario=" + idUsuario + ", idMovement=" + idMovement + ", idCoro=" + idCoro + ", fechaMov=" + fechaMov + '}';
    }
    
}
