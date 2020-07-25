package com.artem.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/send"})
@MultipartConfig(location = "C:\\TestServletApp\\downloads")
public class FileServlet extends SimpleAbstractServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(Part part:req.getParts()){
            if(part.getName().equals("author")){
                String author = new BufferedReader(new InputStreamReader(part.getInputStream()))
                        .lines()
                        .collect(Collectors.joining("\n"));
                log(author);
            } else {
                part.write(UUID.randomUUID().toString() + part.getSubmittedFileName());
            }
        }
        resp.sendRedirect("/myApp/greeting");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
