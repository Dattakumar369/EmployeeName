<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Employee Registration</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    .navbar {
      background-color: #007bff;
      color: #fff;
      text-align: center;
      padding: 20px 0;
    }

    form {
      max-width: 500px;
      margin: 0 auto;
      padding: 20px;
      background-color: #f9f9f9;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
      display: block;
      margin-bottom: 5px;
      font-weight: bold;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"],
    input[type="file"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    select {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      background-color: #007bff;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }

    input[type="submit"]:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>

<div class="navbar">
  <h1>Employee Registration</h1>
</div>

<form action="Savedata" method="post" enctype="multipart/form-data">
  <label for="id">ID:</label>
  <input type="text" id="id" name="id" required>

  <label for="fullname">Full Name:</label>
  <input type="text" id="fullname" name="fullname" required>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required>

  <label for="designation">Designation:</label>
  <input type="text" id="designation" name="designation" required>

  <label for="mobileno">Mobile Number:</label>
  <input type="text" id="mobileno" name="mobileno" required>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required>

  <label for="gender">Gender:</label>
  <select id="gender" name="gender" required>
    <option value="" disabled selected>Select Gender</option>
    <option value="male">Male</option>
    <option value="female">Female</option>
    <option value="other">Other</option>
  </select>

  <label for="relocate">Are you ready to relocate?</label>
  <select id="relocate" name="relocate" required>
    <option value="" disabled selected>Select Option</option>
    <option value="yes">Yes</option>
    <option value="no">No</option>
    <option value="notsure">Not Sure</option>
  </select>

  <label for="previouscompany">Previous Company:</label>
  <input type="text" id="previouscompany" name="previouscompany">

  <label for="experience">Experience:</label>
  <select id="experience" name="experience">
    <option value="" disabled selected>Select Experience</option>
    <option value="0-1 year">0-1 year</option>
    <option value="1-3 years">1-3 years</option>
    <option value="3-5 years">3-5 years</option>
    <option value="5-7 years">5-7 years</option>
    <option value="7+ years">7+ years</option>
  </select>

  <label for="resume">Resume:</label>
  <input type="file" id="resume" name="resume">

  <input type="submit" value="Submit">
</form>

</body>
</html>
 