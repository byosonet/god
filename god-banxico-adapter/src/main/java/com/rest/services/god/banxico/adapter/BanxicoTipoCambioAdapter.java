package com.rest.services.god.banxico.adapter;

import java.math.BigDecimal;

/**
 *
 * @author emartinez
 */
public interface BanxicoTipoCambioAdapter {
    //Comentario GOD
    BigDecimal getTipoCambio(Moneda moneda);
    String xmlResponseBanxico();
    public static enum Moneda{ 
        DOLAR("SF60653"),
        DOLAR_FIX("SF43718"),
        EURO("SF46410"),
        YEN_JAPONES("SF46406"),
        DOLAR_CANADIENSE("SF60632"),
        LIBRA("SF46407");

        private Moneda(String idSerie) {
            this.idSerie = idSerie;
        }

        public String getIdSerie() {
            return idSerie;
        }
        
        private String idSerie;
    }
}
