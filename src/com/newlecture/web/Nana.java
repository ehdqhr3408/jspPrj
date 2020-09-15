package com.newlecture.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hi")
public class Nana extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //보낼때 타입 지정
        resp.setCharacterEncoding("UTF-8");
        //받을때 타입 지정
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        for(int i=0;i<100;i++){
            out.println((i+1)+": 안녕 Servlet!!<br>");
        }
    }
}
