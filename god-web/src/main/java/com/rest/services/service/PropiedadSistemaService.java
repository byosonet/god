package com.rest.services.service;

import com.rest.services.god.persistence.hbm.PropiedadSistema;

/**
 *
 * @author User
 */
public interface PropiedadSistemaService {
    PropiedadSistema obtenerValorPropiedad (String key);
    void guardarPropiedad(String llave, String valor);
}
