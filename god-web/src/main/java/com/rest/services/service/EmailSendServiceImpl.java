package com.rest.services.service;

/**
 *
 * @author Priscila
 */
import com.rest.services.god.persistence.hbm.DeliveryFailed;
import com.rest.services.god.persistence.hbm.MailTemplate;
import com.rest.services.god.persistence.hbm.TipoEnvioEmail;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
@Component("emailSendService")
public class EmailSendServiceImpl implements EmailSendService
{
    @Autowired
    JavaMailSender mailSender;
 
    @Transactional
    public void sendEmailRegister(final String toEmail,final String bccEmail, final String user, final Map<String, File> attach) throws Exception {
        final MailTemplate mail = this.mailTemplateService.getEmail(1);
        try {
        final boolean multipart = attach != null && attach.size() > 0;
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, multipart, "UTF-8");
                messageHelper.setSubject(mail.getSubject());
                messageHelper.setTo(toEmail);
                messageHelper.setBcc(bccEmail);
                messageHelper.setText(mail.readClob(mail.getMailTemplate()), true);
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
            DeliveryFailed failed = new DeliveryFailed();
            failed.setMailTo(toEmail);
            failed.setMailFrom("godweb.mx@gmail.com");
            failed.setSubject(mail.getSubject());
            failed.setName(user);
            failed.setBody(mail.getMailTemplate());
            failed.setTypeFailed(TipoEnvioEmail.MAIL_REGISTRO.name());
            Timestamp stamp = new Timestamp(System.currentTimeMillis());
                this.log.info("-- Datetime::: "+stamp);
                Date date = new Date(stamp.getTime());
                this.log.info("-- Date::: "+date);
            failed.setDateSend(date);
            this.deliveryFailedService.guardarDeliveryFailed(failed);
            
            log.error(" -- Correo no pudo ser enviado: ", e);
            //throw new RuntimeException("No se pudo enviar mensaje de registro");
            
        }
    }

    @Transactional
    public void recuperarPassword(final String email, final String password, final String bccEmail) {
        final MailTemplate mail = this.mailTemplateService.getEmail(2);
        try {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, "UTF-8");
                messageHelper.setSubject(mail.getSubject());
                messageHelper.setTo(email);
                messageHelper.setBcc(bccEmail);
                messageHelper.setText(mail.readClob(mail.getMailTemplate()), true);
            }
        };
            this.mailSender.send(preparator);
            this.log.info(" -- Correo enviado a: "+email);
        } catch (MailException e) {
            DeliveryFailed failed = new DeliveryFailed();
            failed.setMailTo(email);
            failed.setMailFrom("godweb.mx@gmail.com");
            failed.setSubject(mail.getSubject());
            failed.setName(email);
            failed.setBody(mail.getMailTemplate());
            failed.setTypeFailed(TipoEnvioEmail.MAIL_PASSWORD.name());
            Timestamp stamp = new Timestamp(System.currentTimeMillis());
                this.log.info("-- Datetime::: "+stamp);
                Date date = new Date(stamp.getTime());
                this.log.info("-- Date::: "+date);
            failed.setDateSend(date);
            this.deliveryFailedService.guardarDeliveryFailed(failed);

            log.error(" -- Correo no pudo ser enviado: ", e);
            throw new RuntimeException("No se pudo enviar mensaje de password");
            
        }
    }

    @Transactional
    public void contactoSistema(final String emailSistema, final String asunto, final String nombre, final String emailCliente, final String boydAsunto) {
       final MailTemplate mail = this.mailTemplateService.getEmail(3);
        try {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, "UTF-8");
                messageHelper.setSubject(asunto);
                messageHelper.setTo(emailSistema);
                messageHelper.setText(mail.readClob(mail.getMailTemplate()), true);
            }
        };
            this.mailSender.send(preparator);
            this.log.info(" -- Correo enviado a: "+emailSistema);
        } catch (MailException e) {
            DeliveryFailed failed = new DeliveryFailed();
            failed.setMailTo("godweb.mx@gmail.com");
            failed.setMailFrom(emailCliente);
            failed.setSubject(asunto);
            failed.setName(nombre);
            failed.setBody(mail.getMailTemplate());
            failed.setTypeFailed(TipoEnvioEmail.MAIL_CONTACTO.name());
            Timestamp stamp = new Timestamp(System.currentTimeMillis());
                this.log.info("-- Datetime::: "+stamp);
                Date date = new Date(stamp.getTime());
                this.log.info("-- Date::: "+date);
            failed.setDateSend(date);
            this.deliveryFailedService.guardarDeliveryFailed(failed);
            
            log.error(" -- Correo no pudo ser enviado: ", e);
            throw new RuntimeException("No se pudo enviar mensaje de contacto");
        }
    }
    
    @Autowired
    private DeliveryFailedService deliveryFailedService;
    
    @Autowired
    private MailTemplateService mailTemplateService;
    
    private final Logger log = Logger.getLogger(EmailSendServiceImpl.class);
}