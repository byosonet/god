package com.rest.services.service;

import java.io.File;
import java.util.Map;

/**
 *
 * @author Priscila
 */

public interface EmailSendService
{
  void sendEmailRegister(final String toEmail,final String bccEmail, final String user, final Map<String, File> attach) throws Exception;
  void recuperarPassword(final String email, final String password, final String bccEmail);
}