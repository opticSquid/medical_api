<%--
  Created by IntelliJ IDEA.
  User: soumalya
  Date: 24/06/22
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<html>
<%@include file="commons/head.jspf" %>
<%@include file="commons/navbar.jspf" %>
<main>
    <div class="container">
        <div class="row p-5 mt-4 mb-4 bg-light rounded-3" id="jumbotron2">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold text-primary">CLINIC ++</h1>
                <p class="col-md-12 fs-4 text-white">
                    These are the list of doctors you have in your clinic. You can
                    also add a new doctor from here or edit details of an existing doctor
                </p>
                <a role="button" class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/doctors/new"
                   style="text-decoration: none;"> New
                    Doctor
                    <i class="bi bi-plus-lg"></i>
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <form class="input-group input-group-lg" method="post"
                      action="${pageContext.request.contextPath}/search">
                    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">Search By
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">ID</a></li>
                        <li><a class="dropdown-item" href="#">Name</a></li>
                        <li><a class="dropdown-item" href="#">Specialization</a></li>
                    </ul>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-lg" placeholder="search doctor">
                    <button class="btn btn-outline-primary" type="submit">
                        <i class="bi bi-search"></i>
                    </button>
                </form>
            </div>
        </div>
        <div class="row-cols-12 text-center">
            <h1 class="text-primary">DOCTORS</h1>
        </div>
        <div class="row">
            <jstl:forEach items="${doctors}" var="doctor">
            <div class="col-12 col-md-4">
                <div class="card bg-dark text-white rounded-3">
                    <div class="card-body">
                        <h5 class="card-title">Dr. ${doctor.name}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">${doctor.specialization}</h6>
                        <div class="container card-text">
                            <div class="row">
                                <div class="col-6 fw-bold">ID</div>
                                <div class="col-6">${doctor.d_id}</div>
                            </div>
                            <hr/>
                            <div class="row">
                                <div class="col-6 fw-bold">Degree</div>
                                <div class="col-6">${doctor.degree}</div>
                            </div>
                            <hr/>
                            <div class="row">
                                <div class="col-6 fw-bold">Email</div>
                                <div class="col-6">${doctor.email}</div>
                            </div>
                        </div>
                        <a href="${pageContext.request.contextPath}/doctors/${doctor.d_id}/edit"
                           class="btn btn-primary" role="button">
                            Edit <i class="bi bi-pencil"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        </jstl:forEach>
    </div>
    </div>
</main>
<%@include file="commons/foorter.jspf" %>
</html>
