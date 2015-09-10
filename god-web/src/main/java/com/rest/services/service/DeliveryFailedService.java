package com.rest.services.service;

import com.rest.services.god.persistence.hbm.DeliveryFailed;

/**
 *
 * @author User
 */
public interface DeliveryFailedService {
    void guardarDeliveryFailed(DeliveryFailed deliveryFailed);
}
