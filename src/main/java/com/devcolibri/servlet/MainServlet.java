package com.devcolibri.servlet;


import java.io.*;

import javax.servlet.http.*;
import javax.servlet.*;

public class MainServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();

        out.println("Hello, world!");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
