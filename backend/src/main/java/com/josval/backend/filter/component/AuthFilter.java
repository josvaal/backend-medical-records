package com.josval.backend.filter.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josval.backend.model.payload.MessageResponse;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.logging.Logger;

@Component
@Order(3)
public class AuthFilter implements Filter {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void doFilter(
      ServletRequest servletRequest,
      ServletResponse servletResponse,
      FilterChain filterChain
  ) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;
    Logger logger = Logger.getLogger(AuthFilter.class.getName());

    if(
        Objects.equals(req.getRequestURI(), "/api/v1/auth/login") ||
        Objects.equals(req.getRequestURI(), "/api/v1/auth/register")
    ){
      res.setContentType("application/json");
      res.setStatus(HttpServletResponse.SC_OK);

      PrintWriter out = res.getWriter();
      out.print(objectMapper.writeValueAsString(
              MessageResponse
                  .builder()
                  .message("Auth requests")
                  .object(null)
                  .build()
          )
      );
      out.flush();
      return;
    }

    filterChain.doFilter(servletRequest, servletResponse);
  }
}
