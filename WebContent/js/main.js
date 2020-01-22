$(function(){
	   menuHeader();
	   mainvisual();

	function menuHeader(){
	   $('#headerWrap .menu').hover(function(){
	      $('#headerWrap').addClass('on');
	      //$('#headerWrap .menuDepth').not($(this).next('.menuDepth')).stop().hide();
	      $('#headerWrap .menuDepth').not($(this).next('.menuDepth')).stop().hide();
	      $('.menuDepth').stop().slideDown('fast');
	      $('#headerWrap .bgDepth').stop().slideDown('fast');
			
	      //$('.menuDepth').show();
	      //$('#headerWrap .bgDepth').show();
	      
	   });
	   
	   $('#headerWrap .menu').mouseleave(function(){
		   $('.menuDepth').hide();
		      $('#headerWrap .bgDepth').hide();
		      $('#headerWrap').stop().removeClass('on');
	   });
	   
	};
	 	
	 	function mainvisual() {
	 		// left 메뉴 이벤트
	 		$('.main >.left ').hover(function () {
	 			idx = $('.main >div').index();
		 		$('.left >.textview').show();
				//$(this).addclass('on').siblings().addClass('off');
				$('.left >.textview').stop().slideDown('fast');
				$('.mainVisual  >div').eq(idx).addClass('show').stop().animate({'left' : '0', 'width' : '100%'},900).find('>span')
				.stop().animate({'left':'0'},900);
				$('.right >.textbox').hide();
				
			},function(){
				$('.left >.textview').hide();
				$('.mainVisual  >div').removeClass('show').stop().css('width','50%');
				$('.right >.textbox').show();
		 		
			});
	 		
	 		//right 메뉴 이벤트
		 	$('.main >.right').hover(function () {
		 		$('.right >.textview').show();
		 		idx = $('.main >div').index();
				//$(this).addclass('on').siblings().addClass('off');
				$('.mainVisual  >.right').addClass('show').stop().animate({'left' : '0', 'width' : '100%'},900).find('>span')
				.stop().animate({'left':0},900);
				$('.left >.textbox').hide();
				
			},function(){
				$('.right >.textview').hide();
				$('.mainVisual >.right').removeClass('show').stop().css({'width':'50%','left':'50%'});
				$('.left >.textbox').show();
			});
		
			
	   
	}
	

	});