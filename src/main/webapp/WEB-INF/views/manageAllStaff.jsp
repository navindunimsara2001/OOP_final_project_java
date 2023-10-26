<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <title>Manage Staff - WinFuel Dashboard</title>
    <link rel="stylesheet" href="assets/styles/form.css">
</head>
<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
    <main>
        <h3>Staff Management</h3>
        <button class="btn btn-primary" id="addStaff">+ Add Staff</button>
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
                    <td>${Staff.role}</td>
                    <td class="text-center">
                        <button type="button" class="btn btn-primary staff-edit-btn" data-id="${Staff.ID}"
                                data-name="${Staff.name}"
                                data-email="${Staff.email}" data-phone="${Staff.phone}" data-dob="${Staff.DOB}"
                                data-role="${Staff.role.ordinal()}">Edit
                            User
                        </button>
                        <a class="btn btn-danger delete-btn" href="staff/DeleteStaffProfile?id=${Staff.ID}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>

    <div class="modal" tabindex="-1" role="dialog" id="addStaffModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalTitle">Add Staff Member</h5>
                    <button type="button" class="close btn btn-outline-secondary" data-bs-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="staff/manageStaff" method="post" class="form">
                    <div class="modal-body">
                        <div class="input-box">
                            <label>Full Name :
                                <input type="text" placeholder="Enter full name" name="name" id="name" required>
                            </label>
                        </div>
                        <div class="input-box">
                            <label>Email :
                                <input type="email" placeholder="Enter email" name="email" id="email" required>
                            </label>
                        </div>
                        <div class="column">
                            <div class="input-box">
                                <label>Phone Number :
                                    <input type="text" placeholder="Enter phone number" name="phone" id="phone"
                                           required>
                                </label>
                            </div>
                            <div class="input-box">
                                <label>Birth Date :
                                    <input type="date" name="DOB" id="DOB" required>
                                </label>
                            </div>
                        </div>
                        <div class="input-box">
                            <label>
                                Type:
                                <select name="role">
                                    <option value="0">Staff</option>
                                    <option value="1">Manager</option>
                                </select>
                            </label>
                        </div>
                    </div>
                    <input type="hidden" name="ID" id="ID">
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" id="modalAction">Add Staff</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </form>

            </div>
        </div>
    </div>


    <script src="assets/js/staff.js"></script>

</body>
</html>