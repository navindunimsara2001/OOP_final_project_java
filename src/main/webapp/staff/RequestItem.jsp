<!-- FILEPATH: /d:/Y1S2/IWT/Assignment/IWT gp/Online Vehicle Service and Fuel Management/Request.html -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Request Items</title>

    <!--thumbnail icon-->
    <link rel="icon" href="../assets/images/thumbnail.ico" type="image/png">
    <!---->

    <!--stylesheet-->
    <link rel="stylesheet" href="../assets/styles/Request.css">
    <link rel="stylesheet" href="../assets/styles/form.css">
    <script src="js/Request.js"></script>

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

    <input type="text" id="searchInput" placeholder="Search by item name">
    <button onclick="searchItems()">Search</button>
</div>
<div class="requestTable">
    <table>
        <tr>
            <th>Item Code</th>
            <th>Item Name</th>
            <th>Availability</th>
            <th></th>
        </tr>
        <tr>
            <td>001</td>
            <td>Sample Item</td>
            <td>In Stock</td>
            <td>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Request Item</button>
            </td>
        </tr>
    </table>

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
                                <label>Item name :  </label>
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
</body>
</html>

