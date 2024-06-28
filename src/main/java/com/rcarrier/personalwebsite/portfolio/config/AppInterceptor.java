package com.rcarrier.personalwebsite.portfolio.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Enumeration;

public class AppInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AppInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[preHandle][{}][{}]{}", request, request.getMethod(), request.getRequestURI());

        // Log headers
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            log.info("Header: " + headerName + " = " + request.getHeader(headerName));
        }

        // Log authenticated user (if any)
        if (request.getUserPrincipal() != null) {
            log.info("User: " + request.getUserPrincipal().getName());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[postHandle][{}]", request);
        log.info("Request End Time: " + LocalDateTime.now());
        log.info("HTTP Status: " + response.getStatus());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("[afterCompletion][{}][exception: {}]", request, ex);
    }
}
