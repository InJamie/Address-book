package pers.jamie.WEB_Servlet;

import org.apache.commons.beanutils.BeanUtils;
import pers.jamie.domain.User;
import pers.jamie.service.Userservice;
import pers.jamie.service.impl.Userviceimlp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/modifyServlet")
public class ModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("name")!=null&&request.getParameter("name").length()!=0){
//        获取属性
//        解决输入中文乱码问题
            request.setCharacterEncoding("utf-8");
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            try {
//            封装信息
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
//        添加信息
            Userservice userservice = new Userviceimlp();
            userservice.updateuser(user);
//      跳转到list.jsp
            response.sendRedirect(request.getContextPath()+"/userlistServlet");
        }else {
            request.setAttribute("img","姓名不能为空!");
            request.getRequestDispatcher("modifyuser.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
