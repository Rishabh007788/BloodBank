<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head> 
    <meta charset="UTF-8">
    <title>Signup Page</title>
</head>
<body>
    <h2>Signup Page</h2>
    <form action="signup" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="mobile">Mobile Number:</label>
        <input type="tel" id="mobile" name="mobile" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select><br>

        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required><br>

        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <input type="submit" value="Signup">
    </form>
</body>
</html>
