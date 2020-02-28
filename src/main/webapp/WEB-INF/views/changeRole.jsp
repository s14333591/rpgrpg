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
    <link rel="stylesheet" type="text/css" href="css/changeRole.css">
    <link
      href="https://fonts.googleapis.com/css?family=Noto+Sans+JP:400,700&amp;subset=japanese"
      rel="stylesheet"
    />
</head>
<body class="body">
    <div class="title">
        <p>しょくぎょうをえらんでください</p>
    </div>
    <form action="home" method="post" id="changeRole">
	    <section class="main">
	        <ul>
	            <li>
	                <label>
	                    <div class="roleName">
	                        <input type="radio" name="role" id="role" value="1" checked>
	                        <p>せんし</p>
	                    </div>
	                    <img src="img/weapon_01.png" width="72px" height="72px">
	                 </label>
	            </li>
	            <li>
	                <label>
	                    <div class="roleName">
	                        <input type="radio" name="role" id="role" value="2">
	                        <p>まほうつかい</p>
	                    </div>
	                    <img src="img/weapon_02.png" width="72px" height="72px" class="cane">
	                </label>
	            </li>
	       	     <c:choose>
	            	<c:when test="${user.lv < 5}">
			            <li class="disabled">
			                <label>
			                    <div class="roleName">
			                        <input type="radio" name="role" id="role" value="0" disabled>
			                        <p>ゆうしゃ</p>
			                    </div>
			                    <img src="img/weapon_09.png" width="72px" height="72px" class="sord">
			                </label>
			                <p>※ LV5以上</p>
			            </li>
		            </c:when>
		            <c:otherwise>
					    <li>
			                <label>
			                    <div class="roleName">
			                        <input type="radio" name="role" id="role" value="3">
			                        <p>ゆうしゃ</p>
			                    </div>
			                    <img src="img/weapon_03.png" width="72px" height="72px" class="sord">
			                </label>
			            </li>
				  </c:otherwise>
	            </c:choose>
	        </ul>
	        <a class="return" href="home" class="link" name="changeRole">
	            <img src="img/return.png" alt="#" width="50px" height="50px">
	            <p>もどる</p>
	        </a>
	         <div class="confirm" class="link">
	            <button type="submit" form="changeRole" name="changeRole">
	                <img src="img/confirm.png" alt="#" width="50px" height="50px">
	                <p>きまり</p>
	            </button>
	        </div>
	    </section>
    </form>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/fadeInOut.js"></script>
</body>
</html>