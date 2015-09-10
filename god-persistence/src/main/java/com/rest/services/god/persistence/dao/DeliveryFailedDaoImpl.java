package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.DeliveryFailed;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author User
 */
public class DeliveryFailedDaoImpl extends HibernateDaoSupport implements DeliveryFailedDao{
    private final Logger log = Logger.getLogger(DeliveryFailedDaoImpl.class);
    TransacctionMySQL mysql = new TransacctionMySQL();
    
    public void guardarDeliveryFailed(DeliveryFailed deliveryFailed) {
        try {
            this.mysql.iniciarOperacion();
            this.mysql.getSesion().save(deliveryFailed);
            this.mysql.getSesion().flush();
            this.mysql.getTx().commit();
            this.log.info(" -- Guardando deliveryFailed en BD: "+deliveryFailed.toString());
        } catch (HibernateException he) {
            this.mysql.manejarException(he);
            throw he;
        } finally {
            this.mysql.getSesion().close();
        }
    }
    
}
