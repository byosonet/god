package com.rest.services.service;

import com.rest.services.god.persistence.hbm.MailTemplate;

/**
 *
 * @author User
 */
public interface MailTemplateService {
    MailTemplate getEmail (int idMail);
}
