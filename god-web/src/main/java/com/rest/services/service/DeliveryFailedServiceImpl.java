package com.rest.services.service;

import com.rest.services.god.persistence.dao.DeliveryFailedDao;
import com.rest.services.god.persistence.hbm.DeliveryFailed;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
public class DeliveryFailedServiceImpl implements DeliveryFailedService{
    private final Logger log = Logger.getLogger(DeliveryFailedServiceImpl.class);
    
    @Transactional
    public void guardarDeliveryFailed(DeliveryFailed deliveryFailed) {
        this.deliveryFailedDao.guardarDeliveryFailed(deliveryFailed);
        this.log.info(" -- Guardando la información del mail no enviado."); 
    }
    
    @Autowired
    private DeliveryFailedDao deliveryFailedDao;
    
}
