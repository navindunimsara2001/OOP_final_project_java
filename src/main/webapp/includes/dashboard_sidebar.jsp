<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="sidebar">
    <div class="sidebar-up">
        <c:if test="${sessionScope.get('role').ordinal() == 0}">
            <a class="sidebar-option"
               href="staff/assignedAppointments">
                <img src="assets/images/Icons/square-list-svgrepo-com.svg" width="40px">
                <div class="sidebar-option-text">Assigned Appointments</div>
            </a>


            <a class="sidebar-option" href="staff/requestItem">
                <img src="assets/images/Icons/cube-alt-2-svgrepo-com.svg"
                     width="40px">
                <div class="sidebar-option-text">Request Items</div>
            </a>


            <a class="sidebar-option" href="staff/fuelSales">
                <img src="assets/images/Icons/square-list-svgrepo-com.svg" width="40px">
                <div class="sidebar-option-text">Fuel Sales</div>
            </a>

            <a class="sidebar-option" href="staff/requestedItem">
                <img src="assets/images/Icons/cube-alt-2-svgrepo-com.svg" width="40px">
                <div class="sidebar-option-text">Requested Items</div>
            </a>


        </c:if>

        <c:if test="${sessionScope.get('role').ordinal() == 1}">

            <a class="sidebar-option"
               href="staff/manageAppointment">
                <img src="assets/images/Icons/square-list-svgrepo-com.svg" width="40px">
                <div class="sidebar-option-text">Appointments</div>
            </a>


            <a class="sidebar-option"
               href="staff/ManageItemRequest">
                <img src="assets/images/Icons/cube-alt-2-svgrepo-com.svg" width="40px">
                <div class="sidebar-option-text">All Requested Items</div>
            </a>
            <a class="sidebar-option"
               href="staff/viewItemList">
                <img src="assets/images/Icons/cube-alt-2-svgrepo-com.svg" width="40px">
                <div class="sidebar-option-text">All Items</div>
            </a>

            <a class="sidebar-option"
               href="staff/UpdateFuelServlet">
                <img src="assets/images/Icons/square-list-svgrepo-com.svg" width="40px">
                <div class="sidebar-option-text">Fuel Management</div>
            </a>
        </c:if>


        <c:if test="${sessionScope.get('role').ordinal() == 2}">
            <a class="sidebar-option"
               href="staff/manageUsers">
                <img src="assets/images/Icons/user-search-svgrepo-com.svg" width="40px">
                <div class="sidebar-option-text">Users</div>
            </a>
            <a class="sidebar-option" href="staff/manageStaff">
                <img src="assets/images/Icons/users-svgrepo-com.svg" width="40px">
                <div class="sidebar-option-text">Staff</div>
            </a>
        </c:if>

    </div>
</aside>
