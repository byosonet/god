package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.dto.ConsultaCoro;
import com.rest.services.god.persistence.hbm.Changeset;
import com.rest.services.god.persistence.hbm.TipoMovimientoEnum;
import java.util.List;

/**
 *
 * @author User
 */
public interface ChangesetDao {
    void guardarChangeset(Changeset changeset);
    List<Changeset> getChangesetUser(String idUser);
    int totalMovemente(TipoMovimientoEnum movement, String idUser);
    List<ConsultaCoro> getConsultaCoro(int days);
}