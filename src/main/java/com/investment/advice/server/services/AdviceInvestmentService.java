package com.investment.advice.server.services;

import io.swagger.model.Asset;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AdviceInvestmentService {
    public List<Asset> getAssets(Integer riskLevel, Boolean esg);
}
