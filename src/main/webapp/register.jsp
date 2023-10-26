<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <jsp:include page="/includes/header.jsp"/>
    <title>Register - WinFuel</title>
    <link rel="stylesheet" href="assets/styles/form.css">
    <link rel="stylesheet" href="assets/styles/registrationstyle.css">
</head>

<body>
<jsp:include page="/includes/site_menu.jsp"/>

<main>

    <section class="container">
        <header class="header">Registration Form</header>
        <form action="registerUser" method="post" class="form" id="reg">
            <div class="input-box">
                <label>Full Name :
                    <input type="text" placeholder="Enter full name" name="name" required>
                </label>
            </div>
            <div class="input-box">
                <label>Email :
                    <input type="email" placeholder="Enter email" name="email" required>
                </label>
            </div>
            <div class="column">
                <div class="input-box">
                    <label>Phone Number :
                        <input type="text" placeholder="Enter phone number" name="phone" required>
                    </label>
                </div>
                <div class="input-box">
                    <label>Birth Date :
                        <input type="date" name="DOB" required>
                    </label>
                </div>
            </div>
            <div class="input-box">
                <label for="password">Password :
                    <input type="password" name="password" id="password" required>
                </label>
            </div>
            <div class="input-box">
                <label>Confirm Password :
                    <input type="password" id="repassword" required>
                </label>
            </div>

            <div class="gender-box">
                <h3>Gender</h3>
                <div class="gender-option">
                    <div class="gender">
                        <label><input type="radio" name="gender" value="male" checked>
                            Male</label>
                    </div>
                    <div class="gender">
                        <label>
                            <input type="radio" name="gender" value="female">
                            Female</label>
                    </div>
                </div>
            </div>
            <div class="select-box">
                <label>District :
                    <select name="district">
                        <option value="Colombo">Colombo</option>
                        <option value="Gampaha">Gampaha</option>
                        <option value="Kalutara">Kalutara</option>
                        <option value="Kandy">Kandy</option>
                        <option value="Matale">Matale</option>
                        <option value="Nuwara Eliya">Nuwara Eliya</option>
                        <option value="Galle">Galle</option>
                        <option value="Matara">Matara</option>
                        <option value="Hambantota">Hambantota</option>
                        <option value="Jaffna">Jaffna</option>
                        <option value="Kilinochchi">Kilinochchi</option>
                        <option value="Mannar">Mannar</option>
                        <option value="Vavuniya">Vavuniya</option>
                        <option value="Mullaitivu">Mullaitivu</option>
                        <option value="Batticaloa">Batticaloa</option>
                        <option value="Ampara">Ampara</option>
                        <option value="Trincomalee">Trincomalee</option>
                        <option value="Kurunegala">Kurunegala</option>
                        <option value="Puttalam">Puttalam</option>
                        <option value="Anuradhapura">Anuradhapura</option>
                        <option value="Polonnaruwa">Polonnaruwa</option>
                        <option value="Badulla">Badulla</option>
                        <option value="Moneragala">Moneragala</option>
                        <option value="Ratnapura">Ratnapura</option>
                        <option value="Kegalle">Kegalle</option>
                    </select> </label>
            </div>
            <button type="submit" id="submit" disabled>Submit</button>
            <div class="a"><a href="login">Already have an account?</a></div>
        </form>
    </section>
</main>

<script>
    let form = document.getElementById("reg");

    function checkPasswordMatch() {
        console.log("called")
        var password = document.getElementById("password").value;
        var repassword = document.getElementById("repassword").value;
        var submit = document.getElementById("submit");
        console.log(password, repassword, submit)

        if (password === repassword || password.length < 8) {
            submit.disabled = false; // Enable the submit button
            form.classList.remove("invalid-inp");
        } else {
            submit.disabled = true; // Disable the submit button
            form.classList.add("invalid-inp");
        }
    }

    form.addEventListener("input", checkPasswordMatch);
</script>


<jsp:include page="/includes/footer.jsp"/>

</body>

</html>