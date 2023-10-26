<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <title>Manage Items - WinFuel Dashboard</title>
    <link rel="stylesheet" href="assets/styles/newitems.css">
</head>

<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
    <main>
        <h3>Manage Items</h3>
        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addItem">+ Add Item</button>
        <table class="table table-striped table-hover table-bordered table-responsive">
            <thead class="text-center">
            <tr class="table-info">
                <th>ID</th>
                <th>Name</th>
                <th>Amount</th>
            </tr>
            </thead>
            <tbody class="table-hover text-center">
            <c:forEach items="${itmList}" var="Item">
                <tr>
                    <td>${Item.ID}</td>
                    <td>${Item.name}</td>
                    <td>${Item.inStock}</td>
                    <td class="text-center">
                        <form action="staff/viewItemList" method="post">
                            <input type="number" name="qty">
                            <input type="hidden" name="itmID" value="${Item.ID}">
                            <button type="submit" class="btn btn-primary">
                                Edit
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</div>
<div class="modal" tabindex="-1" role="dialog" id="addItem">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add item</h5>
                <button type="button" class="close btn btn-outline-secondary" data-bs-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="staff/viewItemList"></form>
            <div class="modal-body">
                <section class="container" id="container">
                    <form action="" method="post" class="form">
                        <div class="input-box">
                            <label>Item name :
                                <input type="text" name="itemName" required id="itemName"></label>
                        </div>
                        <div class="input-box">
                            <label>Amount :
                                <input type="number" placeholder="" name="amount" min=0> </label>
                        </div>
                        <input type="hidden" name="itemId" id="itemId" value="">
                        <button type="submit">Submit</button>
                    </form>
                </section>
            </div>
        </div>
    </div>
</div>
</body>

</html>