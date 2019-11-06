package com.investment.advice.server.services;

import com.investment.advice.server.adapters.BackendApiAdapter;
import io.swagger.model.Asset;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioAssetsServiceImpl implements PortfolioAssetsService {

    private BackendApiAdapter backendApiAdapter;

    public PortfolioAssetsServiceImpl(BackendApiAdapter backendApiAdapter) {
        this.backendApiAdapter = backendApiAdapter;
    }

    @Override
    public List<Asset> getAssets(Integer portfolioId) {
        //perform any model mappings from internal to external models.
        //since its a demo, we dont perform any model conversion
        return backendApiAdapter.getAssets(portfolioId);
    }

}
