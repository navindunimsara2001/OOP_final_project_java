<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <title>Update Fuel</title>
    <link rel="stylesheet" href="assets/styles/fuelrestock.css">
</head>

<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
    <main>
        <section id="features" class="features">
            <h2>Fuel Updates</h2>
            <div class="card" id="card">

                <form class="feature" id="f1" method="post" action="staff/UpdateFuelServlet">
                    <div class="img">
                        <img src="assets/images/fuel/petrol92.jpeg" alt="Petrol 92">
                    </div>
                    <div class="feattop">
                        <h3>Petrol 92</h3>
                        <h1 class="remain">${fuel1.amount}L</h1>
                    </div>

                    <div class="pricetag" id="pricetag1">
                        <div class="header">
                            <h4>Price LKR :</h4>
                        </div>
                        <div class="price">
                            <input type="number" id="price1" name="price" value="${fuel1.price}"
                                   step="0.01">
                        </div>
                        <div class="header">
                            <h4>Amount Liter :</h4>
                        </div>
                        <div class="amount">
                            <input type="number" id="amount1" name="amount" value="0.00">
                        </div>
                    </div>
                    <div class="btn">
                        <input type="hidden" name="ID" value="1">
                        <button type="submit" class="action-button" id="btn1">Update</button>
                    </div>
                </form>

                <form class="feature" id="f2" method="post" action="staff/UpdateFuelServlet">
                    <div class="img">
                        <img src="assets/images/fuel/petrol95.jpeg" alt="Petrol 95">
                    </div>
                    <div class="feattop">
                        <h3>Petrol 95</h3>
                        <h1 class="remain">${fuel2.amount}L</h1>
                    </div>
                    <div class="pricetag" id="pricetag2">
                        <div class="header">
                            <h4>Price LKR :</h4>
                        </div>
                        <div class="price">
                            <input type="number" id="price2" name="price" value="${fuel2.price}"
                                   step="0.01">
                        </div>
                        <div class="header">
                            <h4>Amount Liter :</h4>
                        </div>
                        <div class="price">
                            <input type="number" id="amount2" name="amount" value="0.00">
                        </div>
                    </div>

                    <div class="btn">
                        <input type="hidden" name="ID" value="2">
                        <button type="submit" class="action-button" id="btn1">Update</button>
                    </div>
                </form>

                <form class="feature" id="f3" method="post" action="staff/UpdateFuelServlet">
                    <div class="img">
                        <img src="assets/images/fuel/diesel.jpeg" alt="Diesel">
                    </div>
                    <div class="feattop">
                        <h3>Diesel</h3>
                        <h1 class="remain">${fuel3.amount}L</h1>
                    </div>

                    <div class="pricetag" id="pricetag3">
                        <div class="header">
                            <h4>Rs.</h4>
                        </div>
                        <div class="price">
                            <input type="number" id="price3" name="price" value="${fuel3.price}"
                                   step="0.01">
                        </div>
                        <div class="header">
                            <h4>Amount Liter :</h4>
                        </div>
                        <div class="price">
                            <input type="number" id="amount3" name="amount" value="0.00">
                        </div>
                    </div>

                    <div class="btn">
                        <input type="hidden" name="ID" value="3">
                        <button type="submit" class="action-button" id="btn1">Update</button>
                    </div>
                </form>
            </div>
        </section>
    </main>
</div>
</body>
</html>