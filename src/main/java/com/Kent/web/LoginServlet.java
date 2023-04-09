package com.Kent.web;

import com.Kent.pojo.User;
import com.Kent.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 取得使用者名稱和密碼
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2. 調用 Service 查詢
        User user = service.login(username, password);

        // 3. 判斷
        if (user != null) {
            // 登錄成功, 重定向到 查詢所有的 BrandServlet

            // 將登錄成功後的 User 物件，儲存在 Session 中
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            String contextPath = req.getContextPath();

            // 登入成功是第一次請求，跳轉到第二個頁面是第二次請求，
            // 因為多個請求中要共享資料，需要使用 session 或是 cookie，
            // 這時候如果使用 request，第二次請求的時候，資料就不見了
            resp.sendRedirect(contextPath + "/selectAllServlet");
        } else {
            // 登錄失敗

            // 儲存錯次訊息到 request
            req.setAttribute("login_msg", "使用者名稱或密碼錯誤");

            // 跳轉到 login.jsp
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
