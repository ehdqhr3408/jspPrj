package com.newlecture.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.invoke.ConstantCallSite;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext application = req.getServletContext();
        HttpSession session = req.getSession();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Cookie[] cookies = req.getCookies();

        String v_ = req.getParameter("v");
        String op = req.getParameter("operater");

        int v = 0;

        if (!v_.equals("")) v = Integer.parseInt(v_);

        if (op.equals("=")) {
            // 계산

            //int x = (Integer)application.getAttribute("value");
            //int x = (Integer)session.getAttribute("value");
            int x = 0;
            for(Cookie c : cookies){
                if(c.getName().equals("value")){
                    x = Integer.parseInt(c.getValue());
                    break;
                }
            }

            int y = v;
            //String operater = (String)application.getAttribute("op");
            //String operater = (String)session.getAttribute("op");
            String operator ="";
            for(Cookie c : cookies){
                if(c.getName().equals("op")){
                    operator = c.getValue();
                    break;
                }
            }
            int result = 0;

            if (operator.equals("+"))
                result = x + y;
            else
                result = x - y;

            resp.getWriter().printf("result is %d\n", result);

        } else {
            // application 저장소에 저장
            //application.setAttribute("value", v);
            //application.setAttribute("op", op);

            //session애 저장
            //session.setAttribute("value", v);
            //session.setAttribute("op", op);

            Cookie valueCookie = new Cookie("value", String.valueOf(v));
            valueCookie.setPath("calc2");
            valueCookie.setMaxAge(24*60*60);

            Cookie opCookie = new Cookie("op", op);
            opCookie.setPath("/calc2");
            valueCookie.setMaxAge(24*60*60);

            resp.addCookie(valueCookie);
            resp.addCookie(opCookie);

            resp.sendRedirect("calc2.html");
        }
    }


}
