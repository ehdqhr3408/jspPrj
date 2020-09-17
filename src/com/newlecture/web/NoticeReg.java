package com.newlecture.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //보낼때 타입 지정
        resp.setCharacterEncoding("UTF-8");
        //받을때 타입 지정
        resp.setContentType("text/html; charset=UTF-8");
        
        /*클라이언트가 서버에 요청하는 인코딩 설정*/
        //req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        out.println(title);
        out.println(content);

    }
}
