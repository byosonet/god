package com.rest.services.service;

/**
 *
 * @author Priscila
 */
import java.io.File;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
 
@Component("emailSendService")
public class EmailSendServiceImpl implements EmailSendService
{
    @Autowired
    JavaMailSender mailSender;
 
    public void sendEmailRegister(final String toEmail,final String bccEmail, final String user, final Map<String, File> attach) throws Exception {
        
        try {
        final boolean multipart = attach != null && attach.size() > 0;
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, multipart, "UTF-8");
                messageHelper.setSubject("Gracias por registrate en nuestra página, Solo a Dios la Gloria.");
                messageHelper.setTo(toEmail);
                messageHelper.setBcc(bccEmail);
                messageHelper.setText("<html><h2><strong>Bienvenido: "+user+"</strong></h2></html>", true);
                if (attach != null) {
                    for (Map.Entry<String, File> entry : attach.entrySet()) {
                        messageHelper.addAttachment(entry.getKey(), entry.getValue());
                    }
                }
            }
        };
            this.mailSender.send(preparator);
            this.log.info(" -- Correo enviado a: "+toEmail);
        } catch (MailException e) {
            log.error(" -- Correo no pudo ser enviado: ", e);
            
        }
    }

    public void recuperarPassword(final String email, final String password, final String bccEmail) {
        try {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, "UTF-8");
                messageHelper.setSubject("Recuperación de contraseña, Solo a Dios la Gloria.");
                messageHelper.setTo(email);
                messageHelper.setBcc(bccEmail);
                messageHelper.setText("<html><h2><strong>Hola tu password para ingresar al sistema es: "+password+"</strong></h2></html>", true);
            }
        };
            this.mailSender.send(preparator);
            this.log.info(" -- Correo enviado a: "+email);
        } catch (MailException e) {
            log.error(" -- Correo no pudo ser enviado: ", e);
            
        }
    }

    public void contactoSistema(final String emailSistema, final String asunto, final String nombre, final String emailCliente, final String boydAsunto) {
       try {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, "UTF-8");
                messageHelper.setSubject(asunto);
                messageHelper.setTo(emailSistema);
                messageHelper.setText("<html><h2><strong>Email de Usuario: "+emailCliente+"<br>"
                        + "Nombre: "+nombre+"<br>"
                        + "Asunto: "+boydAsunto+"<br>"
                        + "</strong></h2></html>", true);
            }
        };
            this.mailSender.send(preparator);
            this.log.info(" -- Correo enviado a: "+emailSistema);
        } catch (MailException e) {
            log.error(" -- Correo no pudo ser enviado: ", e);
            throw new RuntimeException("No se pudo enviar mensaje");
        }
    }
    
    private final Logger log = Logger.getLogger(EmailSendServiceImpl.class);
}