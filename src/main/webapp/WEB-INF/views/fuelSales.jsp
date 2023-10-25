<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Objects" %>
<html>
<head>
    <jsp:include page="/includes/dashboard_header.jsp"/>
    <title>Title</title>
    <link rel="stylesheet" href="assets/styles/fuelmgt.css">

</head>
<body>
<jsp:include page="/includes/dashboard_menu.jsp"/>
<div class="sidebar-container">
    <jsp:include page="/includes/dashboard_sidebar.jsp"/>
    <main>
        <section id="features" class="features">
            <h2>Select Fuel Type</h2>
            <div class="card" id="card">

                <div class="feature" id="f1" onclick="openModal('Petrol 92', '1')">
                    <div class="feattop">
                        <img src="assets/images/fuel/petrol92.jpeg" alt="Petrol 92">
                        <h3>Petrol 92</h3>
                        <h1 class="remain">${fuel1.amount}L</h1>
                    </div>

                    <div class="pricetag" id="pricetag1">
                        <div class="header">
                            <h4>Price</h4>
                        </div>
                        <div class="price">
                            <h4>${fuel1.price} LKR</h4>
                        </div>
                    </div>
                </div>

                <div class="feature" id="f2" data-toggle="modal" data-target="#requestModal"
                     onclick="openModal('Petrol 95', '2')">
                    <div class="feattop">
                        <img src="assets/images/fuel/petrol95.jpeg" alt="Petrol 95">
                        <h3>Petrol 95</h3>
                        <h1 class="remain">${fuel2.amount}L</h1>
                    </div>

                    <div class="pricetag" id="pricetag2">
                        <div class="header">
                            <h4>Price</h4>
                        </div>
                        <div class="price">
                            <h4>${fuel2.price} LKR</h4>
                        </div>
                    </div>
                </div>

                <div class="feature" id="f3" onclick="openModal('Diesel', '3')">
                    <div class="feattop">
                        <img src="assets/images/fuel/diesel.jpeg" alt="Diesel">
                        <h3>Diesel</h3>
                        <h1 class="remain">${fuel3.amount}L</h1>
                    </div>

                    <div class="pricetag" id="pricetag3">
                        <div class="header">
                            <h4>Price</h4>
                        </div>
                        <div class="price">
                            <h4>${fuel3.price} LKR</h4>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Modal -->
        <div class="modal" id="requestModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Fuel Supply</h5>
                        <button type="button" class="close btn btn-outline-secondary" data-bs-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <section class="container" id="container">
                            <form action="staff/fuelSales" method="post" class="form">
                                <div class="input-box">
                                    <label>Fuel Type :
                                        <input type="text" name="fuelName" required readonly id="fuelName"></label>
                                </div>
                                <div class="input-box">
                                    <label>Amount :
                                        <input type="number" placeholder="" name="amount" step="0.01" min="0.1" max="${fuel1.amount}" id="fuelAmountInput"> </label>
                                        <div class="modal" id="requestModal" tabindex="-1" role="dialog">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title">Fuel Supply</h5>
                                                        <button type="button" class="close btn btn-outline-secondary" data-bs-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <section class="container" id="container">
                                                            <form action="staff/fuelSales" method="post" class="form">
                                                                <div class="input-box">
                                                                    <label>Fuel Type :
                                                                        <input type="text" name="fuelName" required readonly id="fuelName">
                                                                    </label>
                                                                </div>
                                                                <div class="input-box">
                                                                    <label>Amount :
                                                                        <input type="number" placeholder="" name="amount" step="0.01" min="0.1" max="" id="fuelAmountInput">
                                                                    </label>
                                                                </div>
                                                                <input type="hidden" name="itemId" id="itemId" value="">
                                                                <button type="submit" class="action-button">Submit</button>
                                                            </form>
                                                        </section>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <script>
                                            $(document).ready(function () {
                                                // Function to open the modal and set the fuel type and max amount
                                                function openModal(fuelType, itemId, maxAmount) {
                                                    $("#fuelName").val(fuelType);
                                                    $("#itemId").val(itemId);
                                                    $("#fuelAmountInput").attr("max", maxAmount);
                                                    $("#requestModal").modal("show");
                                                }

                                                // onClick function for the first feature
                                                $("#f1").on("click", function () {
                                                    openModal("Petrol 92", "1", "${fuel1.amount}");
                                                });

                                                // onClick function for the second feature
                                                $("#f2").on("click", function () {
                                                    openModal("Petrol 95", "2", "${fuel2.amount}");
                                                });

                                                // onClick function for the third feature
                                                $("#f3").on("click", function () {
                                                    openModal("Diesel", "3", "${fuel3.amount}");
                                                });
                                            });
                                        </script>
                                </div>
                            </form>
                        </section>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal End -->

        <script>
            $(document).ready(function () {
                // Function to open the modal and set the fuel type
                function openModal(fuelType, itemId) {
                    $("#fuelName").val(fuelType);
                    $("#itemId").val(itemId);
                    $("#requestModal").modal("show");
                }

                // onClick function for the first feature
                $("#f1").on("click", function () {
                    openModal("Petrol 92", "1"); // Replace "item1" with the actual item ID
                });

                // onClick function for the second feature
                $("#f2").on("click", function () {
                    openModal("Petrol 95", "2"); // Replace "item2" with the actual item ID
                });

                // onClick function for the third feature
                $("#f3").on("click", function () {
                    openModal("Diesel", "3"); // Replace "item3" with the actual item ID
                });
            });
        </script>
    </main>
</div>
</body>
</html>