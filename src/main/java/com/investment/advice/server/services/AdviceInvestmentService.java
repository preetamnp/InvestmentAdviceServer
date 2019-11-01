package com.investment.advice.server.services;

import io.swagger.model.Asset;

import java.util.List;

public interface AdviceInvestmentService {
    List<Asset> getAssets(Integer riskLevel, Boolean esg);
}
