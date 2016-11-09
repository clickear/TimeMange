<%@ page import="java.util.Date" %>
<%@page contentType="text/html; utf-8" pageEncoding="utf-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href='./scripts/libs/calendra/fullcalendar.css' rel='stylesheet' />
    <link href='./scripts/libs/calendra/fullcalendar.print.css' rel='stylesheet' media='print' />
    <link href="./theme/login.css" rel="stylesheet"/>
    <script src='./scripts/libs/moment.min.js'></script>
    <script src='./scripts/libs/jquery.min.js'></script>
    <script src='./scripts/libs/calendra/fullcalendar.js'></script>

    <style>
        .git{
            position: absolute;
            left: 150px;
            background-image: url('./images/github.png');
            background-position-x: -16px;
            background-position-y: -18px;
            width: 50px;
            height: 50px;
            border-radius: 85px;
            border: 1px solid #984949;
            margin-left: 10px;
            margin-right: 10px;
            text-align: center;
            display: inline-block;
        }
    </style>
</head>
<body>

<div class="LoginWindow">
    <div>
        <form method="post" action="http://www.jq22.com" onsubmit="return user_input()" class="login">
            <p>
                <label for="login">帐号:</label>
                <input type="text" name="login" id="login" value=""/>
            </p>
            <p>
                <label for="password">密码:</label>
                <input type="password" name="password" id="password" value="">
            </p>
            <p class="login-submit">
                <button type="submit" class="login-button">Login</button>

            </p>
            <a href="https://github.com/login/oauth/authorize?client_id=c774a0b7d7c450193689&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fcallback" class="git"></a>
        </form>


    </div>

</div>

</body>
</html>
