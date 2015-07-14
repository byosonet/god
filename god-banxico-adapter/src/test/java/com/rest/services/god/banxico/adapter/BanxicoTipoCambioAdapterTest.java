/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.god.banxico.adapter;

import com.rest.services.god.banxico.adapter.BanxicoTipoCambioAdapter.Moneda;
import java.math.BigDecimal;
import junit.framework.TestCase;

/**
 *
 * @author emartinez
 */
public class BanxicoTipoCambioAdapterTest extends TestCase {
    private BanxicoTipoCambioAdapter adapter=new BanxicoTipoCambioAdapterImpl();
    
    public void testGetTipoCambio() {
        System.out.println("getTipoCambio");
        for(Moneda moneda:Moneda.values()){
            BigDecimal valor=this.adapter.getTipoCambio(moneda);
            System.out.println("--------------");
            System.out.println("Moneda: "+moneda.name());
            System.out.println("Tipo de cambio: "+valor);
        }
    }
}
