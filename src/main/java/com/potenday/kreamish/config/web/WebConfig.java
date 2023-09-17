package com.potenday.kreamish.config.web;

import com.potenday.kreamish.item.resolver.ItemGetItemsArgumentResolver;
import com.potenday.kreamish.login.resolver.LoginMemberArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final ItemGetItemsArgumentResolver itemGetItemsArgumentResolve;

    private final LoginMemberArgumentResolver loginMemberArgumentResolver;

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(itemGetItemsArgumentResolve);
        argumentResolvers.add(loginMemberArgumentResolver);
    }
}