package com.investment.advice.server.controllers;

import com.investment.advice.server.services.AdviceInvestmentService;
import io.swagger.api.AdviceApi;
import io.swagger.model.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AdviceInvestmentController implements AdviceApi {

    @Autowired
    private AdviceInvestmentService adviceInvestmentService;


    @Override
    public ResponseEntity<List<Asset>> getAdvice (Integer riskLevel, Boolean esg) {
        return new ResponseEntity<>(adviceInvestmentService.getAssets(riskLevel,esg), HttpStatus.OK);
    }

}
