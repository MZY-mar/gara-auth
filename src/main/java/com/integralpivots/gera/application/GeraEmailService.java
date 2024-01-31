package com.integralpivots.gera.application;

import com.integralpivots.gera.EmailRequest;
import com.integralpivots.gera.GeraRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Description:
 * -
 * Author: longf
 * Date: 2023-12-26
 */
@FeignClient(name = "gera-email-service", url = "${gera.email}")
public interface GeraEmailService {
    @PostMapping(value = "/email/register-url-email")
    public GeraRes sendRegisterUrlEmail(@RequestBody EmailRequest emailRequest);
}

