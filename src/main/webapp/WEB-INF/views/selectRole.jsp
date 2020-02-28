<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>勇者の冒険</title>
    <link rel="stylesheet" type="text/css" href="css/selectRole.css">
</head>
<body class="body">
    <section class="main">
        <h1>しょくぎょうをえらんでください</h1>
        <ul>
            <li>
                <label>
                    <input type="radio" name="role" id="role" value="1" checked>
                    せんし
                    <img src="img/axe.png" width="72px" height="72px">
                 </label>
            </li>
            <li>
                <label>
                    <input type="radio" name="role" id="role" value="2">
                    まほうつかい
                    <img src="img/cane.png" width="72px" height="77px" class="cane">
                </label>
            </li>
            <a class="return" href="input" class="link">
                <img src="img/return.png" alt="#" width="50px" height="50px">
                <p>もどる</p>
            </a>
            <a class="confirm" href="home" class="link">
                <img src="img/confirm.png" alt="#" width="50px" height="50px">
                <p>きまり</p>
            </a>
        </ul>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/fadeInOut.js"></script>
</body>
</html>