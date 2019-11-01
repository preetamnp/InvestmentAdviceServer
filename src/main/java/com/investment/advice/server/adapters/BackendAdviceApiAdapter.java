package com.investment.advice.server.adapters;

import com.investment.advice.server.configuration.BackendAdviceServerProperties;
import io.swagger.model.Asset;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class BackendAdviceApiAdapter {

    private RestTemplate restTemplate;
    private BackendAdviceServerProperties backendAdviceServerProperties;

    public BackendAdviceApiAdapter(RestTemplate restTemplate, BackendAdviceServerProperties backendAdviceServerProperties) {
        this.restTemplate  = restTemplate;
        this.backendAdviceServerProperties = backendAdviceServerProperties;
    }

    public List<Asset> getAssets(Integer riskLevel, Boolean esg) {

        UriComponentsBuilder builder = getUriComponentsBuilder(riskLevel, esg);
        ResponseEntity<List<Asset>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Asset>>(){});
        return response.getBody();
    }

    private UriComponentsBuilder getUriComponentsBuilder(Integer riskLevel, Boolean esg) {

        String resourceUrl
                = backendAdviceServerProperties.getHostName() + backendAdviceServerProperties.getAdviceUri();

        return UriComponentsBuilder.fromHttpUrl(resourceUrl)
                .queryParam("riskLevel", riskLevel)
                .queryParam("esg", esg);
    }


}
