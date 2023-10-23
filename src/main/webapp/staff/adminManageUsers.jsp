<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    
    <!--thumbnail icon-->
    <link rel="icon" href="../assets/images/thumbnail.ico" type="image/png">
    <!---->

    <link rel="stylesheet" href="../assets/styles/main.css">
    <link rel="stylesheet" href="../assets/styles/dashboard.css">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous">
</head>

<body>
<nav class="menu mini-menu fixed floating">
    <img class="logo" src="../assets/images/winfuel%20connect.png" alt="Logo"
         height="32px"></img>
</nav>
<div class="sidebar-container">
    <aside class="sidebar">
        <div class="sidebar-up">
            <div class="sidebar-option">
                <img src="../assets/images/Icons/user-search-svgrepo-com.svg"
                     width="40px">
                <div class="sidebar-option-text">Users</div>
            </div>
            <div class="sidebar-option">
                <img src="../assets/images/Icons/user-shield-svgrepo-com.svg"
                     width="40px">
                <div class="sidebar-option-text">Managers</div>
            </div>
            <div class="sidebar-option">
                <img src="../assets/images/Icons/users-svgrepo-com.svg" width="40px">
                <div class="sidebar-option-text">Staff</div>
            </div>
            <div class="sidebar-option">
                <img src="../assets/images/Icons/square-list-svgrepo-com.svg"
                     width="40px">
                <div class="sidebar-option-text">Appointments</div>
            </div>
            <div class="sidebar-option">
                <img src="../assets/images/Icons/cube-alt-2-svgrepo-com.svg"
                     width="40px">
                <div class="sidebar-option-text">Items</div>
            </div>
        </div>
        <hr>
        <div class="sidebar-down">
            <div class="sidebar-option">
                <img src="../assets/images/Icons/user-plus-svgrepo-com.svg"
                     width="40px">
                <div class="sidebar-option-text">Create Manager</div>
            </div>
            <div class="sidebar-option">
                <img src="../assets/images/Icons/user-plus-svgrepo-com.svg"
                     width="40px">
                <div class="sidebar-option-text">Create Staff Member</div>
            </div>
        </div>
    </aside>

    <main>
        <h3>User Management</h3>
        <table
                class="table table-striped table-hover table-bordered table-responsive">
            <thead class="text-center">
            <tr class="table-info">
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>District</th>
            </tr>
            </thead>
            <tbody class="table-hover text-center">
            <c:forEach items="${customerList}" var="Customer">
                <tr>
                    <td>${Customer.ID}</td>
                    <td>${Customer.name}</td>
                    <td>${Customer.email}</td>
                    <td>${Customer.phone}</td>
                    <td>${Customer.DOB}</td>
                    <td>${Customer.gender}</td>
                    <td>${Customer.district}</td>
                    <td class="text-center">
                        <button class="btn btn-primary">
                            <a class="text-decoration-none text-white" href="./adminEditUser?ID=${Customer.ID}">Edit</a>
                        </button>
                        <button class="btn btn-danger">
                            <a class="text-decoration-none text-white"
                               href="./adminDeleteUser?ID=${Customer.ID}">Delete</a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</div>

</body>

</html>