<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <title>Manage Customers - WinFuel Dashboard</title>
    <link rel="stylesheet" href="assets/styles/form.css">
</head>

<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
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
                            <%--                        href="staff/editUser?ID=${Customer.ID}"--%>
                        <a class="btn btn-primary edit-user-btn"
                           data-id="${Customer.ID}"
                           data-name="${Customer.name}"
                           data-phone="${Customer.phone}"
                           data-dob="${Customer.DOB}"
                           data-district="${Customer.district}"
                        >Edit</a>

                        <a class="btn btn-danger" href="staff/deleteUser?ID=${Customer.ID}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>

</div>

<div class="modal" tabindex="-1" role="dialog" id="userEditModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalTitle">Add Staff Member</h5>
                <button type="button" class="close btn btn-outline-secondary" data-bs-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post" class="form">
                <div class="modal-body">
                    <div class="input-box">
                        <label>Full Name :
                            <input type="text" placeholder="Enter full name" name="name" id="name" required>
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
                        <label>District :
                            <select name="district" class="select-box" id="district" required>
                                <option value="Colombo">Colombo</option>
                                <option value="Gampaha">Gampaha</option>
                                <option value="Kalutara">Kalutara</option>
                                <option value="Kandy">Kandy</option>
                                <option value="Matale">Matale</option>
                                <option value="Nuwara Eliya">Nuwara Eliya</option>
                                <option value="Galle">Galle</option>
                                <option value="Matara">Matara</option>
                                <option value="Hambantota">Hambantota</option>
                                <option value="Jaffna">Jaffna</option>
                                <option value="Kilinochchi">Kilinochchi</option>
                                <option value="Mannar">Mannar</option>
                                <option value="Vavuniya">Vavuniya</option>
                                <option value="Mullaitivu">Mullaitivu</option>
                                <option value="Batticaloa">Batticaloa</option>
                                <option value="Ampara">Ampara</option>
                                <option value="Trincomalee">Trincomalee</option>
                                <option value="Kurunegala">Kurunegala</option>
                                <option value="Puttalam">Puttalam</option>
                                <option value="Anuradhapura">Anuradhapura</option>
                                <option value="Polonnaruwa">Polonnaruwa</option>
                                <option value="Badulla">Badulla</option>
                                <option value="Moneragala">Moneragala</option>
                                <option value="Ratnapura">Ratnapura</option>
                                <option value="Kegalle">Kegalle</option>
                            </select>
                        </label>
                    </div>
                </div>
                <input type="hidden" name="ID" id="ID">
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" id="modalAction">Update User</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </form>

        </div>
    </div>
</div>
<script src="assets/js/user_edit.js"></script>

</body>

</html>