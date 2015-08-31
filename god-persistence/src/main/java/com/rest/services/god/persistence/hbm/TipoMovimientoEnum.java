package com.rest.services.god.persistence.hbm;

/**
 *
 * @author User
 */
public enum TipoMovimientoEnum {
    REGISTRO_USUARIO("1"),
    ACCESO_SISTEMA("2"),
    RECUPERAR_PASSWORD("3"),
    CONSULTAR_PERFIL("4"),
    REGISTRO_CORO("5"),
    CONSULTAR_HIMNARIO("6"),
    CONSULTAR_CORO("7"),
    SALIR_SISTEMA("8"),
    VALIDAR_USUARIO("9"),
    VALIDAR_EMAIL("10"),
    ACTUALIZAR_PERFIL("11"),
    CORREO_CONTACTO("12");

    private String tipo;

    private TipoMovimientoEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
