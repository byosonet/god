package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.Changeset;
import java.util.List;

/**
 *
 * @author User
 */
public interface ChangesetDao {
    void guardarChangeset(Changeset changeset);
    List<Changeset> getChangesetUser(String idUser);
}