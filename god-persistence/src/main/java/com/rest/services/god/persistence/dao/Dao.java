package com.rest.services.god.persistence.dao;

import java.util.List;

public interface Dao<Entidad,Llave> {
    Entidad findByKey(Llave llave);
    Llave saveByEntityReturnID(Entidad entidad);
    Entidad saveByEntity(Entidad entidad);
    List<Entidad>getList();
    
    void updateByEntity(Entidad entidad);
    void deleteByKey(Llave llave);
    void deleteByEntity(Entidad entidad);
}
