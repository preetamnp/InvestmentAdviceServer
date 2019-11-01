package com.investment.advice.server.services;

import com.investment.advice.server.adapters.BackendAdviceApiAdapter;
import io.swagger.model.Asset;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceInvestmentServiceImpl implements AdviceInvestmentService {

    private BackendAdviceApiAdapter backendAdviceApiAdapter;

    public AdviceInvestmentServiceImpl(BackendAdviceApiAdapter backendAdviceApiAdapter) {
        this.backendAdviceApiAdapter = backendAdviceApiAdapter;
    }

    @Override
    public List<Asset> getAssets(Integer riskLevel, Boolean esg) {
        //perform any model mappings from internal to external models.
        //since its a demo, we dont perform any model conversion
        return backendAdviceApiAdapter.getAssets(riskLevel,esg);
    }

}
