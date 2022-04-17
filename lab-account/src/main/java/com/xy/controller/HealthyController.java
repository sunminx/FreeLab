package com.xy.controller;

import com.xy.IAccountHealth;
import com.xy.entity.ResultEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthyController implements IAccountHealth {

    @Override
    public ResultEntity<String> checkHealthy() {
        return new ResultEntity<>("health");
    }
}
