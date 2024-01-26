package com.integralpivots.gera.application;
import com.integralpivots.gera.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import com.integralpivots.gera.GeraRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@FeignClient(name = "gera-email-service", url = "${gera.email}")
public interface GeraEmailService {
    @PostMapping("/email/register-url-email")
    public GeraRes sendRegisterUrlEmail(@RequestBody EmailRequest request);
}
