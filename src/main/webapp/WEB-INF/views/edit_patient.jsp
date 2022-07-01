<%--
  Created by IntelliJ IDEA.
  User: souma
  Date: 01-07-2022
  Time: 08:44 PM
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
        <form:form method="post" action="/patients/edit/${patient_edit.p_id}/save" modelAttribute="patient_edit">
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
                                path="contact_no" required="required"/>
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
</main>
<%@include file="commons/foorter.jspf" %>
</html>

