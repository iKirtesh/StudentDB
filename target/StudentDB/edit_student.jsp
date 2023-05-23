<%@ page import="com.dao.StudentDAO" %>
  <%@ page import="com.conn.DBConnect" %>
    <%@ page import="com.entity.Student" %>
      <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


        <!DOCTYPE html>
        <html>

        <head>
          <meta charset="UTF-8">
          <title>Edit DB</title>
          <%@include file="all_css.jsp" %>
        </head>

        <body class="bg-light">
          <!--- NavBar -->
          <%@include file="navbar.jsp" %>


            <!--- Add Student -->

            <div class="container p-4">
              <div class="row">
                <div class="col-md-6 offset-md-3">
                  <div class="card">
                    <div class="card-body">
                      <h3 class="fs-3">Edit Student</h3>

                      <%  // int id=Integer.parseInt(request.getParameter("id"));
                        // String id=String.valueOf(request.getParameter("id"));
                         String id=request.getParameter("id");
                        StudentDAO dao=new StudentDAO(DBConnect.getConn());
                        Student s=dao.getStudentById(id); %>


                        <form action="update" method="post">

                          <!-- First Name -->
                          <div class="mb-3">
                            <label class="form-label">First Name</label>
                            <input type="text" value="<%=s.getFirstName() %>" name="firstName" class="form-control">

                          </div>

                          <!-- Last Name -->
                          <div class="mb-3">
                            <label class="form-label">Last Name</label>
                            <input type="text" value="<%=s.getLastName() %>" name="lastName" class="form-control">

                          </div>

                          <!-- Email -->
                          <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" value="<%=s.getEmail()%>" name="email" class="form-control">
                          </div>

                          <input type="hidden" name="id" value="<%=s.getId()%>">
                          <button type="submit" class="btn btn-primary col-md-12"
                            style="background: #FFA316; border-color: #FFA316;">Update</button>
                        </form>
                    </div>
                  </div>
                </div>

              </div>



            </div>



        </html>