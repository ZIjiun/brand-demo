package com.Kent.web;

import com.Kent.pojo.Brand;
import com.Kent.service.BrandService;
import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet2")
public class selectAllServlet2 extends HttpServlet {

    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("123");

        // 1. 調用 service 查詢
        List<Brand> brands = service.selectAll();

        // 2. 將集合轉換為 JSON 資料: 序列化
        String jsonString = JSON.toJSONString(brands);

        // 3. 響應資料
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
