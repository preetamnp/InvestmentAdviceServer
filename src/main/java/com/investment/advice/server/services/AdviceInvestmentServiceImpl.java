package com.investment.advice.server.services;

import com.investment.advice.server.adapters.BackendApiAdapter;
import io.swagger.model.Asset;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceInvestmentServiceImpl implements AdviceInvestmentService {

    private BackendApiAdapter backendApiAdapter;

    public AdviceInvestmentServiceImpl(BackendApiAdapter backendApiAdapter) {
        this.backendApiAdapter = backendApiAdapter;
    }

    @Override
    public List<Asset> getAssets(Integer riskLevel, Boolean esg) {
        //perform any model mappings from internal to external models.
        //since its a demo, we dont perform any model conversion
        return backendApiAdapter.getAssets(riskLevel,esg);
    }

}
