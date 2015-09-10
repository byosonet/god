package com.rest.services.god.persistence.hbm;

/**
 *
 * @author User
 */
public class DeliveryFailed implements java.io.Serializable{
    
    private int idFailed;
    private String mailTo;
    private String mailFrom;
    private String subject;
    private String name;
    private String body;
    private String typeFailed;
    
    public DeliveryFailed(){
        
    }
    
    public DeliveryFailed(int idFailed, String mailTo, String mailFrom, String subject, String name, String body, String typeFailed){
        
        this.idFailed = idFailed;
        this.mailTo = mailTo;
        this.mailFrom = mailFrom;
        this.subject = subject;
        this.name = name;
        this.body = body;
        this.typeFailed = typeFailed;
        
    }

    public int getIdFailed() {
        return idFailed;
    }

    public void setIdFailed(int idFailed) {
        this.idFailed = idFailed;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTypeFailed() {
        return typeFailed;
    }

    public void setTypeFailed(String typeFailed) {
        this.typeFailed = typeFailed;
    }

    @Override
    public String toString() {
        return "DeliveryFailed{" + "idFailed=" + idFailed + ", mailTo=" + mailTo + ", mailFrom=" + mailFrom + ", subject=" + subject + ", name=" + name + ", body=" + body + ", typeFailed=" + typeFailed + '}';
    }

}
