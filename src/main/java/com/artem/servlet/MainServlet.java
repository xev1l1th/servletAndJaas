package com.artem.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/greeting", "/helloWorld", "/user/*"})
public class MainServlet extends SimpleAbstractServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String params = formatParams(req.getParameterMap());
        String uri = req.getRequestURI();
        resp.getWriter().write("method doGet =)\n" + "Uri: " +uri + "\nParams: \n" + params);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String params = formatParams(req.getParameterMap());
        resp.getWriter().write("method doPost =)\n" + "Uri: " +uri + "\nParams: \n" + params);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private String formatParams(Map<String, String[]> map){
        return map
                .entrySet()
                .stream()
                .map(entry->{
                    String param = String.join(" and ", entry.getValue());
                    return entry.getKey() + " => " + param+"; ";
                }).collect(Collectors.joining("\n"));
    }
}
