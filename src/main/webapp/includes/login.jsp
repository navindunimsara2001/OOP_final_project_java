<%@ page import="com.util.URLS" %>
<section class="container">
    <header class="header">${ requestScope.get("staff") ? "Staff": "User"} Login</header>

    <div class="alert alert-danger" role="alert" ${requestScope.get("incorrect")? "": "hidden='true'"}>
        Incorrect username or password.
    </div>

    <form method="post" action="" class="form">
        <div class="input-box">
            <label for="email">Email : </label>
            <input type="text" id="email" name="email" required>
        </div>
        <div class="input-box">
            <label for="password">Password : </label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Submit</button>
        <br>

        <% if (!(boolean) request.getAttribute("staff")) { %>
        <div class="a"><a href="${URLS.USER_REGISTER}">Don't have an account?</a></div>
        <% }%>
    </form>
</section>