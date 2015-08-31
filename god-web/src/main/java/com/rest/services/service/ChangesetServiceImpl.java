package com.rest.services.service;

import com.rest.services.god.persistence.dao.ChangesetDao;
import com.rest.services.god.persistence.hbm.Changeset;
import com.rest.services.god.persistence.hbm.TipoMovimientoEnum;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
public class ChangesetServiceImpl implements ChangesetService{
    private final Logger log = Logger.getLogger(ChangesetServiceImpl.class);
    
    @Transactional
    public void guardarChangeset(TipoMovimientoEnum tipo, Date date, int idUsuario, String idCoro) {
        try {
              Changeset changeset = new Changeset();
              changeset.setFechaMov(date);
              changeset.setIdCoro(idCoro!=null?idCoro:"NA");
              changeset.setIdUsuario(String.valueOf(idUsuario));
              changeset.setIdMovement(tipo.getTipo());

            this.log.info(" -- Service Guardando Changeset en BD: "+changeset.toString());
            this.changesetDao.guardarChangeset(changeset);
        } catch (Exception ex) {
            this.log.error(" -- No se puede guardar el changeset en BD: "+ex.getMessage());
        }
    }
    
    @Autowired
    private ChangesetDao changesetDao;
    
}
