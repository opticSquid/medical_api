<%--
  Created by IntelliJ IDEA.
  User: souma
  Date: 01-07-2022
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<%@include file="commons/head.jspf" %>
<%@include file="commons/navbar.jspf" %>
<main>
    <div class="container">
        <div class="row p-5 mt-4 mb-4 bg-light rounded-3" id="jumbotron3">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold text-primary">CLINIC ++</h1>
                <p class="col-md-12 fs-4 text-white">
                    These are the list of patients you have in your clinic. You can
                    also add a new patient from here or edit details of an existing patient
                </p>
                <button class="btn btn-primary btn-lg" data-bs-toggle="modal" data-bs-target="#newPatientModal"> New
                    Patient
                    <i class="bi bi-plus-lg"></i>
                </button>
            </div>
        </div>
        <!--Modal Start-->
        <div class="modal fade" id="newPatientModal" tabindex="-1" aria-labelledby="newPatientModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="newPatientModalLabel">New Patient</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form:form method="post" action="${pageContext.request.contextPath}/patients/new"
                               modelAttribute="newPatient">
                        <div class="modal-body">
                            <fieldset class="form-group mb-3">
                                <form:label class="form-label" for="name" path="name">Name</form:label>
                                <form:input class="form-control" id="name" type="text" name="name" path="name"
                                            required="required"/>
                                <form:errors cssClass="text-warning" path="name"/>
                            </fieldset>
                            <fieldset class="form-group mb-3">
                                <form:label class="form-label" for="email" path="email">Email</form:label>
                                <form:input class="form-control" id="email" type="email" name="email" path="email"
                                            required="required"/>
                                <form:errors cssClass="text-warning" path="email"/>
                            </fieldset>
                            <fieldset class="form-group mb-3">
                                <form:label class="form-label" for="contact"
                                            path="contact_no">Contact Number</form:label>
                                <form:input class="form-control" id="contact" type="text" name="contact_no"
                                            path="contact_no"
                                            required="required"/>
                                <form:errors cssClass="text-warning" path="contact_no"/>
                            </fieldset>
                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-outline-secondary" data-bs-dismiss="modal">Close
                            </button>
                            <button type="submit" class="btn btn-primary" id="triggerToast">Add</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <!--Modal End -->
        <div class="row">
            <div class="col-12">
                <form class="input-group input-group-lg" method="post"
                      action="${pageContext.request.contextPath}/patients/search" id="search_from">
                    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false" style="border-top-left-radius:15px; border-bottom-left-radius: 15px;"
                            id="search_cat">Search By
                    </button>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="dropdown-item" id="id" aria-selected="true">ID</div>
                        </li>
                        <li>
                            <div class="dropdown-item" id="patient_name">Name</div>
                        </li>
                        <li>
                            <div class="dropdown-item" id="email">Email</div>
                        </li>
                    </ul>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-lg" placeholder="search patient" name="query">
                    <button class="btn btn-primary" type="submit"
                            style="border-top-right-radius: 15px; border-bottom-right-radius: 15px;">
                        <i class="bi bi-search"></i>
                    </button>
                </form>
            </div>
        </div>
        <div class="row-cols-12 text-center">
            <h1 class="text-primary">PATIENTS</h1>
        </div>
        <div class="row">
            <jstl:forEach items="${patients}" var="patient">
                <div class="col-12 col-md-4">
                    <div class="card bg-dark text-white rounded-3" style="max-height: 20rem; overflow-y: auto">
                        <div class="card-body">
                            <h5 class="card-title">${patient.name}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${patient.email}</h6>
                            <div class="container card-text">
                                <div class="row">
                                    <div class="col-6 fw-bold">ID</div>
                                    <div class="col-6">${patient.p_id}</div>
                                </div>
                                <hr/>
                                <div class="row">
                                    <div class="col-6 fw-bold">Contact Number</div>
                                    <div class="col-6">${patient.contact_no}</div>
                                </div>
                                <hr/>
                                <div class="row">
                                    <div class="col-6 fw-bold">Email</div>
                                    <div class="col-6">${patient.email}</div>
                                </div>
                            </div>
                            <a href="${pageContext.request.contextPath}/doctors/edit/${patient.p_id}"
                               class="btn btn-primary">
                                Edit <i class="bi bi-pencil"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </jstl:forEach>
        </div>
    </div>
    </div>
    <div class="toast-container position-fixed bottom-0 end-0 p-3">
        <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <img src="..." class="rounded me-2" alt="Patient Added to Database">
                <strong class="me-auto">${toast_message_title}</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                ${toast_message_body}
            </div>
        </div>
    </div>
</main>
<script src="${pageContext.request.contextPath}/patient_Search.js"></script>
<%@include file="commons/foorter.jspf" %>
</html>
