package com.rest.services.god.persistence.hbm;

/**
 *
 * @author User
 */
public class PropiedadSistema {
    private int id;
    private String key;
    private String value;
    
    public PropiedadSistema(){
    }
    
    public PropiedadSistema(int id, String key, String value){
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropiedadSistema{" + "id=" + id + ", key=" + key + ", value=" + value + '}';
    }
    
}
