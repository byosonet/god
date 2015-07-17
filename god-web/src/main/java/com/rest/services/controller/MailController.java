package com.rest.services.controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/send")
public class MailController {
    private final Logger log = Logger.getLogger(MailController.class);
    @RequestMapping(value="/mail", method = RequestMethod.GET)
    public String enviarEmail() throws MessagingException{
        String vista = "notemail";
        Sample sample = new Sample();
        try{
            sample.sendEmail();
            vista = "yesemail";
        }catch(Exception ex){
            throw new RuntimeException();
        }
        return vista;
    }
}
