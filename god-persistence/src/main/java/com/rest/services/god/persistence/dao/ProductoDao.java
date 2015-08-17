package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.Producto;
import java.util.List;

/**
 *
 * @author emartinez
 */
public interface ProductoDao {
    List<Producto> getAllProducts(int x);
    Producto saveByEntity(Producto producto);
    Producto findByKey(Long llave);
}
