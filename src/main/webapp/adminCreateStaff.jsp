<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/styles/main.css">
    <link rel="stylesheet" href="assets/styles/dashboard.css">
    <link rel="stylesheet" href="assets/styles/staffregistration.css">
    <title>Staff Registration</title>
</head>
<body>
    <nav class="menu mini-menu fixed floating">
        <img class="logo" src="assets/images/winfuel connect.png" alt="Logo" height="32px"></img>
    </nav>
    
    <div class="sidebar-container">
        <aside class="sidebar">
            <div class="sidebar-up">
                <div class="sidebar-option">
                    <img src="assets/images/Icons/user-search-svgrepo-com.svg" width="40px">
                    <div class="sidebar-option-text">Users</div>
                </div>
                <div class="sidebar-option">
                    <img src="assets/images/Icons/user-shield-svgrepo-com.svg" width="40px">
                    <div class="sidebar-option-text">Managers</div>
                </div>
                <div class="sidebar-option">
                    <img src="assets/images/Icons/users-svgrepo-com.svg" width="40px">
                    <div class="sidebar-option-text">Staff</div>
                </div>
                <div class="sidebar-option">
                    <img src="assets/images/Icons/square-list-svgrepo-com.svg" width="40px">
                    <div class="sidebar-option-text">Appointments</div>
                </div>
                <div class="sidebar-option">
                    <img src="assets/images/Icons/cube-alt-2-svgrepo-com.svg" width="40px">
                    <div class="sidebar-option-text">Items</div>
                </div>
            </div>
            <hr>
            <div class="sidebar-down">
                <div class="sidebar-option">
                    <img src="assets/images/Icons/user-plus-svgrepo-com.svg" width="40px">
                    <div class="sidebar-option-text">Create Manager</div>
                </div>
                <div class="sidebar-option">
                    <img src="assets/images/Icons/user-plus-svgrepo-com.svg" width="40px">
                    <div class="sidebar-option-text">Create Staff Member</div>
                </div>
            </div>
        </aside>

        <main>
            <section class="container">
                <header class="header">Staff Registration Form</header>
                <form action="./adminCreateStaff" method="post" class="form">
                    <div class="input-box">
                        <label>Full Name : </label>
                        <input type="text" placeholder="Enter full name" name="name" required>
                    </div>
                    <div class="input-box">
                        <label>Email : </label>
                        <input type="email" placeholder="Enter email" name="email" required>
                    </div>
                    <div class="column">
                        <div class="input-box">
                            <label>Phone Number : </label>
                            <input type="text" placeholder="Enter phone number" name="phone" required>
                        </div>
                        <div class="input-box">
                            <label>Birth Date : </label> 
                            <input type="date" name="DOB" required>
                        </div>
                    </div>
                    <div class="input-box">
                        <label>Password : </label>
                        <input type="password" name="password" id="password" required>
                    </div>
                    <div class="input-box">
                        <label>Confirm Password : </label>
                        <input type="password" id="repassword" required>
                    </div>
                    <!-- role selection -->
                    <input type="hidden" name="role" value="0">
                    <button type="submit">Submit</button>
                </form>
            </section>
        </main>
    </div>

    
</body>
</html>