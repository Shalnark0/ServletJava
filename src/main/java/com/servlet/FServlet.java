package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FServlet")
public class FServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int rows = Integer.parseInt(request.getParameter("rows"));
        int cols = Integer.parseInt(request.getParameter("cols"));
        int colWidth = Integer.parseInt(request.getParameter("colWidth"));
        String title = request.getParameter("title");
        String bgColor = request.getParameter("bgColor");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>" + title + "</title></head>");
        out.println("<body style='background-color:" + bgColor + ";'>");
        out.println("<h1>" + title + "</h1>");
        out.println("<table border='1'>");

        for (int i = 0; i < rows; i++) {
            out.println("<tr>");
            for (int j = 0; j < cols; j++) {
                out.println("<td style='width:" + colWidth + "px;'>Строка " + (i + 1) + " Столбец " + (j + 1) + "</td>");
            }
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
