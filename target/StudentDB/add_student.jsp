<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
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
                    <h3 class="fs-3">Add Student</h3>

                    <c:if test="${not empty succMsg}">
                        <p class="text-center text-success">${succMsg}</p>
                        <c:remove var="succMsg" />
                    </c:if>

                    <c:if test="${not empty errMsg}">
                        <p class="text-center text-danger">${errorMsg}</p>
                        <c:remove var="errorMsg" />
                    </c:if>



                    <form action="register" method="post">

                        <!-- First Name -->
                        <div class="mb-3">
                            <label class="form-label">First Name</label>
                            <input type="text" name="firstName" class="form-control">

                        </div>

                        <!-- Last Name -->
                        <div class="mb-3">
                            <label class="form-label">Last Name</label>
                            <input type="text" name="lastName" class="form-control">

                        </div>

                        <!-- Email -->
                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" name="email" class="form-control">
                        </div>


                        <button type="submit" class="btn btn-primary col-md-12"
                                style="background: #FFA316; border-color: #FFA316;">Submit</button>
                    </form>
                </div>
            </div>
        </div>

    </div>



</div>



</html>