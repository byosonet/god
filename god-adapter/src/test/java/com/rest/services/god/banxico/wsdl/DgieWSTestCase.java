/**
 * DgieWSTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.rest.services.god.banxico.wsdl;

import com.rest.services.god.banxico.adapter.BanxicoTipoCambioAdapter;
import com.rest.services.god.banxico.xpath.ExtractorTipoCambioImpl;

public class DgieWSTestCase extends junit.framework.TestCase {
    public DgieWSTestCase(java.lang.String name) {
        super(name);
    }
    public void test3DgieWSPortTiposDeCambioBanxico() throws Exception {
        com.rest.services.god.banxico.wsdl.DgieWSPortSoapBindingStub binding;
        try {
            binding = (com.rest.services.god.banxico.wsdl.DgieWSPortSoapBindingStub)
                          new com.rest.services.god.banxico.wsdl.DgieWSLocator().getDgieWSPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.tiposDeCambioBanxico();
        
        System.out.println("Tipos de cambio: "+value);
        System.out.println("bm: "+ExtractorTipoCambioImpl.BanxicoTipoCambioNamespaceContext.getInstance().getNamespaceURI("bm"));
        String tipoCambio=ExtractorTipoCambioImpl.getInstace().extraer(value, BanxicoTipoCambioAdapter.Moneda.DOLAR_FIX);
        System.out.println("valor: "+tipoCambio);
        // TBD - validate results
    }

}
