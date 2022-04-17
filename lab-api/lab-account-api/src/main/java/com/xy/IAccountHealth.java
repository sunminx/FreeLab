package com.xy;

import com.xy.constant.AccountConstant;
import com.xy.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = AccountConstant.ACCOUNT_SERVICE_NAME)
@RequestMapping(path = AccountConstant.ACCOUNT_SERVICE_URL_PATH_PREFIX)
public interface IAccountHealth {

    @GetMapping("/health")
    ResultEntity<String> checkHealthy();
}
