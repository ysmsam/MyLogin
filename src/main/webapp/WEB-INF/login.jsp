<%-- 
    Document   : login
    Created on : 2022-2-2, 12:42:39
    Author     : Sheng Ming Yan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form action="login" method="post">  
            <!-- having post is most important for form especially for login !! -->
            <p>
                <label for="username">Username: </label>
                <input type="text" name="username" id="username" value="${username}" required>
                <!--<input type="text" name="username" id="username">-->
            </p>
            <p>
                <label for="password">Password: </label>
                <input type="password" name="password" id="password" required>
                <!--<input type="password" name="password" id="password">-->
                <!--type = "password" will hide the character/text-->
            </p>
            
            <button type="submit">Submit</button>
        </form>
        
        <p>${message}</p>
    </body>
</html>
