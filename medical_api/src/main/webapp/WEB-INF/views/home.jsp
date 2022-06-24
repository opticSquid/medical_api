<%--
  Created by IntelliJ IDEA.
  User: soumalya
  Date: 23/06/22
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<%@include file="commons/head.jspf" %>
<%@include file="commons/navbar.jspf" %>

<main>
    <div class="container">
        <div class="row p-5 mt-4 mb-4 bg-light rounded-3" id="jumbotron">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold text-primary">CLINIC ++</h1>
                <p class="col-md-12 fs-4 text-white">Makes your clinic management easy as breeze. Beside this front end
                    application, our application exposes RESTful APIs using which you can extend their functionality
                    in your own way. These APIs respond with both modern <span class="text-warning">JSON</span> and
                    legacy <span class="text-warning">XML</span> objects on the basis of the
                    value of <strong>Accept</strong> request header you provide.
                </p>
                <a role="button" class="btn btn-primary btn-lg" href="/doctors" style="text-decoration: none;">Get
                    Started
                    <i class="bi bi-arrow-right"></i>
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-12 text-center fs-4">
                All the API are exposed in the route: <a href="http://localhost:8080/api">http://(your
                local host port 8080 or your cloud service URI)/api</a> route. All the below mentioned API end points
                will
                assume your context path is <a href="http://localhost:8080">http://localhost:8080/api</a> route
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
                ENDPOINTS
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
                            <div class="col-sm-6 col-12">Returns list of all doctors present in the DB</div>
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
