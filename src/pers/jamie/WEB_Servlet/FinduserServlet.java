package pers.jamie.WEB_Servlet;

import pers.jamie.domain.User;
import pers.jamie.service.Userservice;
import pers.jamie.service.impl.Userviceimlp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/finduserServlet")
public class FinduserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Userservice userservice = new Userviceimlp();
        User finduser = userservice.finduser(id);
        request.setAttribute("finduser",finduser);
        request.getRequestDispatcher("modifyuser.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
