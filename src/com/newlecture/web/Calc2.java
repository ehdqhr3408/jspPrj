package com.newlecture.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext application = req.getServletContext();
        HttpSession session = req.getSession();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String v_ = req.getParameter("v");
        String op = req.getParameter("operater");

        int v = 0;

        if (!v_.equals("")) v = Integer.parseInt(v_);

        if (op.equals("=")) {
            // 계산

            //int x = (Integer)application.getAttribute("value");
            int x = (Integer)session.getAttribute("value");
            int y = v;
            //String operater = (String)application.getAttribute("op");
            String operater = (String)session.getAttribute("op");

            int result = 0;

            if (operater.equals("+"))
                result = x + y;
            else
                result = x - y;

            resp.getWriter().printf("result is %d\n", result);

        } else {
            // application 저장소에 저장
            //application.setAttribute("value", v);
            //application.setAttribute("op", op);
            session.setAttribute("value", v);
            session.setAttribute("op", op);

        }
    }


}
