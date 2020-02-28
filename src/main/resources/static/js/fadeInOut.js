// ページ全体フェードイン/アウト
$('head').append(
    '<style type="text/css">.body{display:none;}</style>'
  );

  $(window).on("load",function() {
    $('body').fadeIn(400).removeClass(".body");
  });

  $(window).on("pageshow",function() {
      if (event.persisted) {
          window.location.reload();
      }
  });

  $(function(){
      $('a.link').on("click",function() {
          var url = $(this).attr('href');
          if (url != '') {
              $('body').fadeOut(400);
              setTimeout(function(){
                   location.href = url;
              }, 0);
        }
        return false;
        });
    });

// ホーム画面、「セーブ」押下時のメッセージフェードイン/アウト
  $('.save').on('click', function(){
    $('.errMsg').hide();
    $('.saveMsg').fadeIn("slow", function () {
      $(this).delay(800).fadeOut("slow");
    });
  });

  $(function(){
		$('.errMsg').delay(2000).fadeOut("slow");
  });

 //バトル画面、ボスメッセージフェードアウト
  $('.arrow_question').delay(3000).fadeOut("slow");
