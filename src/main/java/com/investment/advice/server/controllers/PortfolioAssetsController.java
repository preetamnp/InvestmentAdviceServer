package com.investment.advice.server.controllers;

import com.investment.advice.server.services.PortfolioAssetsService;
import io.swagger.api.AssetsApi;
import io.swagger.model.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PortfolioAssetsController implements AssetsApi {

    @Autowired
    private PortfolioAssetsService portfolioAssetsService;


    @Override
    public ResponseEntity<List<Asset>> getPortfolioAssets (Integer portfolioId) {
        return new ResponseEntity<>(portfolioAssetsService.getAssets(portfolioId), HttpStatus.OK);
    }

}
