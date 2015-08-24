package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.Coro;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author User
 */
public class CoroDaoImpl extends HibernateDaoSupport implements CoroDao{
    private final Logger log = Logger.getLogger(CoroDaoImpl.class);
    TransacctionMySQL mysql = new TransacctionMySQL();
    
    public List<Coro> obtenerListaCoroActualizada() {
        this.log.info(" -- Buscando por lista de coros por fecha::");
        return (List<Coro>) this
                .getSession()
                .createQuery("FROM Coro c " + "ORDER BY c.fechaAct DESC")
                .setMaxResults(2)
                .list();
    }

    public List<Coro> obtenerListacCompletaCoro() {
        this.log.info(" -- Buscando por lista de coros::");
        return (List<Coro>) this
                .getSession()
                .createQuery("FROM Coro c " + "ORDER BY c.nombre ASC")
                .list();
    }
    
    public Coro obtenerCoro(String idCoro) {
        this.log.info(" -- Buscando por coro por id ::"+idCoro);
        int coro = Integer.valueOf(idCoro);
        return (Coro) this
                .getSession()
                .createQuery("FROM Coro c WHERE c.idCoro = :id")
                .setParameter("id", coro)
                .uniqueResult();
    }

    public int agregarCoro(Coro coro) {
        try {
            this.mysql.iniciarOperacion();
            Number maximo = (Number) this.getSession().createQuery(
                    "SELECT COUNT(*) "
                    + "FROM Coro")
                    .uniqueResult();

            long id = maximo == null ? 1 : maximo.longValue() + 1;
            coro.setIdCoro(Integer.parseInt(String.valueOf(id)));
            this.mysql.getSesion().save(coro);
            this.mysql.getSesion().flush();

            this.mysql.getTx().commit();
        } catch (HibernateException he) {
            this.mysql.manejarException(he);
            throw he;
        } finally {
            this.mysql.getSesion().close();
        }
        return coro.getIdCoro();
    }

}
