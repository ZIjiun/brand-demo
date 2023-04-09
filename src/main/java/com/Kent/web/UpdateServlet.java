package com.Kent.web;

import com.Kent.pojo.Brand;
import com.Kent.service.BrandService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

    // service 物件因為有可能會在多處用到，所以放在全域的位置
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 處理 POST請求的亂碼問題
        req.setCharacterEncoding("utf-8");

        // 1. 接收表單提交的資料，封為唯一個 Brand 物件
        String id = req.getParameter("id");
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");

        // 封裝為 Brand 物件
        Brand brand = new Brand();
        brand.setId(Integer.parseInt(id));
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        // 2. 調用 service 完成查詢
        service.update(brand);

        // 3. 轉發到查詢所有的 servlet
        req.getRequestDispatcher("/selectAllServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
