<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="sidebar">
    <div class="sidebar-up">
        <a class="sidebar-option" href="staff/manageUsers" ${sessionScope.get("role").ordinal() == 2 ? "" :"hidden"}>
            <img src="assets/images/Icons/user-search-svgrepo-com.svg" width="40px">
            <div class="sidebar-option-text">Users</div>
        </a>
        <a class="sidebar-option" href="staff/manageStaff"${sessionScope.get("role").ordinal() == 2 ? "" :"hidden"}>
            <img src="assets/images/Icons/users-svgrepo-com.svg" width="40px">
            <div class="sidebar-option-text">Staff</div>
        </a>
        <a class="sidebar-option"
           href="staff/manageAppointment" ${sessionScope.get("role").ordinal() == 1 ? "" :"hidden"}>
            <img src="assets/images/Icons/square-list-svgrepo-com.svg" width="40px">
            <div class="sidebar-option-text">Appointments</div>
        </a>
        <a class="sidebar-option" href="staff/requestItem" ${sessionScope.get("role").ordinal() == 0 ? "" :"hidden"}>
            <img src="assets/images/Icons/cube-alt-2-svgrepo-com.svg"
                 width="40px">
            <div class="sidebar-option-text">Request Items</div>
        </a>
        <a class="sidebar-option" href="staff/requestedItem" ${sessionScope.get("role").ordinal() == 0 ? "" :"hidden"}>
            <img src="assets/images/Icons/cube-alt-2-svgrepo-com.svg" width="40px">
            <div class="sidebar-option-text">Requested Items</div>
        </a>
        <a class="sidebar-option"
           href="staff/ManageItemRequest" ${sessionScope.get("role").ordinal() == 1 ? "" :"hidden"}>
            <img src="assets/images/Icons/cube-alt-2-svgrepo-com.svg" width="40px">
            <div class="sidebar-option-text">All Requested Items</div>
        </a>
        <a class="sidebar-option" href="staff/viewItemList" ${sessionScope.get("role").ordinal() == 1 ? "" :"hidden"}>
            <img src="assets/images/Icons/cube-alt-2-svgrepo-com.svg" width="40px">
            <div class="sidebar-option-text">All Items</div>
        </a>
        <a class="sidebar-option" href="staff/fuelSales" ${sessionScope.get("role").ordinal() == 0 ? "" :"hidden"}>
            <img src="assets/images/Icons/square-list-svgrepo-com.svg" width="40px">
            <div class="sidebar-option-text">Fuel Sales</div>
        </a>

        <a class="sidebar-option"
           href="staff/UpdateFuelServlet" ${sessionScope.get("role").ordinal() == 1 ? "" :"hidden"}>
            <img src="assets/images/Icons/square-list-svgrepo-com.svg" width="40px">
            <div class="sidebar-option-text">Fuel Management</div>
        </a>

        <a class="sidebar-option"
           href="staff/assignedAppointments" ${sessionScope.get("role").ordinal() == 0?"": "hidden"}>
            <img src="assets/images/Icons/square-list-svgrepo-com.svg" width="40px">
            <div class="sidebar-option-text">Assigned Appointments</div>
        </a>


    </div>
</aside>
