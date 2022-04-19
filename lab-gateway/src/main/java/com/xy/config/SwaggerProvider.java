package com.xy.config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.*;

@Component
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider {

    public static final String API_URI = "/v3/api-docs?group=cruzgo";
    private final RouteLocator routeLocator;
    private final GatewayProperties gatewayProperties;

    public SwaggerProvider(RouteLocator routeLocator, GatewayProperties gatewayProperties) {
        this.routeLocator = routeLocator;
        this.gatewayProperties = gatewayProperties;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        // 取出gateway的route
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        // 结合配置的route-路径(Path)，和route过滤，只获取在枚举中说明的route节点
        for (RouteDefinition routeDefinition : gatewayProperties.getRoutes()) {
            if (!routes.contains(routeDefinition.getId())) continue;
            List<PredicateDefinition> predicateDefinitionList = routeDefinition.getPredicates();
            for (PredicateDefinition predicateDefinition : predicateDefinitionList) {
                if ("Path".equalsIgnoreCase(predicateDefinition.getName())) {
                    String routeId = routeDefinition.getId();
                    String swaggerInfo = ServerRouteEnum.getSwaggerInfoByRoutId(routeId);
                    if (swaggerInfo != null && !"".equalsIgnoreCase(swaggerInfo)) {
                        resources.add(swaggerResource(swaggerInfo, predicateDefinition.getArgs()
                                .get(NameUtils.GENERATED_NAME_PREFIX + "0").replace("/**", API_URI)));
                    }
                }
            }
        }

        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("3.0");
        return swaggerResource;
    }

}
