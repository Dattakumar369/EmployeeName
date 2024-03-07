<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .container {
        text-align: center;
        padding: 50px;
    }
    .company-name {
        font-size: 50px;
        font-weight: bold;
        margin-bottom: 60px;
    }
    .random-color {
        animation: colorChange 3s infinite;
    }
    @keyframes colorChange {
        0% { color: red; }
        25% { color: blue; }
        50% { color: green; }
        75% { color: orange; }
        100% { color: red; }
    }
    .btn {
        padding: 10px 20px;
        font-size: 16px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-decoration: none;
        transition: background-color 0.3s;
    }
    .btn:hover {
        background-color: #0056b3;
    }
    .navbar {
        background-color: blue;
        overflow: hidden;
        display: flex;
        justify-content: space-between; /* Align items on the ends */
        align-items: center;
        padding: 10px 20px;
    }
    .navbar a {
        color: #f2f2f2;
        text-decoration: none;
        padding: 14px 20px;
    }
    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }
    .department-img {
        max-width: 100%;
        height: auto;
    }
</style>
</head>
<body>
<div class="navbar">
    <div>
        <a href="#home">Home</a>
        <a href="#Services">Services</a>
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
        
    </div>
    <div>
        <!-- Place your logo image here -->
        <img src="https://rjaytechnologies.com/wp-content/uploads/2023/12/cropped-WhatsApp-Image-2023-12-18-at-2.51.01-PM-180x78.jpeg" alt="RJay Technologies Logo" width="180" height="78">
    </div>
</div>

<div class="container">
    <p>Welcome to the company</p>
    <p class="company-name random-color">RJAY</p>
    
    <button class="btn" onclick="showAlert()">Employee Details</button>
</div>

<script>
    function showAlert() {
        alert("Please login or sign up for more details.");
     if (confirm("Please login or sign up for more details.")) {
            window.location.href = "login.jsp"; // Redirect to the login JSP page
        }
    }
    
</script>
</body>
</html>
