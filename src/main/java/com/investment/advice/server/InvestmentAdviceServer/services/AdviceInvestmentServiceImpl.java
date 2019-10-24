package com.investment.advice.server.InvestmentAdviceServer.services;

import io.swagger.model.Asset;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdviceInvestmentServiceImpl implements AdviceInvestmentService {

    public List<Asset> getAssets() {
        Asset asset1 = new Asset();
        asset1.setIsin(1234L);
        asset1.setName("ABC CORP");
        asset1.setQuantity(2);
        asset1.setValue(1349.00);
        asset1.setType("FIXED INCOME BOND");
        Asset asset2 = new Asset();
        asset2.setIsin(789L);
        asset2.setName("XYZ CORP");
        asset2.setQuantity(4);
        asset2.setValue(1577.50);
        asset2.setType("CORP BOND");
        List<Asset> assets = new ArrayList<>();
        assets.add(asset1);
        assets.add(asset2);
        return assets;
    }
}
