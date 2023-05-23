package com.servlet;

import com.conn.DBConnect;
import com.dao.StudentDAO;
import com.google.protobuf.StringValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       // int id = Integer.parseInt(req.getParameter("id"));
       //  int id = Integer.parseInt(String.valueOf(req.getParameter("id")));
       
        String id = req.getParameter("id");
        


        StudentDAO dao = new StudentDAO(DBConnect.getConn());
        boolean f = dao.deleteStudent(id);

        HttpSession session = req.getSession();
        if (f){
            session.setAttribute("succMsg", "Student Record deleted Success..!");
            resp.sendRedirect("index.jsp");
            // System.out.println("Student Details submit Sucessfully..");
        }
        else {
            session.setAttribute("errorMsg", "Something Wrong..!");
            resp.sendRedirect("index.jsp");
            // System.out.println("Something wrong on server");
        }

    }
}