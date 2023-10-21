<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="menu main-menu">
    <div class="header item no-hover">
        <img class="logo" src="assets/images/winfuel connect.png" alt="Logo" height="32px">
    </div>
    <div class="item spacer no-hover"></div>
    <div class="item no-hover if-not-login">
        <a class="btn btn-primary" href="login">Login</a>
        <a class="btn btn-outline-secondary" href="registration.html">Sign Up</a>
    </div>
    <a class="item if-login" href="#">My Appointments</a>
    <div class="item dropdown no-hover if-login" id="profile-dropdown" tabindex="1">
        <img src="assets/images/profile.svg" width="28px">
        <div class="dropdown-content">
            <a href="#" class="item">Action 1</a>
            <a href="#" class="item">Action 2</a>
            <a href="#" class="item">Action 3</a>
            <a href="#" class="item">Action 4</a>
        </div>

    </div>
</nav>
<div class="main-menu-placeholder"></div>
