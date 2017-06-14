package com.vince.one.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.vince.one.dao.SecurityDb;

@Service
public class ClientService implements ClientDetailsService {

    @Autowired
    private SecurityDb  securityDb;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        BaseClientDetails clientDetails =  securityDb.getByClientId(s);
        return clientDetails;
    }
}
