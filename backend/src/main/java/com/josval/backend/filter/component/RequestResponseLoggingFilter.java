package com.josval.backend.filter.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component
@Order(2)
public class RequestResponseLoggingFilter implements Filter {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void doFilter(
      ServletRequest servletRequest,
      ServletResponse servletResponse,
      FilterChain filterChain
  ) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;
    Logger logger = Logger.getLogger(RequestResponseLoggingFilter.class.getName());

    logger.info("Logging Request "
            .concat(req.getMethod())
            .concat(" : ")
            .concat(req.getRequestURI())
    );

    filterChain.doFilter(servletRequest, servletResponse);

    String contentType = res.getContentType();

    if (contentType != null && !contentType.isEmpty()) {
      logger.info("Logging Response: ".concat(contentType));
    } else {
      logger.info("Logging Response: Content type is null or empty.");
    }
  }
}
