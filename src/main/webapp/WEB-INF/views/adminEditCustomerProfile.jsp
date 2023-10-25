<%@ page import="java.util.Objects" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <link rel="stylesheet" href="assets/styles/userProfileView.css">
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

        <div class="profile-container">
            <h2 class="profile-header">User Profile</h2>
            <div class="profile-pic">
                <ion-icon name="person-circle-outline" style="font-size: 128px"></ion-icon>
            </div>

            <div class="row">
                <div class="col d-flex justify-content-center" id="col">
                    <form action="${requestScope.get("url")}" method="post">
                        <table>
                            <tr class="field">
                                <td>
                                    <label class="label" for="Name">Name : </label>
                                </td>
                                <td>
                                    <input type="text" name="name" id="name"
                                           value="<%=request.getAttribute("name")%>"
                                    >
                                </td>
                            </tr>
                            <tr class="field">
                                <td>
                                    <label class="label" for="phone">Phone : </label>
                                </td>
                                <td>
                                    <input type="text" name="phone" id="phone"
                                           value="<%=request.getAttribute("phone")%>"
                                    >
                                </td>
                            </tr>
                            <tr class="field">

                                <td>
                                    <label class="label" for="DOB">DOB : </label>
                                </td>
                                <td>
                                    <input type="date" name="DOB" id="DOB"
                                           value="<%=request.getAttribute("DOB")%>"
                                    >
                                </td>

                            </tr>
                            <% if (!Objects.isNull(request.getAttribute("district"))) {%>
                            <tr class="field">
                                <td>
                                    <label class="label" for="district"> District : </label>
                                </td>
                                <td>
                                    <input type="text" name="district" id="district"
                                           value="<%=request.getAttribute("district")%>"
                                    >
                                </td>
                            </tr>
                            <%}%>
                        </table>
                        <input type="hidden" name="ID" value="<%=request.getAttribute("ID")%>">
                        <div>
                            <input class="btn btn-primary" type="submit" value="Update">
                            <a class="btn btn-danger"
                               href="staff/deleteUser?ID=<%=request.getAttribute("ID")%>">Delete</a>
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