package com.rest.services.god.banxico.adapter;

import com.rest.services.god.banxico.wsdl.DgieWSLocator;
import com.rest.services.god.banxico.wsdl.DgieWSPortSoapBindingStub;
import com.rest.services.god.banxico.xpath.ExtractorTipoCambioImpl;
import java.math.BigDecimal;

public class BanxicoTipoCambioAdapterImpl implements BanxicoTipoCambioAdapter {

    public BigDecimal getTipoCambio(Moneda moneda) {
        try {
            DgieWSPortSoapBindingStub binding;
            binding = (DgieWSPortSoapBindingStub)new DgieWSLocator().getDgieWSPort();
            binding.setTimeout(60000);
            String value = null;
            value = binding.tiposDeCambioBanxico();
            String tipoCambio = ExtractorTipoCambioImpl.getInstace().extraer(value,moneda);
            return new BigDecimal(tipoCambio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String xmlResponseBanxico() {
         try {
            DgieWSPortSoapBindingStub binding;
            binding = (DgieWSPortSoapBindingStub)new DgieWSLocator().getDgieWSPort();
            binding.setTimeout(60000);
            String value = null;
            value = binding.tiposDeCambioBanxico();
            return value;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } 
    }
}
