/*
time://2013-3-15
texttip:弹出框  一般情况下不变
width:弹出的宽度
height:弹出的高度 可为空
left:弹出偏移量
positionleft：小图标（三角）左右偏移量
*/

jQuery.fn.popTip = function(params){
	var p = params || {
			texttip:'jjui_poptext',
			width:300,
			maxwidth:350,
			left:0,
			positionleft:50
	}; 
	var _width = p.width;
	var _height = p.height;
	var _left = p.left;
	var _positionleft = p.positionleft;
	var _maxwidth = p.maxwidth;
	var htm='<div id="jjui_poptext" style="position:absolute; display:none; color:#666;z-index:999;">'+	
				'<div style="border:1px solid #e7e7e7;box-shadow:#dfdede 0px 0px 5px; margin-top:-2px; border-radius: 5px; position:absolute;bottom: -100%;font-size:12px;background:#fff;width:auto;">'+
					'<div class="jjui_cornu" style="background:url(img/cornu.png) no-repeat left 1px;-left:100px; height:8px; line-height:8px; width:100%;z-index:1; position:absolute; bottom:-7px;left:0"></div>'+
					'<div class="jjui_content" style=" padding:10px;">'+					
					'</div>'+
					'<p class="jjui_bottom" style="color:#06a1ea;text-align:right;padding:0 6px 6px;display:none;"><a target="_blank" href="#" style="color:#06a1ea;">查看该品牌所有线路</a>&nbsp;&nbsp;</p>'+
					
				'</div>'+   
			'</div>'
	if(!$("#"+ p.texttip).attr('id')){
		$('body').append(htm);	
	}	
	$(this).hover(function(){			
			var datadase=$(this).attr('data-params');
			var k=eval('(' + datadase + ')');
			var h=$(this).height();
			var template={
					title_txt:'<h3 style="font-size:12px;color:#333; display:inline;">'+k.options.content.title+'</h3><p style="line-height:21px;display:inline;">'+k.options.content.txt+'</p>',
					txt:'<p>'+k.options.content.txt+'</p>'
			}
			if(!k.options.content.href){$("#"+ p.texttip).find('a').fadeOut();}
			else{$("#"+ p.texttip).find('a').text(k.options.content.thref).show().attr('href',k.options.content.href);}
			$("#"+ p.texttip).find('div.jjui_cornu').css({'background-position':_positionleft+'px 1px'});
			$("#"+ p.texttip).find('div.jjui_content').html(template[k.options.template]).css({'width':_width,'_width':_maxwidth,'height':_height,'max-width':_maxwidth});
			$("#"+ p.texttip).css({'left':$(this).offset().left-_positionleft+_left,'top':$(this).offset().top-10}).fadeIn();	
		},function(){			
			$("#"+ p.texttip).hide();
	});	
	$("#"+ p.texttip).hover(function(){	
			$("#"+ p.texttip).show();			
		},function(){
			$("#"+ p.texttip).hide();
	});
	
};
