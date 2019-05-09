/**
 * 
 */
function showTime(){
    nowtime=new Date();
    year=nowtime.getFullYear();
    month=nowtime.getMonth()+1;
    date=nowtime.getDate();
    document.getElementById("timedate").innerText=year+"年"+month+"月"+date+" "+nowtime.toLocaleTimeString();
    
}
setInterval("showTime()",1000);


$(".leftsidebar_box dt").css({
	"background-color" : "#3992d0"
});
$(".leftsidebar_box dt img").attr("src", "images/left/select_xl01.png");
$(function() {
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function() {
		$(".leftsidebar_box dt").css({
			"background-color" : "#3992d0"
		})
		$(this).css({
			"background-color" : "#317eb4"
		});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src", "images/left/select_xl01.png");
		$(this).parent().find('img').attr("src", "images/left/select_xl.png");
		$(".menu_chioce").slideUp();
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
})