<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/includes/header.jsp"/>
    <title>Terms Of Service - WinFuel</title>
    <style>

        .container {
            max-width: 1300px;
            max-height: 300px;
            margin: 0 auto;
            padding: 20px;
            background: rgba(255, 255, 255, 0.7);
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            display: grid;
            grid-template-columns: 2fr 1fr;
        }

        .container a {
            color: #333;
            text-decoration: none;
        }

        h1 {
            text-align: center;
            font-size: larger;
        }

        h2 {
            font-size: medium;
        }

        h3 {
            font-size: medium;
        }

        p {
            font-size: small;
        }

        ol {
            font-size: small;
        }

        .contact-info {
            overflow-y: auto;
            margin-top: 20px;
        }

        .contact-info p {
            margin: 10px 0;
        }

        .map-container {
            text-align: center;
        }

        @media screen and (max-width: 800px) {
            .container {
                grid-template-columns: 1fr;
            }

            .imgcontainer {
                display: none;
            }
        }
    </style>
    <script>
        window.onload = function () {
            var imgcontainer = document.querySelector('.imgcontainer');
            var container = document.querySelector('.container');
            container.style.maxHeight = imgcontainer.offsetHeight + 'px';
        }
    </script>
</head>
<body>
<jsp:include page="/includes/site_menu.jsp"/>
<main class="container">
    <div class="contact-info">

        <h1><u>Terms of Service</u></h1>
        <br><br>
        <p>Last Updated: 25/10/2023</p>

        <h2>1. Acceptance of Terms</h2>

        <p>Welcome to WinFuel Connect ("we," "our," or "us"). By accessing and using our online vehicle service and fuel
            station management services, you agree to be bound by these Terms of Service. If you do not agree to these
            terms, please do not use our services.</p>

        <h2>2. Use of Services</h2>

        <ol>
            <li>
                <h3>Eligibility</h3>
                <p>To use our services, you must be of legal age in your jurisdiction and have the capacity to enter
                    into a contract.</p>
            </li>
            <li>
                <h3>Registration</h3>
                <p>You may be required to create an account to access certain features of our services. You agree to
                    provide accurate and up-to-date information during the registration process.</p>
            </li>
            <li>
                <h3>Account Security</h3>
                <p>You are responsible for maintaining the security of your account and password. Notify us immediately
                    of any unauthorized use or breach of security.</p>
            </li>
        </ol>

        <h2>3. Service Description</h2>

        <p>WinFuel Connect provides online vehicle service and fuel station management services. We may update, modify,
            or discontinue our services at any time without notice.</p>

        <h2>4. User Conduct</h2>

        <p>You agree not to:</p>

        <ul>
            <li>Violate any applicable laws or regulations.</li>
            <li>Infringe upon the rights of others.</li>
            <li>Post or transmit harmful content, including but not limited to malware or viruses.</li>
            <li>Attempt to gain unauthorized access to our services or interfere with their proper functioning.</li>
        </ul>

        <h2>5. Intellectual Property</h2>

        <p>All content and materials on our website and services are protected by intellectual property rights,
            including trademarks, copyrights, and patents. You may not use, reproduce, or distribute any content without
            our prior written consent.</p>

        <h2>6. Privacy</h2>

        <p>Our Privacy Policy outlines our practices concerning the collection, use, and protection of your personal
            information. By using our services, you consent to the collection and use of data as described in the
            Privacy Policy.</p>

        <h2>7. Payment and Fees</h2>

        <p>Certain services may require payment. By using these services, you agree to pay the applicable fees. Fees are
            non-refundable unless otherwise stated.</p>

        <h2>8. Termination</h2>

        <p>We reserve the right to terminate or suspend your account or access to our services at our discretion, with
            or without cause and with or without notice.</p>

        <h2>9. Disclaimer of Warranties</h2>

        <p>Our services are provided "as is" without any warranties. We do not guarantee the accuracy, reliability, or
            availability of our services.</p>

        <h2>10. Limitation of Liability</h2>

        <p>We are not liable for any direct, indirect, incidental, special, or consequential damages arising from the
            use of our services.</p>

        <h2>11. Indemnification</h2>

        <p>You agree to indemnify and hold us harmless from any claims, losses, liabilities, and expenses arising from
            your use of our services or violation of these Terms.</p>

        <h2>12. Changes to Terms</h2>

        <p>We may update these Terms of Service at any time. The most recent version will be posted on our website, and
            your continued use of our services constitutes your acceptance of the revised terms.</p>

        <h2>13. Contact Information</h2>

        <p>If you have questions or concerns about these Terms of Service, please contact us at:</p>

        <address>
            contact@winfuel.com
        </address>
        <br><br><br><br><br>
    </div>
    <div class="imgcontainer">
        <img src="assets/images/appointment/tos.png">
    </div>
</main>
</body>
<jsp:include page="/includes/footer.jsp"/>
</html>
