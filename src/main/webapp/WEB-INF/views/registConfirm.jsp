<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>勇者の冒険</title>
    <link rel="stylesheet" type="text/css" href="css/registConfirm.css">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP:400,700&amp;subset=japanese" rel="stylesheet">
</head>
<body class="body">
    <div class="title">
        <p>これでよろしいですか？</p>
    </div>
    <section>
        <form action="home"  method="post" id="regist">
            <ul class="list">
                <li>
                    <p>ID</p>
                </li>
                <li>
                    <p>なまえ</p>
                </li>
                <li>
                    <p>しょくぎょう</p>
                </li>
            </ul>
            <ul class="userInfo">
                <li>
                    <p>${fn:escapeXml(user.userId)}</p>
                </li>
                <li>
                    <p>${fn:escapeXml(user.name)}</p>
                </li>
                <li class="role">
                    <p>${fn:escapeXml(role.name)}</p>
                    <img src="img/weapon_0${fn:escapeXml(role.id)}.png" width="72px" height="72px">
                </li>
            </ul>
        </form>
        <div class="return">
            <a href="regist">
                <img src="img/return.png" alt="#" width="50px" height="50px">
                <p>もどる</p>
            </a>
        </div>
        <div class="confirm">
            <button type="submit" form="regist" name="regist">
                <img src="img/confirm.png" alt="#" width="50px" height="50px">
                <p>きまり</p>
            </button>
        </div>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/fadeInOut.js"></script>
</body>
</html>