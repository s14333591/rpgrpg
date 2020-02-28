//実行中フラグ
var run = false;

//ボスフラグ
var boss = false;
var src = $('img').attr('src');
if(src == 'img/enemy_999.gif')
	boss = true;



//こうげき、まほう
$(function(){
    $('.attack, .magic').on('click',function(){

    	//実行中だと処理を行わない
    	if(run)
 		   return false;
    	run = true;

    	var magicId =  0;
    	if($(this).attr("class") == 'magic')
    		magicId =  $(this).attr("id");

        $.ajax({
            url:'./attack',
            type:'POST',
            data:{"magicId":magicId},
            dataType:"json",
            success: function(bi){
            	//メッセージ表示
            	$('.magics').hide();
        		$(".messages").html("<p>" + bi.context[0] +"</p>");
            	for (var i = 1, l = bi.context.length; i < l; ++i) {
        			$(".messages").append("<p>" + bi.context[i] +"</p>");
            	}

            	//ユーザーHP表示
            	$(".userHp").html(bi.userHp);
            	//ユーザーMP表示
            	$(".userMp").html(bi.userMp);

            	switch(bi.status){

        		case "continue":
        			setTimeout(function(){
            			$(".messages").html("<p>どうする？<p>");
            			run = false;
            		},1500);
        			break;

        		case "win":
        			//敵画像を非表示
        			$('.enemyWindow img').css('display','none');

        			setTimeout(function(){
        				if(bi.isLvUp){
        					//ユーザーLV表示
        	            	$(".userLv").html(bi.nextLv.lv);
                    		$(".messages").html(bi.lvUpContext);
                    		setTimeout(function(){
                    			//画面遷移
                    			if(boss)
                    				window.location.href = "/clear";
                    			else
                    				window.location.href = "/home";
            				},4000);
                    	}else{
                    		//画面遷移
                			if(boss)
                				window.location.href = "/clear";
                			else
                				window.location.href = "/home";
                    	}
            		},2300);
        			break;

        		case "lose":
        			setTimeout(function(){
            			$(".messages").html("<p>まけてしまった...<p>");
            		},1500);
            		setTimeout(function(){
            			//ホームへ遷移
            			window.location.href = "/home";
            		},4000);
            		break;
            	}
            }
        })
    });
});



//ぼうぎょ
$(function(){
    $('.defense').on('click',function(){
    	//実行中だと処理を行わない
    	if(run)
 		   return false;
    	run = true;
        $.ajax({
            url:'./defense',
            type:'POST',
            dataType:"json",
            success: function(bi){
            	//メッセージ表示
            	$('.magics').hide();
        		$(".messages").html("<p>" + bi.context[0] +"<p>");
            	for (var i = 1, l = bi.context.length; i < l; ++i) {
        			$(".messages").append("<p>" + bi.context[i] +"<p>");
            	}

            	//ユーザーHP表示
            	$(".userHp").html(bi.userHp);

            	if(bi.status == "continue"){
            		//戦闘続行
            		setTimeout(function(){
            			$(".messages").html("<p>どうする？<p>");
            			run = false;
            		},1500);
            	}else{
            		//戦闘不能
            		setTimeout(function(){
            			$(".messages").html("<p>まけてしまった...<p>");
            		},1500);
            		setTimeout(function(){
            			//ホームへ遷移
            			window.location.href = "/home";
            		},4000);
            	}
            }
        })
    });
});

//にげる
$(function(){
    $('.home').on("click",function() {
    	//実行中だと処理を行わない
    	if(run)
    		return false;
			//ホームへ遷移
		window.location.href = "/home";
   });
});



//まほう一覧表示
$(function(){
    $('.magicList').on("click",function() {
    	//実行中だと処理を行わない
    	if(run)
    		return false;
      $(".messages").html("");
      $('.magics').show();
   });
});



