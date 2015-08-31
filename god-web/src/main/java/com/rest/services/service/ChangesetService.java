package com.rest.services.service;

import com.rest.services.god.persistence.hbm.TipoMovimientoEnum;
import java.util.Date;

/**
 *
 * @author User
 */
public interface ChangesetService {
    void guardarChangeset(TipoMovimientoEnum tipo, Date date, int idUsuario, String idCoro);
}
