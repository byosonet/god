package com.rest.services.batch;
import com.rest.services.god.banxico.adapter.BanxicoTipoCambioAdapter;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class MonitorAdapterImpl implements MonitorAdapter{
    private final Logger log = Logger.getLogger(MonitorAdapterImpl.class);
    public void responseWSBANXICO() {
        this.log.info("-- Xml: "+this.banxicoTipoCambioAdapter.xmlResponseBanxico());
       for(BanxicoTipoCambioAdapter.Moneda moneda:BanxicoTipoCambioAdapter.Moneda.values()){
            BigDecimal valor=this.banxicoTipoCambioAdapter.getTipoCambio(moneda);
          this.log.info("-- MONEDA: "+moneda.name()+" VALOR: "+valor+" FECHA: "+new Date());
        } 
    }
    @Autowired
    private BanxicoTipoCambioAdapter banxicoTipoCambioAdapter;

}
