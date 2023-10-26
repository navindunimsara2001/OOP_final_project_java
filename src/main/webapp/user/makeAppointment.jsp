<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/includes/header.jsp"/>
    <title>Create Appointment - WinFuel</title>
    <link rel="stylesheet" href="assets/styles/appointmentStyle.css">

</head>

<body>
<jsp:include page="/includes/site_menu.jsp"/>
<main>
    <div class="container">
        <div class="column">
            <h3>Appointment</h3>
            <form method="post" action="user/createAppointment">
                <div class="input">
                    <label for="">Vehicle Brand :
                        <input type="text" name="brand" id="" required>
                    </label>
                </div>
                <div class="input">
                    <label for="">Vehicle model :
                        <input type="text" name="model" required>
                    </label>
                </div>
                <div class="input">
                    <label for="">Vehicle year :
                        <input type="text" name="year" required>
                    </label>
                </div>
                <div class="input">
                    <div class="col">
                        <label for="service-type">Service Type:</label>
                        <select id="service-type" name="serviceType" required>
                            <option value="Full Service">Full Service</option>
                            <option value="Oil Change">Oil Change</option>
                            <option value="Wheel Alignment">Wheel Alignment</option>
                            <option value="Tire Rotation">Tire Rotation</option>
                            <option value="Interior Clean">Interior Cleaning</option>
                            <option value="Brake Inspection">Brake Inspection</option>
                            <option value="other">Other</option>
                        </select>
                    </div>
                    <div class="col">
                        <label for="appointment-date">Appointment Date:</label>
                        <input type="date" id="appointment-date" name="appointmentDate" required>
                    </div>
                </div>
                <div class="input">
                    <label for="comments">Additional Comments:</label>
                    <textarea id="comments" name="comments" rows="4" cols="50"></textarea><br><br>
                </div>
                <div class="submit">
                    <input class="btn" type="submit" name="submit" value="Submit">
                    <input class="btn" type="reset" name="reset" value="Reset">
                </div>
            </form>
        </div>
    </div>
</main>
<jsp:include page="/includes/footer.jsp"/>

</body>

</html>