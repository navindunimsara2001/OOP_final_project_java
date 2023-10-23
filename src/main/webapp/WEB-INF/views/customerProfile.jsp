<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/includes/header.jsp"/>
    <title>User Profile</title>
    <link rel="stylesheet" href="assets/styles/userProfileView.css">

</head>

<body>
<jsp:include page="/includes/site_menu.jsp"/>
<main>
    <div class="container">
        <h2>User Profile</h2>
        <div class="propic">
            <img src="../../assets/images/Icons/user.svg" alt="">
        </div>

        <div class="row">
            <div class="col-3"></div>
            <div class="col d-flex justify-content-center" id="col">
                <form action="">
                    <table>
                        <tr>
                            <th>
                                <div class="field">
                                    <label class="label" for="Name">Name : </label>
                                </div>
                            </th>
                            <th>
                                <div class="field">
                                    <input type="text" name="name" id="Name"
                                           value="<%=request.getAttribute("name")%>" disabled>
                                </div>
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <div class="field">
                                    <label class="label" for="Email">Email : </label>
                                </div>
                            </th>
                            <th>
                                <div class="field">
                                    <input type="email" name="email" id="Email"
                                           value="<%=request.getAttribute("email")%>" disabled>
                                </div>
                            </th>

                        </tr>
                        <tr>
                            <th>
                                <div class="field">
                                    <label class="label" for="PhoneNumber">Phone : </label>
                                </div>
                            </th>
                            <th>
                                <div class="field">
                                    <input type="text" name="phone" id="PhoneNumber"
                                           value="<%=request.getAttribute("phone")%>" disabled>
                                </div>
                            </th>
                        </tr>
                        <tr>

                            <th>
                                <div class="field">
                                    <label class="label" for="DOB">DOB : </label>
                                </div>
                            </th>


                            <th>
                                <div class="field">
                                    <input type="date" name="DOB" id="DOB"
                                           value="<%=request.getAttribute("DOB")%>" disabled>
                                </div>
                            </th>

                        </tr>
                        <tr>
                            <th>
                                <div class="field">
                                    <label class="label" for="district"> District : </label>
                                </div>
                            </th>
                            <th>
                                <div class="field">
                                    <input type="text" name="district" id="district"
                                           value="<%=request.getAttribute("district")%>" disabled>
                                </div>
                            </th>
                        </tr>
                    </table>
                    <div class="btn-group" role="group">
                        <a class="btn btn-primary" href="?edit=true">Edit</a>
                    </div>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</main>
<jsp:include page="/includes/footer.jsp"/>

</body>

</html>