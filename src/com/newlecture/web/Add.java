package com.newlecture.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class Add extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*답안지*/
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String x_ = req.getParameter("x");
        String y_ = req.getParameter("y");

        int x = 0;
        int y = 0;

        if(!x_.equals("")) x = Integer.parseInt(x_);
        if(!y_.equals("")) y = Integer.parseInt(y_);

        int result = x+y;

        resp.getWriter().printf("result is %d\n", result);

        /*내가 만든 덧셈계산기*/

        /* resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        int num1 = Integer.parseInt(req.getParameter("x"));
        int num2 = Integer.parseInt(req.getParameter("y"));

        int sum = num1 + num2;

        out.println("계산 결과 : " + sum);*/
    }
}
