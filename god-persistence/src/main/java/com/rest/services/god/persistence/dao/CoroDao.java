package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.Coro;
import java.util.List;

/**
 *
 * @author User
 */
public interface CoroDao {
    List<Coro> obtenerListaCoroActualizada();
    List<Coro> obtenerListacCompletaCoro();
    Coro obtenerCoro(String idCoro);
    int agregarCoro(Coro coro);
    boolean validarNumeroCoro(String numCoro);
    boolean validarNombreCoro(String nombre);
}
