package com.rest.services.god.banxico.xpath;

import com.rest.services.god.banxico.adapter.BanxicoTipoCambioAdapter.Moneda;

/**
 *
 * @author emartinez
 */
public interface ExtractorTipoCambio {
    String extraer(String xml,Moneda moneda)throws Exception;
}
