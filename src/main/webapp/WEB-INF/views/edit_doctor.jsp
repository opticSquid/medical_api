
<%--
  Created by IntelliJ IDEA.
  User: soumalya
  Date: 26/06/22
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%@include file="commons/head.jspf" %>
<%@include file="commons/navbar.jspf" %>
<main>
    <div class="container">
        <div class="row-cols-12">
            <div class="fs-5 fw-bold text-primary text-center">EDIT DETAILS</div>
        </div>
        <form:form method="post" action="/doctors/edit/${doctor_edit.d_id}/save" modelAttribute="doctor_edit">
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
                    <form:label class="form-label" for="degree" path="degree">Degree</form:label>
                    <form:input class="form-control" id="degree" type="text" name="degree" path="degree"
                                required="required"/>
                    <form:errors cssClass="text-warning" path="degree"/>
                </fieldset>
                <fieldset class="form-group mb-3">
                    <form:label class="form-label" for="specz"
                                path="specialization">Specialization</form:label>
                    <form:input class="form-control" id="specz" type="text" name="specialization"
                                path="specialization" required="required"/>
                    <form:errors cssClass="text-warning" path="specialization"/>
                </fieldset>

            </div>
            <div class="modal-footer">
                <button type="reset" class="btn btn-outline-secondary" data-bs-dismiss="modal">Close
                </button>
                <button type="submit" class="btn btn-primary" id="triggerToast">Add</button>
            </div>
        </form:form>
    </div>
</main>
<%@include file="commons/foorter.jspf" %>
</html>
