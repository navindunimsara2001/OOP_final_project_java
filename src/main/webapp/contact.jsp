<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/includes/header.jsp"/>
    <title>Contact Us - WinFuel</title>
    <style>

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background: rgba(255, 255, 255, 0.7);
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            display: grid;
            grid-template-columns: 1fr 1fr;
        }

        .container a {
            color: #333;
            text-decoration: none;
        }

        h1 {
            text-align: center;
        }

        .contact-info {
            margin-top: 20px;
        }

        .contact-info p {
            margin: 10px 0;
        }

        .map-container {
            text-align: center;
        }
    </style>
</head>
<body>
<jsp:include page="/includes/site_menu.jsp"/>
<main>

    <div class="container">
        <div class="contact-info">
            <h1>Contact Us</h1>
            <p><strong>Phone Number:</strong> +94 71 1231231</p>
            <p><strong>Address:</strong> 123 Main Street, City, Country</p>
            <p><strong>Location:</strong> <a
                    href="https://www.google.com/maps/@35.7040744,139.5577317,3a,75y,289.6h,87.01t,0.72r/data=!3m6!1e1!3m4!1sgT28ssf0BB2LxZ63JNcL1w!2e0!7i13312!8i6656">Open
                Google Maps</a></p>
        </div>
        <div class="image">
            <img src="assets/images/contact.jpeg" alt="Contact Us" width="100%">
        </div>
    </div>
</main>
</body>
<jsp:include page="/includes/footer.jsp"/>
</html>
