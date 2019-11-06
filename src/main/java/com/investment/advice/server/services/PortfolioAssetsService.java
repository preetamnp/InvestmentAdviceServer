package com.investment.advice.server.services;

import io.swagger.model.Asset;

import java.util.List;

public interface PortfolioAssetsService {
    List<Asset> getAssets(Integer portfolioId);
}
