DROP TABLE IF EXISTS auth_details;
CREATE TABLE auth_details (
  username varchar(64),
  password varchar(256),
  PRIMARY KEY (username)
) ENGINE=InnoDB ;

-- user_vince/password  for test
insert into auth_details values('user_vince','$2a$11$gxpnezmYfNJRYnw/EpIK5Oe08TlwZDmcmUeKkrGcSGGHXvWaxUwQ2');

DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details (
  client_id varchar(64) NOT NULL,
  resource_ids varchar(256) DEFAULT NULL,
  client_secret varchar(256) DEFAULT NULL,
  scope varchar(256) DEFAULT NULL,
  authorized_grant_types varchar(256) DEFAULT NULL,
  web_server_redirect_uri varchar(256) DEFAULT NULL,
  authorities varchar(256) DEFAULT NULL,
  refresh_token_validity int(11) DEFAULT NULL,
  access_token_validity int(11) DEFAULT NULL,
  additional_information varchar(4096) DEFAULT NULL,
  autoapprove varchar(4096) DEFAULT NULL,
  PRIMARY KEY (client_id)
);

INSERT INTO oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, authorities, refresh_token_validity, access_token_validity)
VALUES ('client_vince_id', 'resrc_api', 'secret', 'trust,read,write', 'password,authorization_code,refresh_token,implicit', 'ROLE_USER', '1000', '100');

DROP TABLE IF EXISTS oauth_access_token;

CREATE TABLE oauth_access_token (
  token_id varchar(256) DEFAULT NULL,
  token blob,
  authentication_id varchar(256) DEFAULT NULL,
  user_name varchar(256) DEFAULT NULL,
  client_id varchar(256) DEFAULT NULL,
  authentication blob,
  refresh_token varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS oauth_refresh_token;

CREATE TABLE oauth_refresh_token (
  token_id varchar(256) DEFAULT NULL,
  token blob,
  authentication blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
