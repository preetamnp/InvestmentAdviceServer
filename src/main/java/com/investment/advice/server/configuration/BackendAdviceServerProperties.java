package com.investment.advice.server.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("backend-advice-server")
@Data
public class BackendAdviceServerProperties {

    private String hostName;
    private String adviceUri;
    private String assetsUri;

}
