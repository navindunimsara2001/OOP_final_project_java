<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Management</title>

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

    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
        <h3>Staff Management</h3>
        <table
                class="table table-striped table-hover table-bordered table-responsive">
            <thead class="text-center">
            <tr class="table-info">
                <th>ID</th>
                <th>Name</th>
                <th>E-mail</th>
                <th>Phone No</th>
                <th>DOB</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody class="table-hover text-center">
            <c:forEach items="${stfList}" var="Staff">
                <tr>
                    <td>${Staff.ID}</td>
                    <td>${Staff.name}</td>
                    <td>${Staff.email}</td>
                    <td>${Staff.phone}</td>
                    <td>${Staff.DOB}</td>
                    <td>${Staff.role == 1 ? 'Manager' : 'Staff'}</td>
                    <td class="text-center">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Edit
                            User
                        </button>
                        <button class="btn btn-danger delete-btn">Delete</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>

    <!-- Modal -->
    <div class="modal" id="myModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Request Item</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <section class="container" id="container">
                        <form action=" " method="post" class="form">
                            <div class="input-box">
                                <label>Item name : </label>
                                <input type="text" name="itemName" required>
                            </div>
                            <div class="input-box">
                                <label>Amount : </label>
                                <input type="number" placeholder="" name="amount">
                            </div>
                            <input type="hidden" name="itemID" value="">
                            <button type="submit">Submit</button>
                        </form>
                    </section>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="../assets/js/appointment.js"></script>
</body>
</html>