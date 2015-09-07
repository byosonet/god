package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.Changeset;
import com.rest.services.god.persistence.hbm.TipoMovimientoEnum;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author User
 */
public class ChangesetDaoImpl extends HibernateDaoSupport implements ChangesetDao{
    private final Logger log = Logger.getLogger(ChangesetDaoImpl.class);
    TransacctionMySQL mysql = new TransacctionMySQL();
    
    public void guardarChangeset(Changeset changeset) {
       try {
            this.mysql.iniciarOperacion();
            this.mysql.getSesion().save(changeset);
            this.mysql.getSesion().flush();
            this.mysql.getTx().commit();
            this.log.info(" -- Guardando Changeset en BD: "+changeset.toString());
        } catch (HibernateException he) {
            this.mysql.manejarException(he);
            throw he;
        } finally {
            this.mysql.getSesion().close();
        }
    }

    public List<Changeset> getChangesetUser(String idUser) {
         List<Changeset> list = (List<Changeset>) this.getSession()
                .createQuery("FROM Changeset ch WHERE ch.idUsuario = :idUser ORDER BY ch.idChangeset DESC")
                .setParameter("idUser", idUser)
                .list();
         return list;
    }

    public int totalMovemente(TipoMovimientoEnum movement, String idUser) {
            Number maximo = (Number) this.getSession().createQuery(
                    "SELECT COUNT(*) "
                    + "FROM Changeset ch WHERE ch.idUsuario = :idUser AND ch.movement = :movement")
                    .setParameter("idUser", idUser)
                    .setParameter("movement", movement.name().replace("_", " "))
                    .uniqueResult();
            return maximo.intValue();
    }
    
    
}
