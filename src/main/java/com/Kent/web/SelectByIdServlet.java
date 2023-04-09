package com.Kent.web;

import com.Kent.pojo.Brand;
import com.Kent.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {

    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收 id
        String id = req.getParameter("id");

        // 2. 調用 servlet 查詢
        Brand brand = service.selectById(Integer.parseInt(id));
        // 3. 儲存到 request 中
        req.setAttribute("brand", brand);
        // 4. 轉發到 update.jsp
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
