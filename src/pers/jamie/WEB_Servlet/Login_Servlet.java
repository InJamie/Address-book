package pers.jamie.WEB_Servlet;

import org.junit.Test;
import pers.jamie.dao.Userdao;
import pers.jamie.dao.impl.Userdaoimpl;
import pers.jamie.domain.User;
import pers.jamie.service.Userservice;
import pers.jamie.service.impl.Userviceimlp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/loginServlet")
public class Login_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object checkcode_server = session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        String checkcode = request.getParameter("checkcode");
        if (!checkcode.equalsIgnoreCase((String) checkcode_server)){
            request.setAttribute("img","验证码有误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        String user = request.getParameter("user");
        String password = request.getParameter("password");
//        封装对象
        User use = new User();
        use.setUsername(user);
        use.setPassword(password);
        Userservice userservice = new Userviceimlp();
        User login = userservice.login(use);
        if (login!=null){
           request.getRequestDispatcher("userlistServlet").forward(request,response);
        }else {
            request.setAttribute("img","账号或密码有误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    @Test
    public void maasdin(){
        Userdao dao = new Userdaoimpl();
        User jamie = dao.cheklogin("jamie", "7902");
        System.out.println(jamie);
    }
}
