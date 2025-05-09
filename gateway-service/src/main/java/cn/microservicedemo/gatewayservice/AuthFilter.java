package cn.microservicedemo.gatewayservice;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求参数的token
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        System.out.println(token);
        if(!token.equals("1")) {
            // 响应HTTP 401
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        // 继续执行过滤器链中的下一个资源
        return chain.filter(exchange);
    }
}
