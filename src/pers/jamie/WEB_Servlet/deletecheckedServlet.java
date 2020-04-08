package pers.jamie.WEB_Servlet;

import pers.jamie.service.Userservice;
import pers.jamie.service.impl.Userviceimlp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletecheckedServlet")
public class deletecheckedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Userservice userservice = new Userviceimlp();
        String[] uids = request.getParameterValues("ucb");
        for (String uid : uids) {
            userservice.deleteuser(uid);
        }
        response.sendRedirect(request.getContextPath()+"/userlistServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
