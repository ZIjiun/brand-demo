package com.Kent.web;

import com.Kent.pojo.User;
import com.Kent.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 取得使用者名稱和密碼
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // 獲取用戶輸入的驗證碼
        String checkCode = req.getParameter("checkCode");

        // 獲取程式生成的驗證碼
        HttpSession session = req.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        // 比對
        if (!checkCodeGen.equalsIgnoreCase(checkCode)) {
            req.setAttribute("register_msg", "驗證碼錯誤");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);

            // 不允許註冊
            return;
        }

        // 2. 調用 service 進行註冊
        boolean flag = service.register(user);

        // 3. 判斷註冊成功與否
        if (flag) {
            // 註冊成功，跳轉到登錄頁面

            req.setAttribute("register_msg", "註冊成功，請登錄");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            // 註冊失敗，跳轉到註冊頁面

            req.setAttribute("register_msg", "使用者名稱已存在");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
