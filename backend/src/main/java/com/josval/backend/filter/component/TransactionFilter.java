package com.josval.backend.filter.component;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

@Component
@Order(1)
public class TransactionFilter implements Filter {
  @Override
  public void doFilter(
      ServletRequest servletRequest,
      ServletResponse servletResponse,
      FilterChain filterChain
  ) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    Logger logger = Logger.getLogger(TransactionFilter.class.getName());

    logger.info("Starting a transaction for req : "
        .concat(req.getRequestURI())
    );

    filterChain.doFilter(servletRequest, servletResponse);

    logger.info(
        "Committing a transaction for req : ".concat(req.getRequestURI())
    );
  }
}
