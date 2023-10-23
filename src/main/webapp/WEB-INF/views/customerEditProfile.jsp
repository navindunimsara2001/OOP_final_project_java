<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/includes/header.jsp"/>
    <link rel="stylesheet" href="assets/styles/userProfileView.css">
    <title>User Profile</title>
</head>

<body>
<jsp:include page="/includes/site_menu.jsp"/>
<main>
    <div class="container">
        <h2>User Profile</h2>
        <div class="propic">
            <img src="assets/images/Icons/user.svg" alt="">
        </div>

        <div class="row">
            <div class="col-3"></div>
            <div class="col d-flex justify-content-center" id="col">
                <form action="" method="post">
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
                                           value="<%=request.getAttribute("name")%>">
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
                                           value="<%=request.getAttribute("phone")%>">
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
                                           value="<%=request.getAttribute("DOB")%>">
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
                                           value="<%=request.getAttribute("district")%>">
                                </div>
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <div class="field">
                                    <label class="label" for="password"> Password : </label>
                                </div>
                            </th>
                            <th>
                                <div class="field">
                                    <input type="password" name="password" id="password"
                                           value="<%=request.getAttribute("password")%>">
                                </div>
                            </th>
                        </tr>
                    </table>
                    <input type="hidden" name="ID" value="<%=request.getAttribute("ID")%>">
                    <input class="btn btn-primary" type="submit" value="Update">
                    <a class="btn btn-danger"
                       href="./userProfileDelete?ID=<%=request.getAttribute("ID")%>">Delete</a>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</main>
<jsp:include page="/includes/footer.jsp"/>
</body>

</html>