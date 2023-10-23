<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous">
    <link rel="stylesheet" href="../../assets/styles/userProfileView.css">
    <title>User Profile</title>
</head>

<body>
<main>
    <div class="container">
        <h2>User Profile</h2>
        <div class="propic">
            <img src="../../assets/images/Icons/user-svgrepo-com.svg" alt="">
        </div>

        <div class="row">
            <div class="col-3"></div>
            <div class="col d-flex justify-content-center" id="col">
                <form action="">
                    <table>
                        <tr>
                            <th>
                                <div class="field">
                                    <label class="label" for="Name">Name : </label>
                                </div>
                            </th>
                            <th>
                                <div class="field">
                                    <input type="text" name="name"
                                           value="<%=request.getAttribute("name")%>" disabled>
                                </div>
                            </th>
                        </tr>
                        <tr>
                            <th>
                                <div class="field">
                                    <label class="label" for="Email : ">Email : </label>
                                </div>
                            </th>
                            <th>
                                <div class="field">
                                    <input type="email" name="email"
                                           value="<%=request.getAttribute("email")%>" disabled>
                                </div>
                            </th>

                        </tr>
                        <tr>
                            <th>
                                <div class="field">
                                    <label class="label" for="Phone Number">Phone : </label>
                                </div>
                            </th>
                            <th>
                                <div class="field">
                                    <input type="text" name="phone"
                                           value="<%=request.getAttribute("phone")%>" disabled>
                                </div>
                            </th>
                        </tr>
                        <tr>

                            <th>
                                <div class="field">
                                    <label class="label" for="DOB">DOB : </label>
                                </div>
                            </th>


                            <th>
                                <div class="field">
                                    <input type="date" name="DOB" id="DOB"
                                           value="<%=request.getAttribute("DOB")%>" disabled>
                                </div>
                            </th>

                        </tr>
                        <tr>
                            <th>
                                <div class="field">
                                    <label class="label" for="district"> District : </label>
                                </div>
                            </th>
                            <th>
                                <div class="field">
                                    <input type="text" name="district" id="district"
                                           value="<%=request.getAttribute("district")%>" disabled>
                                </div>
                            </th>
                        </tr>
                    </table>
                    <div class="button">
                        <a class="btn btn-outline-primary" href="?edit=true">Edit</a>
                    </div>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</main>
</body>

</html>