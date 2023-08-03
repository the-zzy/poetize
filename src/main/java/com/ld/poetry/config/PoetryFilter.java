package com.ld.poetry.config;

import com.ld.poetry.utils.CommonQuery;
import com.ld.poetry.utils.PoetryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PoetryFilter extends OncePerRequestFilter {

    @Autowired
    private CommonQuery commonQuery;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            commonQuery.saveHistory(PoetryUtil.getIpAddr(httpServletRequest));
        } catch (Exception e) {
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
