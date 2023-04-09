package com.Kent.web;

import com.Kent.pojo.Brand;
import com.Kent.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class selectAllServlet extends HttpServlet {

    // service 物件因為有可能會在多處用到，所以放在全域的位置
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 調用 BrandService 完成查詢
        List<Brand> brands = service.selectAll();

        // 2. 存入 request 域中
        req.setAttribute("brands", brands);

        // 3. 轉發到 brand.jsp
        req.getRequestDispatcher("/brand.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
