package com.rest.services.service;

import com.rest.services.god.persistence.hbm.Changeset;
import com.rest.services.god.persistence.hbm.TipoMovimientoEnum;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public interface ChangesetService {
    void guardarChangeset(TipoMovimientoEnum tipo, Date date, int idUsuario, String idCoro);
    List<Changeset> listaChangeset (String idUser);
}
