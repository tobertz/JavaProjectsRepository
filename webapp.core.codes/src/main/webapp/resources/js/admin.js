/**
 * Author: Genevieve Lumague
 * Primesoft Philippines Inc
 * Date: 4/19/2013
 * Jquery document added for admin only functionalities
 * **/

	(function($) {
		  $.fn.sortAplhabetically = function(options){
			  		var settings = $.extend({}, {
			  			sortdir: 'asc'
						}, options);
			  
				    var $sort = this;
				    var $list = $(this);
				    var $listLi = $('li',$list);
				    $listLi.sort(function(a, b){
				        var keyA = $(a).text();
				        var keyB = $(b).text();
				        if($($sort).hasClass('asc')){
				            return (keyA > keyB) ? 1 : 0;
				        } else {
				            return (keyA < keyB) ? 1 : 0;
				        }
				    });
				    
				    if(settings.sortdir == 'desc'){
					    $.each($listLi, function(index, row){
					        $list.append(row);
					    });
				    }else{
				    	$.each($listLi, function(index, row){
					        $list.prepend(row);
					    });
				    }
		  };
	})(jQuery);


$(document).ready(function(){
	$("#55-sub ul").sortAplhabetically();
	
	/*main layout structure*/
	$("#bodyDiv").wrapInner("<div class='inner'/>").wrap("<div id='content'/>");
	$("#bodyDiv .inner #sideBar ~").wrapAll("<div id='innerContents'/>");
	$(".inner").append("<div class='clear'/>");
	$("#wrapper").append("<div id='footer'><div><div><div>&nbsp;</div></div></div></div>");
	
	/*main menu*/
	$("#menu > ul > li:has('ul') .label").append("<div class='menuRightArrow'/>");
	$("#menu > ul > li > div > ul", this).hide();
	$("#menu > ul > li").click(function(){ //$("#menu > ul > li .menuRightArrow").click(function(){
		$("#menu > ul > div > ul").hide();
		$('> div > ul', this).stop().slideToggle(); //$(this).parent().siblings("div").children("ul").stop().slideToggle();
		$(this).toggleClass("menuDownArrow");
	});
	
	/*add rounded borders - we place rounded corner images to make it work in lower versions of ie*/
	$("#innerContents .title").append("<div id='tr'/><div id='tl'/><div id='br'/><div id='bl'/>");
	$(".adminLightbox .lightboxHeader").append("<div id='tr'/><div id='tl'/>");
	$(".adminLightbox .lightboxButtons").append("<div id='br'/><div id='bl'/>");
	$(".formInput").append("<div id='tr'/><div id='tl'/><div id='br'/><div id='bl'/>");
	
	/*move paging to bottom*/
	$("#innerContents");
	$("#innerContents .pagelinks").appendTo("#innerContents");
	
	/*restructure pagination*/
	$("#innerContents").append("<div class='adminpagination'></div>");
	$(".pagelinks a, .pagelinks strong").clone().appendTo(".adminpagination");
	$(".pagelinks").hide();
	$(".adminpagination a").wrap("<span class='paginglink'/>");
	$(".adminpagination strong").wrap("<span class='paginglink activelink'/>");
	$(".adminpagination a:contains('First')").text("«");
	$(".adminpagination a:contains('Prev')").text("‹");
	$(".adminpagination a:contains('Last')").text("»");
	$(".adminpagination a:contains('Next')").text("›");
	
	
	/*close lightbox via x button on header*/
	$(".adminLightbox .lightboxHeader").append("<button class='closeLightbox'/>");
	$(".closeLightbox").click(function(){
		$('.adminLightbox').find('fieldset input').val('');
		$('.adminLightbox').trigger('close');
	});
	
	/*move password error message - addupdate user page only*/
	if($(".addUpdateUser").length > 0){
		if($(".system_error .flash").length > 0 && $(".system_error .flash:contains('Password')").length > 0){
			$(".system_error .flash").wrapInner('<span class="error" id="passwordError"/>');
			$("input#password").after($("#passwordError"));
		}
	}
	
	/*highlight table row on checkbox click*/
	$("td input[type=checkbox]").click(function(){
		if($(this).attr("checked") == true || $(this).attr("checked") == 'checked'){ 
			//$("table tr").removeClass("checkedRow");
			$(this).parent().parent().addClass("checkedRow");
		}else{
			$(this).parent().parent().removeClass("checkedRow");
		}
	});
	
	$("#partsMaster #row tr, #imageMaster #row tr").click(function(){
		$("#partsMaster #row tr").removeClass("checkedRow_dark");
		$("#imageMaster #row tr").removeClass("checkedRow_dark");
		
		$(this).addClass("checkedRow_dark");
	});
	
	$("#mrtrht tbody").css({height:'200px'});
	$("#mrtrht tbody").niceScroll();
	
	/*trigger lightbox pop up - must have applied class popupFrm and popupLnk*/
	$('.popupFrm').hide();
	$('.popupLnk').click(function(e){
		e.preventDefault();
		$('.popupFrm').lightbox_me({
	        centered: true,
	        overlayCSS: {background: 'black', opacity: .90},
	        onLoad: function() { 
	        	$('.popupFrm').show();
	        	$('.popupFrm').find('input:first').focus();
	        }
		});
	});
});
