package com.investment.advice.server.InvestmentAdviceServer.services;

import io.swagger.model.Asset;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AdviceInvestmentService {
    public List<Asset> getAssets();
}
