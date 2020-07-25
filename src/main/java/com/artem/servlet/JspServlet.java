package com.artem.servlet;

import com.artem.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = {"/webServlet"})
public class JspServlet extends SimpleAbstractServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        List<User> userList = Arrays.asList(
                new User("Artem", "Russia", 19),
                new User("Igor", "USA", 11),
                new User("EGOR", "Ukraine", 22)
        );
        request.setAttribute("users", userList);
        getServletContext().getRequestDispatcher("/firstJsp.jsp").forward(request, response);
    }
}
