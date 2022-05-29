package com.fonix.colab.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "removeUrlJsessionIdFilter")
public class RemoveUrlJsessionIdFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        // skip non-http requests
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }

        //从url中删除jsessionid
        // isRequestedSessionIdFromURL():Checks whether the requested session ID came in as part of the request URL.
        if (httpServletRequest.isRequestedSessionIdFromURL()) {
            HttpSession session = httpServletRequest.getSession();
            if (null != session) {
                session.invalidate();
            }
        }
        // wrap response to remove URL encoding
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpServletResponse) {
            @Override
            public String encodeRedirectUrl(String url) {
                return url;
            }
            @Override
            public String encodeRedirectURL(String url) {
                return url;
            }
            @Override
            public String encodeUrl(String url) {
                return url;
            }
            @Override
            public String encodeURL(String url) {
                return url;
            }
        };
        // process next request in chain
        chain.doFilter(request, wrappedResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
