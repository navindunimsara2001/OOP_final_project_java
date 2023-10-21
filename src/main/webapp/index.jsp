<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/includes/header.jsp"/>
    <title>WinFuel</title>
    <link rel="stylesheet" href="assets/styles/homepage.css">
</head>

<body>
<jsp:include page="/includes/site_menu.jsp"/>
<main>
    <section class="hero">
        <div class="hero-content">
            <h2>Welcome to WinFuel Connect</h2>
            <p>Your One-Stop Solution for Vehicle Service & Fuel Management</p>
            <a href="#services" class="btn">Explore Services</a>
        </div>
    </section>

    <section id="features" class="features">
        <h2>Key Features</h2>
        <div class="card">
            <div class="feature">
                <img src="assets/images/Home/scheduling.png" alt="Feature 1">
                <h3>Service Scheduling</h3>
                <p>Schedule vehicle services with ease and stay on top of maintenance.</p>
            </div>
            <div class="feature">
                <img src="assets/images/Home/tracking.png" alt="Feature 2">
                <h3>Fuel Tracking</h3>
                <p>Efficiently track fuel usage and expenses for your fleet.</p>
            </div>
            <div class="feature">
                <img src="assets/images/Home/reporting.png" alt="Feature 3">
                <h3>Reports & Analytics</h3>
                <p>Access detailed reports and analytics to optimize your vehicle operations.</p>
            </div>
        </div>
    </section>

    <section id="services" class="services">
        <h2>Our Services</h2>
        <div class="card">
            <div class="feature">
                <img src="assets/images/Home/appointment.png" alt="Service 1">
                <h3>Appointments</h3>
                <p>Create an Appointment</p>
            </div>
            <div class="feature">
                <img src="assets/images/Home/reporting.png" alt="Service 2">
                <h3>Fuel Management</h3>
                <p>Efficient fuel management to reduce costs and increase efficiency.</p>
            </div>
            <div class="feature">
                <img src="assets/images/Home/consulting.png" alt="Service 3">
                <h3>Consultation</h3>
                <p>Expert consultation on optimizing your vehicle fleet.</p>
            </div>
        </div>
    </section>

    <section id="contact" class="contact">
        <h2>Contact Us</h2>
        <p>If you have any questions or need assistance, feel free to get in touch with us.</p>
        <a href="contact.html" class="btn">Contact Us</a>
    </section>
</main>
<jsp:include page="/includes/footer.jsp"/>
</body>
</html>