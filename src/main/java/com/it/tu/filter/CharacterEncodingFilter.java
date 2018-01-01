package com.it.tu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CharacterEncodingFilter implements Filter {

  private String encode;

  public void destroy() {
    this.encode = null;
  }

  /**
    * name="FilterChar" <br>
    * init-param name="config" value="utf-8"<br>
    * mapping url-pattern="/*"<br>
    */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req;
    req = (HttpServletRequest) request;
    HttpServletResponse res;
    res = (HttpServletResponse) response;
    req.setCharacterEncoding(encode);
    res.setCharacterEncoding(encode);
    res.setContentType("text/html;charset=UTF-8");
    chain.doFilter(req, res);

  }

  public void init(FilterConfig config) throws ServletException {
    this.encode = config.getInitParameter("encode");
  }

}
