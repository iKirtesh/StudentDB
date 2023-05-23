package com.servlet;

import com.conn.DBConnect;
import com.dao.StudentDAO;
import com.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        // int id = Integer.parseInt(req.getParameter("id"));
        //  int id = Integer.parseInt(String.valueOf(req.getParameter("id")));
        String id = req.getParameter("id");

        Student student = new Student(id,firstName,lastName,email);

        StudentDAO dao = new StudentDAO(DBConnect.getConn());

        HttpSession session = req.getSession();

        boolean f = dao.addStudent(student);

        if (f){
            session.setAttribute("succMsg", "Student Record added Success..!");
            resp.sendRedirect("add_student.jsp");
            // System.out.println("Student Details submit Successfully..");
        }
        else {
            session.setAttribute("errorMsg", "Something Wrong..!");
            resp.sendRedirect("add_student.jsp");
            // System.out.println("Something wrong on server");
        }
    }


}
