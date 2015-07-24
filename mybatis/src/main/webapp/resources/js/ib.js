$(function() {

	$(".page").height($(window).height() - 101);
	$(".content").height($(window).height() - 265);
	$(".caveat").width($(window).width() - 410);

	// 模拟滚动条
	$(".content").niceScroll({
		touchbehavior : false,
		cursorcolor : "#3c3c3c",
		cursoropacitymax : 0.4,
		cursorwidth : 8,
		cursorborderradius : 4,
		autohidemode : false
	});

	$(window).resize(function() {
		$(".page").height($(window).height() - 101);
		$(".content").height($(window).height() - 265);
		$(".caveat").width($(window).width() - 410);
	});

	if ($(".fp_03 .xuan span").length > 0) {
		$(".fp_03 .xuan span").click(
				function() {
					$(this).parents(".fp_03").find(".xuan").find("span")
							.removeClass("on");
					$(this).addClass("on");
				});
	}

	$(".tip_icon").hover(function() {
		$(this).find(".tipMain").animate({
			bottom : "30px",
			opacity : "show"
		}, 500);

	}, function() {
		$(this).find(".tipMain").animate({
			bottom : "50px",
			opacity : "hide"
		}, 100);
	});

	function subHeight(name) {
		var winHeight = $(window).height();
		$(name).height(winHeight - 70);
	}
	subHeight(".submain");
	$(window).resize(function() {
		subHeight(".submain");
	});
	$(".submain").niceScroll({
		touchbehavior : false,
		cursorcolor : "#3c3c3c",
		cursoropacitymax : 0.7,
		cursorwidth : 5,
		background : "#54473f",
		autohidemode : true
	});

});