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
    <link rel="stylesheet" type="text/css" href="css/edit.css">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP:400,700&amp;subset=japanese" rel="stylesheet">
</head>
<body class="body">
    <div class="errorMsg">
        <p>${errMsgEdit}</p>
    </div>
    <section>
        <form:form action="home" method="post" id="edit" modelAttribute="edit">
            <ul class="user__info">
                <li>
                    <p>なまえ</p>
                    <div class="errorMsg">
                        <p><form:errors path="userName" /></p>
                    </div>
                    <form:input type="text" path="userName" maxlength="5"/>
                </li>
                <li>
                    <p>あんごう</p>
                    <div class="errorMsg">
                        <p><form:errors path="password" /></p>
                    </div>
                    <form:input type="password" path="password" />
                </li>
                <li>
                    <p>あんごう(かくにん)</p>
                    <div class="errorMsg">
                        <p><form:errors path="rePassword" /></p>
                    </div>
                    <form:input type="password" path="rePassword" />
                </li>
            </ul>
        </form:form>
        <div class="return">
            <a href="home" name="edit">
                <img src="img/return.png" alt="#" width="50px" height="50px">
                <p>もどる</p>
            </a>
        </div>
        <div class="confirm">
            <button type="submit" form="edit" name="edit">
                <img src="img/confirm.png" alt="#" width="50px" height="50px">
                <p>きまり</p>
            </button>
        </div>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/fadeInOut.js"></script>
</body>
</html>
