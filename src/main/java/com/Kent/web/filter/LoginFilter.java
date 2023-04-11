package com.Kent.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登錄驗證的過濾器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;

        // 判斷訪問資源路徑是否和登錄註冊相關
        String[] urls = {"/login.jsp", "/imgs/", "/css", "/loginServlet", "/register.jsp", "registerServlet", "/checkCodeServlet"};
        String url = req.getRequestURL().toString();
        System.out.println(url);

        // 循環判斷
        for (String u: urls) {
            if(url.contains(u)) {
                // 找到了，放行
                filterChain.doFilter(req, servletResponse);
                return;
            }
        }

        // 1. 判斷 session 中是否有 User
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        // 2. 判斷 user 是否為 null
        if (user != null) {
            // 登錄過了
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 沒有登錄，存儲提示訊息，跳轉到登錄頁面
            req.setAttribute("login_msg", "你尚未登入");
            req.getRequestDispatcher("/login.jsp").forward(req, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
