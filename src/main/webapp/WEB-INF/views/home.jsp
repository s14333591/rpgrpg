<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <title>勇者の冒険</title>
    <link rel="stylesheet" type="text/css" href="css/home.css" />
    <link
      href="https://fonts.googleapis.com/css?family=Noto+Sans+JP:400,700&amp;subset=japanese"
      rel="stylesheet"
    />
  </head>
  <body class="body">
    <section>
      <ul>
        <li>
          <div class="hpmpWindow">
            <ul>
              <li>
                <p>HP：${fn:escapeXml(user.hp)}</p>
              </li>
              <li>
                <p>MP：${fn:escapeXml(user.mp)}</p>
              </li>
            </ul>
          </div>
          <div class="iconWindow">
            <img
            src="img/weapon_0${fn:escapeXml(role.id)}.png"
                  width="130px"
                  height="160px"
                  class="weapon"
                  />
                  <img src="img/person.png" width="200px" height="200px" />
                </div>
                <div class="menuWindow">
                  <div class="message">
                 	<p class="errMsg">${errMsg}</p>
                    <p class="saveMsg">セーブしました</p>
                  </div>
                  <ul>
                    <li><a href="battle?name=usual">せんとう</a></li>
                    <li><a href="battle?name=boss">ボス</a></li>
                  <li><a href="rest">やすむ</a></li>
                  <li><a href="changeRole">てんしょく</a></li>
                  <li><a href="#" class="save">セーブ</a></li>
                    <li><a href="edit">へんしゅう</a></li>
                    <li><a href="index" name="logout">おわる</a></li>
                  </ul>
                </div>
              </li>
              <li>
                <div class="statusWindow">
                  <ul>
                    <li><p>なまえ</p></li>
                    <li><p>しょくぎょう</p></li>
                    <li><p>LV</p></li>
                    <li><p>さいだいHP</p></li>
                    <li><p>さいだいMP</p></li>
                    <li><p>ちから</p></li>
                    <li><p>かしこさ</p></li>
                    <li><p>ぼうぎょ</p></li>
                    <li><p>すばやさ</p></li>
                    <li><p>おかね</p></li>
                    <li><p>つぎのLVまで</p></li>
                  </ul>
                  <ul>
                    <li><p>${fn:escapeXml(user.name)}</p></li>
                    <li><p>${fn:escapeXml(role.name)}</p></li>
                    <li><p>${fn:escapeXml(user.lv)}</p></li>
                    <li><p>${fn:escapeXml(user.maxHp)}</p></li>
                    <li><p>${fn:escapeXml(user.maxMp)}</p></li>
                    <li><p>${fn:escapeXml(user.power)}</p></li>
                    <li><p>${fn:escapeXml(user.intelligence)}</p></li>
                    <li><p>${fn:escapeXml(user.defense)}</p></li>
                    <li><p>${fn:escapeXml(user.speed)}</p></li>
                    <li><p>${fn:escapeXml(user.gold)}G</p></li>
                    <li><p>${fn:escapeXml(nextLv.needXp - user.xp)}XP</p></li>
                  </ul>
                </div>
              </li>
            </ul>
          </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/fadeInOut.js"></script>
    <script type="text/javascript">
        $(function(){
            $('.save').on('click',function(){
                $.ajax({
                    url:'./save',
                    type:'POST',
                    data:{
                    }
                })
            });
        });
    </script>
  </body>
</html>
