package com.rest.services.service;

/**
 *
 * @author Priscila
 */
import com.rest.services.god.persistence.hbm.DeliveryFailed;
import com.rest.services.god.persistence.hbm.TipoEnvioEmail;
import com.rest.services.util.UtilService;
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
                messageHelper.setText("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"<head>\n" +
"<title></title>\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"<style type=\"text/css\">\n" +
"  a{\n" +
"   color:#ffffff; \n" +
"  }\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<div style=\"width:100%;\" align=\"center\">\n" +
"<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"  <tr>\n" +
"        <br>\n" +
"        <br>\n" +
"        <table width=\"583\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"          <tr>\n" +
"            <td align=\"left\" valign=\"top\"><img src=\"http://imageshack.com/a/img910/9964/oa9XQ1.jpg\" width=\"583\" height=\"118\" style=\"border-radius: 5px\"></td>\n" +
"          </tr>\n" +
"          <tr>\n" +
"            <td align=\"left\" valign=\"top\" bgcolor=\"#FFFFFF\" style=\"background-color:#FFFFFF;\">\n" +
"              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"                  <tr>\n" +
"                    <td align=\"left\" valign=\"top\">\n" +
"                      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"                          <tr>\n" +
"                            <td align=\"center\" valign=\"top\">\n" +
"                              <div style=\"text-align:center;\"><img style=\"height: 200px; width: 200px;\" src=\"http://upload.wikimedia.org/wikipedia/commons/f/f7/PRESBITERIANA_1.jpg\"></div>\n" +
"                            	<div style=\"color:#245da5; font-family:Times New Roman, Times, serif; font-size:25px;\">Himnario Presbiteriano de M&eacute;xico.</div>\n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        \n" +
"                          <tr>\n" +
"                            <td align=\"left\" valign=\"top\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;\">\n" +
"                              <br>\n" +
"                              <div><p style=\"text-align:justify\">Hola <b><u>"+user+"</u></b>, te damos la bienvenida al Himnario Presbiteriano en L&iacute;nea \"S&oacute;lo a Dios la Gloria\", gracias por registrarte.</p></div>\n" +
"                              <br><p style=\"text-align:justify\">\"La Iglesia Nacional Presbiteriana de M&eacute;xico, es una organizaci&oacute;n cristiana presbiteriana que agrupa a m&aacute;s de 6,000 iglesias y cuenta con 437,690 miembros seg&uacute;n el Censo de Poblaci&oacute;n y Vivienda 2010 en M&eacute;xico. Puede considerarse la denominaci&oacute;n presbiteriana m&aacute;s grande del pa&iacute;s y como la segunda denominaci&oacute;n protestante m&aacute;s grande despu&eacute;s de las Asambleas de Dios.\"</p><br>\n" +
"                            </td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                        <td height=\"50\" valign=\"middle\" style=\"background-color:#3770b7;color:#FFFFFF; border-radius: 5px;font-size:11px; font-family:Arial, Helvetica, sans-serif;text-align:center\">\n" +
"                            <b>Cont&aacute;ctanos por correo  electr&oacute;nico: </b> godweb.mx@gmail.com.  <b> <p>Web desarrollada por:</b> \n" +
"                            <a href=\"https://mx.linkedin.com/pub/gustavo-ulises-trejo-armenta/94/aa6/262\">Ulysses M@c</a> </p>\n" +
"                        </td>\n" +
"                      </tr>\n" +
"                      </table>\n" +
"                    </td>\n" +
"                  </tr>\n" +
"              </table>\n" +
"               </td>\n" +
"            </tr>\n" +
"        </table>\n" +
"        <br>\n" +
"        <br>\n" +
"     </tr>\n" +
"</table>\n" +
"</div>\n" +
"</body>\n" +
"</html>", true);
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
            failed.setSubject("Gracias por registrate en nuestra página, Solo a Dios la Gloria.");
            failed.setName(user);
            failed.setBody("<html><h2><strong>Bienvenido: "+user+"</strong></h2></html>");
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

    public void recuperarPassword(final String email, final String password, final String bccEmail) {
        try {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, "UTF-8");
                messageHelper.setSubject("Recuperación de contraseña, Solo a Dios la Gloria.");
                messageHelper.setTo(email);
                messageHelper.setBcc(bccEmail);
                messageHelper.setText("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"<head>\n" +
"<title></title>\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"<style type=\"text/css\">\n" +
"  a{\n" +
"   color:#ffffff; \n" +
"  }\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<div style=\"width:100%;\" align=\"center\">\n" +
"<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"  <tr>\n" +
"        <br>\n" +
"        <br>\n" +
"        <table width=\"583\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"          <tr>\n" +
"            <td align=\"left\" valign=\"top\"><img src=\"http://imageshack.com/a/img910/9964/oa9XQ1.jpg\" width=\"583\" height=\"118\" style=\"border-radius: 5px\"></td>\n" +
"          </tr>\n" +
"          <tr>\n" +
"            <td align=\"left\" valign=\"top\" bgcolor=\"#FFFFFF\" style=\"background-color:#FFFFFF;\">\n" +
"              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"                  <tr>\n" +
"                    <td align=\"left\" valign=\"top\">\n" +
"                      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"                          <tr>\n" +
"                            <td align=\"center\" valign=\"top\">\n" +
"                              <div style=\"text-align:center;\"><img style=\"height: 200px; width: 200px;\" src=\"http://upload.wikimedia.org/wikipedia/commons/f/f7/PRESBITERIANA_1.jpg\"></div>\n" +
"                            	<div style=\"color:#245da5; font-family:Times New Roman, Times, serif; font-size:25px;\">Himnario Presbiteriano de M&eacute;xico.</div>\n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        \n" +
"                          <tr>\n" +
"                            <td align=\"left\" valign=\"top\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;\">\n" +
"                              <br>\n" +
"                              <div><p style=\"text-align:justify\">Hola tu password para ingresar al sistema es: <b><u>"+password+".</u></b></p></div>\n" +
"                              <br><p style=\"text-align:justify\">\"La Iglesia Nacional Presbiteriana de M&eacute;xico, es una organizaci&oacute;n cristiana presbiteriana que agrupa a m&aacute;s de 6,000 iglesias y cuenta con 437,690 miembros seg&uacute;n el Censo de Poblaci&oacute;n y Vivienda 2010 en M&eacute;xico. Puede considerarse la denominaci&oacute;n presbiteriana m&aacute;s grande del pa&iacute;s y como la segunda denominaci&oacute;n protestante m&aacute;s grande despu&eacute;s de las Asambleas de Dios.\"</p><br>\n" +
"                            </td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                        <td height=\"50\" valign=\"middle\" style=\"background-color:#3770b7;color:#FFFFFF; border-radius: 5px;font-size:11px; font-family:Arial, Helvetica, sans-serif;text-align:center\">\n" +
"                            <b>Cont&aacute;ctanos por correo  electr&oacute;nico: </b> godweb.mx@gmail.com.  <b> <p>Web desarrollada por:</b> \n" +
"                            <a href=\"https://mx.linkedin.com/pub/gustavo-ulises-trejo-armenta/94/aa6/262\">Ulysses M@c</a> </p>\n" +
"                        </td>\n" +
"                      </tr>\n" +
"                      </table>\n" +
"                    </td>\n" +
"                  </tr>\n" +
"              </table>\n" +
"               </td>\n" +
"            </tr>\n" +
"        </table>\n" +
"        <br>\n" +
"        <br>\n" +
"     </tr>\n" +
"</table>\n" +
"</div>\n" +
"</body>\n" +
"</html>", true);
            }
        };
            this.mailSender.send(preparator);
            this.log.info(" -- Correo enviado a: "+email);
        } catch (MailException e) {
            DeliveryFailed failed = new DeliveryFailed();
            failed.setMailTo(email);
            failed.setMailFrom("godweb.mx@gmail.com");
            failed.setSubject("Recuperación de contraseña, Solo a Dios la Gloria.");
            failed.setName(email);
            failed.setBody("<html><h2><strong>Hola tu password para ingresar al sistema es: "+password+"</strong></h2></html>");
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

    public void contactoSistema(final String emailSistema, final String asunto, final String nombre, final String emailCliente, final String boydAsunto) {
       try {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, "UTF-8");
                messageHelper.setSubject(asunto);
                messageHelper.setTo(emailSistema);
                messageHelper.setText("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"<head>\n" +
"<title></title>\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
"<style type=\"text/css\">\n" +
"  a{\n" +
"   color:#ffffff; \n" +
"  }\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<div style=\"width:100%;\" align=\"center\">\n" +
"<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"  <tr>\n" +
"        <br>\n" +
"        <br>\n" +
"        <table width=\"583\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"          <tr>\n" +
"            <td align=\"left\" valign=\"top\"><img src=\"http://imageshack.com/a/img910/9964/oa9XQ1.jpg\" width=\"583\" height=\"118\" style=\"border-radius: 5px\"></td>\n" +
"          </tr>\n" +
"          <tr>\n" +
"            <td align=\"left\" valign=\"top\" bgcolor=\"#FFFFFF\" style=\"background-color:#FFFFFF;\">\n" +
"              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"                  <tr>\n" +
"                    <td align=\"left\" valign=\"top\">\n" +
"                      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
"                          <tr>\n" +
"                            <td align=\"center\" valign=\"top\">\n" +
"                              <div style=\"text-align:center;\"><img style=\"height: 200px; width: 200px;\" src=\"http://upload.wikimedia.org/wikipedia/commons/f/f7/PRESBITERIANA_1.jpg\"></div>\n" +
"                            	<div style=\"color:#245da5; font-family:Times New Roman, Times, serif; font-size:25px;\">Himnario Presbiteriano de M&eacute;xico.</div>\n" +
"                            </td>\n" +
"                          </tr>\n" +
"                        \n" +
"                          <tr>\n" +
"                            <td align=\"left\" valign=\"top\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#525252;\">\n" +
"                              <br>\n" +
"                              <div><p style=\"text-align:justify\">\n" +
"                                    Email de usuario: <b><u>"+emailCliente+"</u></b><br>\n" +
"                                    Nombre: <b><u>"+nombre+".</u></b><br><br>\n" +
"                                    Asunto: "+boydAsunto+"\n" +
"\n" +
"                              </p></div>\n" +
"                              <br><p style=\"text-align:justify\">\"La Iglesia Nacional Presbiteriana de M&eacute;xico, es una organizaci&oacute;n cristiana presbiteriana que agrupa a m&aacute;s de 6,000 iglesias y cuenta con 437,690 miembros seg&uacute;n el Censo de Poblaci&oacute;n y Vivienda 2010 en M&eacute;xico. Puede considerarse la denominaci&oacute;n presbiteriana m&aacute;s grande del pa&iacute;s y como la segunda denominaci&oacute;n protestante m&aacute;s grande despu&eacute;s de las Asambleas de Dios.\"</p><br>\n" +
"                            </td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                        <td height=\"50\" valign=\"middle\" style=\"background-color:#3770b7;color:#FFFFFF; border-radius: 5px;font-size:11px; font-family:Arial, Helvetica, sans-serif;text-align:center\">\n" +
"                            <b>Cont&aacute;ctanos por correo  electr&oacute;nico: </b> godweb.mx@gmail.com.  <b> <p>Web desarrollada por:</b> \n" +
"                            <a href=\"https://mx.linkedin.com/pub/gustavo-ulises-trejo-armenta/94/aa6/262\">Ulysses M@c</a> </p>\n" +
"                        </td>\n" +
"                      </tr>\n" +
"                      </table>\n" +
"                    </td>\n" +
"                  </tr>\n" +
"              </table>\n" +
"               </td>\n" +
"            </tr>\n" +
"        </table>\n" +
"        <br>\n" +
"        <br>\n" +
"     </tr>\n" +
"</table>\n" +
"</div>\n" +
"</body>\n" +
"</html>", true);
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
            failed.setBody("<html><h2><strong>Email de Usuario: "+emailCliente+"<br>"
                        + "Nombre: "+nombre+"<br>"
                        + "Asunto: "+boydAsunto+"<br>"
                        + "</strong></h2></html>");
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
    
    private final Logger log = Logger.getLogger(EmailSendServiceImpl.class);
}