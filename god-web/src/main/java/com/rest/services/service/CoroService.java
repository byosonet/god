/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.service;

import com.rest.services.god.persistence.hbm.Coro;
import java.util.List;

/**
 *
 * @author User
 */
public interface CoroService {
    List<Coro> obtenerListaCoroActualizada();
    List<Coro> obtenerListaCoroCompleta();
    Coro obtenerCoro(String idCoro);
}
