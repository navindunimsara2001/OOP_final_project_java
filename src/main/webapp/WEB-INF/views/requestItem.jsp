<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Request Items</title>

    <!--thumbnail icon-->
    <link rel="icon" href="assets/images/thumbnail.ico" type="image/png">
    <!---->

    <!--stylesheet-->
    <link rel="stylesheet" href="assets/styles/Request.css">
    <link rel="stylesheet" href="assets/styles/form.css">
    <script src="assets/js/Request.js"></script>

    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="contentRequest">
    <h1>Request Items</h1>
    <p>Please fill out the form below to request items.</p>
    <form action="">
        <input type="text" id="searchInput" placeholder="Search by item name" name="q">
        <button type="submit">Search</button>
    </form>
</div>
<div class="requestTable">
    <table>
        <tr>
            <th>Item Code</th>
            <th>Item Name</th>
            <th>Availability</th>
            <th></th>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.ID}</td>
                <td>${item.name}</td>
                <td>${item.inStock? "In":"Out of"} Stock</td>
                <td>
                    <button type="button" class="btn btn-primary item-req-btn" data-id="${item.ID}"
                            data-name="<c:out value="${item.name}" />">Request
                        Item
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>


    <!-- Modal -->
    <div class="modal" id="requestModal" tabindex="-1" role="dialog">
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
                                <label>Item name :
                                    <input type="text" name="itemName" required readonly id="itemName"></label>
                            </div>
                            <div class="input-box">
                                <label>Amount :
                                    <input type="number" placeholder="" name="amount"> </label>
                            </div>
                            <input type="hidden" name="itemId" id="itemId" value="">
                            <button type="submit">Submit</button>
                        </form>
                    </section>
                </div>
            </div>
        </div>
    </div>

    <script>
        $(".item-req-btn").each((_, e) => {
            e.addEventListener("click", () => {
                let model = $('#requestModal');
                model.find('form')[0].reset();
                console.log(e.dataset);
                console.log(model.find("#itemID"))
                model.find('#itemId').val(e.dataset['id']);
                model.find("#itemName").val(e.dataset["name"]);

                model.modal('show');
            });
        })
    </script>
</div>
</body>
</html>

