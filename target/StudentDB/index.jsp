<%@ page import="java.sql.Connection" %>
<%@ page import="com.conn.DBConnect" %>
<%@ page import="com.dao.StudentDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Student" %>
<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="iso-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="iso-8859-1">
    <title>Student DB</title>
    <%@include file="all_css.jsp"%>
</head>

<body class="bg-light">

<%@include file="navbar.jsp"%>



<div class="container p-3">
    <div class="card">
        <div class="card-body">

            <div class="text-center fs-1 font-weight-bolder">All Student Database</div>
            <br>

            <c:if test="${not empty succMsg}">
                <p class="text-center text-success">${succMsg}</p>
                <c:remove var="succMsg" />
            </c:if>

            <c:if test="${not empty errMsg}">
                <p class="text-center text-danger">${errorMsg}</p>
                <c:remove var="errorMsg" />
            </c:if>

            <table class="table table-sm">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>


                <%
                    StudentDAO dao = new StudentDAO(DBConnect.getConn());
                    List<Student> list = dao.getAllStudent();
                    for(Student s:list){
                %>


                <tr>
                    <th scope="row"><%=s.getId() %></th>
                    <td><%=s.getFirstName()%></td>
                    <td><%=s.getLastName() %></td>
                    <td><%=s.getEmail() %></td>
                    <td>
                        <a href="edit_student.jsp?id=<%=s.getId()%>"
                           class="btn btn-sm btn-success" >Update</a>
                        <a href="delete?id=<%=s.getId()%>" class="btn btn-sm btn btn-outline-danger">Delete</a>
                    </td>
                </tr>




                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>