<%--
  Created by IntelliJ IDEA.
  User: soumalya
  Date: 23/06/22
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<%@include file="commons/head.jspf" %>
<%@include file="commons/navbar.jspf" %>

<main>
    <div class="container">
        <div class="row p-5 mt-4 mb-4 bg-light rounded-3" id="jumbotron">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold text-primary">CLINIC ++</h1>
                <p class="col-md-12 fs-4 text-white">
                    <spring:message code="home.description"/>
                </p>
                <a role="button" class="btn btn-primary btn-lg" href="/doctors" style="text-decoration: none;">
                    <spring:message code="home.get-started"/>
                    <i class="bi bi-arrow-right"></i>
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-12 text-center fs-4">
                <spring:message code="home.declaration"/>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Request header</th>
                        <th scope="col">Response Type</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="table-primary">
                        <td>Accept: Application/json</td>
                        <td>JSON</td>
                    </tr>
                    <tr>
                        <td>Accept: Application/xml</td>
                        <td>XML</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-12 fw-bolder text-primary text-center fs-5">
                <spring:message code="home.endpoints" />
            </div>
        </div>
        <div class="mt-2 accordion" id="EndpointAccordion">
            <div class="accordion-item">
                <h2 class="accordion-header" id="headingOne">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse"
                            data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        /doctors
                    </button>
                </h2>
                <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne"
                     data-bs-parent="#accordionExample">
                    <div class="accordion-body container">
                        <div class="row">
                            <div class="col-sm-6 col-12 fw-bold">Description</div>
                            <div class="col-sm-6 col-12">
                                <spring:message code="home.endpoints.Alldoctors" />
                            </div>
                        </div>
                        <hr/>
                        <div class="row">
                            <div class="col-sm-6 col-12 fw-bold"> JSON Request Body</div>
                            <div class="col-sm-6 col-12">EMPTY</div>
                        </div>
                        <hr/>
                    </div>
                </div>
            </div>
            <!--TODO:// ADD more description of requests and more end points-->
        </div>
    </div>
</main>
<%@include file="commons/foorter.jspf" %>
</html>
