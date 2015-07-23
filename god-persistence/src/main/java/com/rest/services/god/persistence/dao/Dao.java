package com.rest.services.god.persistence.dao;

import java.util.List;

/**
 *
 * @author emartinez
 */
public interface Dao<Entidad,TipoLlave> {
    Entidad buscar(TipoLlave llave);
    TipoLlave guardar(Entidad entidad);
    List<Entidad>buscarTodos();
    void actualizar(Entidad entidad);
    void eliminar(TipoLlave llave);
    void eliminarEntidad(Entidad entidad);
}
