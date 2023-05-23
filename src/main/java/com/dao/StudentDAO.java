package com.dao;

import com.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private Connection conn;

    public StudentDAO(Connection conn){
        super();
        this.conn = conn;
    }


    public boolean addStudent(Student student) {
        boolean f = false;
        try {

            String sql = "insert into student(firstName, lastName, email) values(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());


            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }


    public List<Student> getAllStudent(){
        List<Student> list = new ArrayList<Student>();
        Student s = null;
        try{
            String sql = "select * from student";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                s = new Student();
                s.setId(rs.getString(1));
                s.setFirstName(rs.getString(2));
                s.setLastName(rs.getString(3));
                s.setEmail(rs.getString(4));
                list.add(s);
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public Student getStudentById(String id){
        Student s = null;
        try{
            String sql = "select * from student where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                s = new Student();
                s.setId(rs.getString(1));
                s.setFirstName(rs.getString(2));
                s.setLastName(rs.getString(3));
                s.setEmail(rs.getString(4));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return s;
    }

    public boolean updateStudent(Student student) {
        boolean f = false;
        try {

            String sql = "update student set firstName=?, lastName=?, email=? where id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getId());


            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean deleteStudent(String id){

        boolean f = false;

        try{
            String sql = "delete from student where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            int i = ps.executeUpdate();
            if (i==1){
                f = true;
            }

        }

        catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}


