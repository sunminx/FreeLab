package com.xy;

import com.xy.constant.AccountConstant;
import com.xy.entity.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "账户服务健康检查")
@FeignClient(value = AccountConstant.ACCOUNT_SERVICE_NAME)
@RequestMapping(path = AccountConstant.ACCOUNT_SERVICE_URL_PATH_PREFIX)
public interface IAccountHealth {

    @ApiOperation(value = "健康检查")
    @GetMapping("/health")
    ResultEntity<String> checkHealthy();
}
