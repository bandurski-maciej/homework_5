package com.isa.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Enumeration;

@WebServlet("/infoShareAcademy")
public class InfoShareAcademyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = resp.getWriter();
    writer.println("<!DOCTYPE html><html><body>");
    writer.println("<p> Jan Kowalski</p>");
    writer.println("<p> jjdd8-zespół</p>");
    writer.println("<p>" + LocalDateTime.now() + "</p>");
    writer.println("</body></html>");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Enumeration<String> parameterNames = req.getParameterNames();

    PrintWriter writer = resp.getWriter();
    resp.setContentType("text/html;charset=UTF-8");
    writer.println("<!DOCTYPE html><html><body>");
    writer.println("<ul>");

    while (parameterNames.hasMoreElements()) {

      String paramName = parameterNames.nextElement();

      writer.println("<li>" + paramName + ":");

      String[] paramValues = req.getParameterValues(paramName);
      for (int i = 0; i < paramValues.length; i++) {
        String paramValue = paramValues[i];

        if (paramValues.length <= 1) {writer.println(paramValue);}
        else if (i == 0) {
          writer.println("<ul>");
        } else if (i == paramValues.length - 1) { writer.println("<li>" + paramValue + "</li></ul>");}
        else {writer.println("<li>" + paramValue + "</li>");}
      }
    }
    writer.println("</li></ul>");
    writer.println("</body></html>");
    writer.close();
  }
}
