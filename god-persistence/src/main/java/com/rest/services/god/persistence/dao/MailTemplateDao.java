package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.MailTemplate;

/**
 *
 * @author User
 */
public interface MailTemplateDao {
    MailTemplate getMail(int idMail);
}
