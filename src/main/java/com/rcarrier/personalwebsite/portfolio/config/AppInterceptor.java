package com.rcarrier.personalwebsite.portfolio.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AppInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AppInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Map<String, String> parameters = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            parameters.put(paramName, request.getParameter(paramName));
        }
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();

            while (fileNames.hasNext()) {
                String fileName = fileNames.next();
                MultipartFile file = multipartHttpServletRequest.getFile(fileName);

                if (file != null) {
                    parameters.put(fileName, file.getOriginalFilename());
                }
            }
        }

        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }

        log.info("Request parameters: {}", parameters);
        log.info("Request headers: {}", headers);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("HTTP Status: {}", response.getStatus());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            log.error("Exception occurred: {}", ex);
        }
    }
}
