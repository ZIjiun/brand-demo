package com.Kent.web;

import com.Kent.pojo.Brand;
import com.Kent.service.BrandService;
import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet2")
public class AddServlet2 extends HttpServlet {

    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收資料，getParameter()只能接收字串，不能直接接收 JSON 資料
//        String brandName = req.getParameter("brandName");
//        System.out.println(brandName);

        // 獲取請求體資料
        BufferedReader br = req.getReader();
        String params = br.readLine();

        // 將 JSON 字串轉為 Java 物件
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);

        // 調用 sevice 增加
        service.add(brand);

        // 3. 響應成功標示
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
