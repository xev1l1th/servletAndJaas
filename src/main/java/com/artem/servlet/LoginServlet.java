package com.artem.servlet;

import com.artem.Main;
import com.artem.authentication.Authentication;
import com.artem.authentication.SimpleCallbackHandler;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    private LoginContext context = null;

    {
        try {
            System.setProperty("java.security.auth.login.config", "jaasConfig.config");
            context = new LoginContext("SimpleJaasConfig", new SimpleCallbackHandler());
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Authentication.createInstance(username, password);
        try {
            context.login();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        req.setAttribute("auth", Authentication.getInstance());
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);

    }
}
