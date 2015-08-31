package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.Changeset;

/**
 *
 * @author User
 */
public interface ChangesetDao {
    void guardarChangeset(Changeset changeset);
}
