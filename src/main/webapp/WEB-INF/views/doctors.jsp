<%--
  Created by IntelliJ IDEA.
  User: soumalya
  Date: 24/06/22
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<%@include file="commons/head.jspf" %>
<%@include file="commons/navbar.jspf" %>
<main>
    <div class="container">
        <div class="row p-5 mt-4 mb-4 bg-light rounded-3" id="jumbotron2">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold text-primary">CLINIC ++</h1>
                <p class="col-md-12 fs-4 text-white">
                    <spring:message code="doctors.description"/>
                </p>
                <button class="btn btn-primary btn-lg" data-bs-toggle="modal" data-bs-target="#newDoctorModal">
                    <spring:message code="doctors.addNew"/>
                    <i class="bi bi-plus-lg"></i>
                </button>
            </div>
        </div>
        <!--Modal Start-->
        <div class="modal fade" id="newDoctorModal" tabindex="-1" aria-labelledby="newDoctorModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="newDoctorModalLabel">
                            <spring:message code="doctors.addNew"/>
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form:form method="post" action="${pageContext.request.contextPath}/doctors/new"
                               modelAttribute="newDoctor">
                        <div class="modal-body">
                            <fieldset class="form-group mb-3">
                                <form:label class="form-label" for="name" path="name">
                                    <spring:message code="doctors.modal.name" />
                                </form:label>
                                <form:input class="form-control" id="name" type="text" name="name" path="name"
                                            required="required"/>
                                <form:errors cssClass="text-warning" path="name"/>
                            </fieldset>
                            <fieldset class="form-group mb-3">
                                <form:label class="form-label" for="email" path="email">
                                    <spring:message code="doctors.modal.email" />
                                </form:label>
                                <form:input class="form-control" id="email" type="email" name="email" path="email"
                                            required="required"/>
                                <form:errors cssClass="text-warning" path="email"/>
                            </fieldset>
                            <fieldset class="form-group mb-3">
                                <form:label class="form-label" for="degree" path="degree">
                                    <spring:message code="doctors.modal.degree" />
                                </form:label>
                                <form:input class="form-control" id="degree" type="text" name="degree" path="degree"
                                            required="required"/>
                                <form:errors cssClass="text-warning" path="degree"/>
                            </fieldset>
                            <fieldset class="form-group mb-3">
                                <form:label class="form-label" for="specz"
                                            path="specialization">
                                    <spring:message code="doctors.modal.specz" />
                                </form:label>
                                <form:input class="form-control" id="specz" type="text" name="specialization"
                                            path="specialization" required="required"/>
                                <form:errors cssClass="text-warning" path="specialization"/>
                            </fieldset>

                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                                <spring:message code="doctors.modal.close" />
                            </button>
                            <button type="submit" class="btn btn-primary" id="triggerToast">
                                <spring:message code="doctors.modal.add" />
                            </button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <!--Modal End -->
        <div class="row">
            <div class="col-12">
                <form class="input-group input-group-lg" method="post"
                      action="${pageContext.request.contextPath}/doctors/search" id="search_from">
                    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false" style="border-top-left-radius:15px; border-bottom-left-radius: 15px;"
                            id="search_cat">
                        <spring:message code="doctors.search.filterBy" />
                    </button>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="dropdown-item" id="id" aria-selected="true">
                                <spring:message code="doctors.search.filter_ID"/>
                            </div>
                        </li>
                        <li>
                            <div class="dropdown-item" id="doc_name">
                                <spring:message code="doctors.search.filter_Name"/>
                            </div>
                        </li>
                        <li>
                            <div class="dropdown-item" id="spec">
                                <spring:message code="doctors.search.filter_Specz" />
                            </div>
                        </li>
                    </ul>
                    <input type="text" class="form-control" aria-label="Sizing example input"
                           aria-describedby="inputGroup-sizing-lg" placeholder="search doctor" name="query">
                    <button class="btn btn-primary" type="submit"
                            style="border-top-right-radius: 15px; border-bottom-right-radius: 15px;">
                        <i class="bi bi-search"></i>
                    </button>
                </form>
            </div>
        </div>
        <div class="row-cols-12 text-center">
            <h1 class="text-primary">
                <spring:message code="doctors.title" />
            </h1>
        </div>
        <div class="row">
            <jstl:forEach items="${doctors}" var="doctor">
                <div class="col-12 col-md-4 pb-3">
                    <div class="card bg-dark text-white rounded-3" style="max-height: 25rem; overflow-y: auto">
                        <div class="card-body">
                            <h5 class="card-title">Dr. ${doctor.name}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${doctor.specialization}</h6>
                            <div class="container card-text">
                                <div class="row">
                                    <div class="col-6 fw-bold">
                                        <spring:message code="doctors.details.id" />
                                    </div>
                                    <div class="col-6">${doctor.d_id}</div>
                                </div>
                                <hr/>
                                <div class="row">
                                    <div class="col-6 fw-bold">
                                        <spring:message code="doctor.details.degree"/>
                                    </div>
                                    <div class="col-6">${doctor.degree}</div>
                                </div>
                                <hr/>
                                <div class="row">
                                    <div class="col-6 fw-bold">
                                        <spring:message code="doctor.details.specz" />
                                    </div>
                                    <div class="col-6">${doctor.specialization}</div>
                                </div>
                                <hr/>
                                <div class="row">
                                    <div class="col-6 fw-bold">
                                        <spring:message code="doctor.details.email"/>
                                    </div>
                                    <div class="col-6">${doctor.email}</div>
                                </div>
                            </div>
                            <a href="${pageContext.request.contextPath}/doctors/edit/${doctor.d_id}"
                               class="btn btn-primary">
                                Edit <i class="bi bi-pencil"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </jstl:forEach>
        </div>
    </div>
    <div class="toast-container position-fixed bottom-0 end-0 p-3">
        <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <img src="${pageContext.request.contextPath}/health-clinic.png" class="rounded me-2"
                     alt="Doctor Added to Database">
                <strong class="me-auto">${toast_message_title}</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                ${toast_message_body}
            </div>
        </div>
    </div>
</main>
<script src="${pageContext.request.contextPath}/doctor_Search.js"></script>
<%@include file="commons/foorter.jspf" %>
</html>
