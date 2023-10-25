<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.util.URLS" %>
<nav class="menu main-menu <%= request.getSession().getAttribute("id") == null ? "" : "logged-in"%>">
    <a class="header item no-hover" href="./">
        <img class="logo" src="assets/images/winfuel connect.png" alt="Logo" height="32px">
    </a>
    <div class="item spacer no-hover"></div>
    <div class="item no-hover if-not-login">
        <a class="btn btn-primary" href="${URLS.USER_LOGIN}">Login</a>
        <a class="btn btn-outline-secondary" href="${URLS.USER_REGISTER}">Sign Up</a>
    </div>
    <a class="item if-login" href="privacy.jsp">Privacy Policy</a>
    <a class="item if-login" href="contct.jsp">Contact Us</a>
    <a class="item if-login" href="user/appointments">My Appointments</a>
    <div class="item dropdown no-hover if-login" id="profile-dropdown" tabindex="1">
        <img src="assets/images/profile.svg" width="28px">
        <div class="dropdown-content">
            <a href="user/profile" class="item">Profile</a>
            <a href="user/appointments" class="item">My Appointments</a>
            <a href="user/makeAppointment.jsp" class="item">Appointment</a>
            <a href="logout" class="item">Logout</a>
        </div>

    </div>
</nav>
<div class="main-menu-placeholder"></div>

