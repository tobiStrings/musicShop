package com.example.musicalinstrumentstore.security;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@PropertySource("classpath:securityConstants.properties")
@Configuration
public class CrosConfig implements Filter {
    @Value("${FRONTEND_ADDRESS}")
    private String frontEnd;

    @Value("${SECOND_FRONTEND_ADDRESS}")
    private String secondFrontEnd;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if (frontEnd.equalsIgnoreCase(request.getHeader("Origin"))) {
            response.setHeader("Access-Control-Allow-origin", frontEnd);
            //response.setHeader("Access-Control-Allow-origin", secondFrontEnd);

            log.info("Allow access ***************************************");
        }
        else{
            log.info("Not Allowed ...........................");
        }

        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-headers", "X-Requested-With, Content-Type, origin, Accept, Access-Control-Request-Method," +
                " Access-Control-Request-Headers");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
