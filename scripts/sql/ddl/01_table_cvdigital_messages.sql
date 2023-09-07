CREATE TABLE cvdigital_messages (
  cvdigital_messages_id INT(11) NOT NULL AUTO_INCREMENT,
  email_template_id INT(11) NOT NULL,
  ats_user_id INT(11) NOT NULL,
  applicant_id BIGINT(20) NOT NULL,
  creation_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  date_last_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (cvdigital_messages_id),
  INDEX fk_cvdigital_messages_1_idx (applicant_id ASC),
  INDEX fk_cvdigital_messages_2_idx (ats_user_id ASC),
  INDEX fk_cvdigital_messages_3_idx (email_template_id ASC),
  CONSTRAINT fk_cvdigital_messages_applicant
    FOREIGN KEY (applicant_id)
    REFERENCES applicant (applicant_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_cvdigital_messages_ats_user
    FOREIGN KEY (ats_user_id)
    REFERENCES ats_user (ats_user_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_cvdigital_messages_email_template
    FOREIGN KEY (email_template_id)
    REFERENCES email_template (email_template_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
