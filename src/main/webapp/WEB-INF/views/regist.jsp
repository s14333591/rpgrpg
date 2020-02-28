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
    <link rel="stylesheet" type="text/css" href="css/regist.css">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP:400,700&amp;subset=japanese" rel="stylesheet">
</head>
<body class="body">
    <div class="errorMsg">
        <p>${fn:escapeXml(msg)}</p>
    </div>
    <section>
        <form:form action="confirm" method="post" id="regist" modelAttribute="regist">
            <ul class="user__info">
                <li>
                    <p>ID</p>
                    <div class="errorMsg">
                        <p><form:errors path="userId" /></p>
                    </div>
                    <form:input path="userId"  maxlength="10"/>
                </li>
                <li>
                    <p>あんごう</p>
                    <div class="errorMsg">
                        <p><form:errors path="password" /></p>
                    </div>
                    <form:password path="password"/>
                </li>
                <li>
                    <p>あんごう(かくにん)</p>
                    <div class="errorMsg">
                        <p><form:errors path="passwordCheck" /></p>
                    </div>
                    <form:password path="passwordCheck" />
                </li>
                <li>
                    <p>なまえ</p>
                    <div class="errorMsg">
                        <p><form:errors path="name"/></p>
                    </div>
                    <form:input path="name"  maxlength="5"/>
                </li>
            </ul>
            <ul class="role">
                <p>しょくぎょう</p>
                <li>
                    <label>
                        <form:radiobutton path="roleId" value="1" checked="checked" />
                        <p>せんし</p>
                        <img src="img/weapon_01.png" width="72px" height="72px">
                     </label>
                </li>
                <li>
                    <label>
                        <form:radiobutton path="roleId" value="2" />
                        <p>まほうつかい</p>
                        <img src="img/weapon_02.png" width="72px" height="72px" class="cane">
                    </label>
                </li>
            </ul>

        <div class="return">
            <a href="index">
                <img src="img/return.png" alt="#" width="50px" height="50px">
                <p>もどる</p>
            </a>
        </div>
        <div class="confirm">
            <button type="submit" form="regist">
                <img src="img/confirm.png" alt="#" width="50px" height="50px">
                <p>きまり</p>
            </button>
        </div>
    </form:form>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/fadeInOut.js"></script>
</body>
</html>