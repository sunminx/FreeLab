package com.xy;

import com.xy.constant.AccountConstant;
import com.xy.entity.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "账户服务健康检查")
@FeignClient(value = AccountConstant.ACCOUNT_SERVICE_NAME)
public interface IAccountHealth {

    @ApiOperation(value = "健康检查")
    @GetMapping("/health")
    ResultEntity<String> checkHealthy();
}
