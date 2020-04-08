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
import java.util.List;

@WebServlet("/userlistServlet")
public class UserlistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Userservice userservice = new Userviceimlp();
        List<User> users = userservice.userList();
        request.setAttribute("userlist",users);
        request.getRequestDispatcher("list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
            }
}
