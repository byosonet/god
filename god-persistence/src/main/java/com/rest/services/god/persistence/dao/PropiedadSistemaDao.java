package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.PropiedadSistema;

/**
 *
 * @author User
 */
public interface PropiedadSistemaDao {
    PropiedadSistema obtenerValorPropiedad(String key);
}
