package com.investment.advice.server.InvestmentAdviceServer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Asset;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;


@Service
public class AdviceInvestmentServiceImpl implements AdviceInvestmentService {



    public List<Asset> getAssets(Integer riskLevel, Boolean esg) {
        RestTemplate restTemplate = getRestTemplate();
        String resourceUrl
                = "http://localhost:9999/advice";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(resourceUrl)
                .queryParam("riskLevel", riskLevel)
                .queryParam("esg", esg);

        ResponseEntity<List<Asset>> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Asset>>(){});
        return response.getBody();
    }

    private RestTemplate getRestTemplate() {
            RestTemplate restTemplate = new RestTemplate();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
            restTemplate.getMessageConverters().add(converter);
            return restTemplate;
        }

}
