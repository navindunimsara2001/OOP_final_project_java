<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <link rel="stylesheet" href="../assets/styles/userProfileView.css">
    <title>User Profile</title>
    <style>
        body {
            background-image: none !important;
        }
    </style>
</head>

<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
    <main>

        <div class="container">
            <h2>User Profile</h2>
            <div class="propic">
                <img src="../assets/images/Icons/user.svg" alt="">
            </div>

            <div class="row">
                <div class="col-3"></div>
                <div class="col d-flex justify-content-center" id="col">
                    <form action="./editUser" method="post">
                        <table>
                            <tr>
                                <th>
                                    <div class="field">
                                        <label class="label" for="ID">ID : </label>
                                    </div>
                                </th>
                                <th>
                                    <div class="field">
                                        <input type="text" name=""
                                               value="<%=request.getAttribute("ID")%>" disabled>
                                    </div>
                                </th>
                            </tr>
                            <tr>
                            <tr>
                                <th>
                                    <div class="field">
                                        <label class="label" for="Name">Name : </label>
                                    </div>
                                </th>
                                <th>
                                    <div class="field">
                                        <input type="text" name="name"
                                               value="<%=request.getAttribute("name")%>">
                                    </div>
                                </th>
                            </tr>
                            <tr>
                                <th>
                                    <div class="field">
                                        <label class="label" for="Phone Number">Phone : </label>
                                    </div>
                                </th>
                                <th>
                                    <div class="field">
                                        <input type="text" name="phone"
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
                        </table>
                        <input type="hidden" name="ID" value="<%=request.getAttribute("ID")%>">
                        <div>
                            <input class="btn btn-primary" type="submit" value="Update">
                            <a class="btn btn-danger"
                               href="./deleteUser?ID=<%=request.getAttribute("ID")%>">Delete</a>
                        </div>
                    </form>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
    </main>
</div>
</body>

</html>