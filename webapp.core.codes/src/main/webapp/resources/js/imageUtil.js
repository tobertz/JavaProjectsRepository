/**
 * Using this requires common.js
 */

var isIE = $.browser.msie;

/*
*	imgPath - path to source
*	mainImgId - id of destination
*/
function selectThisImg(imgPath, mainImgId, defaultImgCnt){
	jQuery('#'+mainImgId).attr('src', imgPath);
	if(typeof(defaultImgCnt)!=undefined){
		clearDefects(defaultImgCnt);
	}else{
		clearDefects();
	}
}

/*
*	event - event
*	divId - id of element enclosing the main image
*	defectCountId - id of element for defect count
*/
function addRemoveDefect(event, divId){
	if(divId==null || ''==divId){
		alert('Please provide the id of your main image');
		return false;
	}
	
	//positions of the mouse cursor
	var offset = jQuery('#'+divId).offset();
	
	//var pos_x = event.pageX-offset.left;
	//var pos_y = event.pageY-offset.top;
	
	//this will fix the tagging in ie7,ie8 browsers
	var pos_x = (event.clientX + document.body.scrollLeft + document.documentElement.scrollLeft) - offset.left;
	var pos_y = (event.clientY + document.body.scrollTop + document.documentElement.scrollTop) - offset.top;
	
	addDefectImg(pos_x, pos_y, divId);
	
	return true;
}

function clearDefects(defaultImgCnt){
	
	if(typeof(defaultImgCnt)=='undefined'){
		defaultImgCnt = '';
	}
	
	jQuery('img[id^=defect_]').remove();
	if(typeof(jQuery('[id^="defectCnt_"]'))!='undefined'){
		jQuery('.f_left .active').find('[id^="defectCnt_"]').html(defaultImgCnt);
	}
	
}

function addDefectImg(pos_x, pos_y, divId){
	var dotHalfWidth = typeof(jQuery('#dotHalfWidth'))!='undefined' ? jQuery('#dotHalfWidth').val():8;
	var dotHalfHeight = typeof(jQuery('#dotHalfHeight'))!='undefined' ? jQuery('#dotHalfHeight').val():8;
	var x = pos_x-dotHalfWidth;
	var y = pos_y-dotHalfHeight;
	
	//var z = jQuery(":img[id^=defect_]").length; //this will work in jquery ver 1.3
	var z = jQuery("img.defect").length; //use this for jquery library that is up to date.
	
	var div_width = jQuery('#'+divId).width();
	var div_height = jQuery('#'+divId).height();
	
	var image = jQuery('#'+divId).find('img:not([id^="defect_"])');
	var img_width = image.width();
	var img_height = image.height();
	var img_pos_x = pos_x-((div_width - img_width)/2);
	var img_pos_y = pos_y-((div_height - img_height)/2);
	
	var xRatio = img_pos_x/img_width*100;
	var yRatio = img_pos_y/img_height*100;
	
	var contextPath = jQuery('#contextPath').val();
	var dotImg = jQuery('#'+divId).html()+'<img id="defect_'+z+'" class="defect" onclick="jQuery(this).remove();renderDefectCount();"'
		+'X="'+xRatio+'" Y="'+yRatio+'" src="'+contextPath+'/image/dot.png" style="left: '+x
		+'px; top: '+y+'px; position: absolute; z-index: '+z+'; cursor: pointer;" />';
	
	if(isIE){
		jQuery('#'+divId).html(dotImg);
	}else{
		document.getElementById(divId).innerHTML = dotImg;
	}
}

/**
 * Returns the coordinates as a string.
 * Format is <X1>_<Y1>,<X2>_<Y2> 
 * @returns {String}
 */
function getDefectCoordinates(div_id){
	var coord = '';
	
	var length = jQuery('#'+div_id+' img[id^="defect_"]').length;
	jQuery('#'+div_id+' img[id^="defect_"]').each(function(index){
		var x = jQuery(this).attr('X');
		var y = jQuery(this).attr('Y');
		
		coord += x+'_'+y;
		if(index!=(length-1)){
			coord += ',';
		}
	});
	return coord;
}

/*
*	Checks if there is an existing defect image in the given coordinates.  Removes it if there is.
*/
function removeDefectImg(x, y){
	
	var hasDefect = false;
	jQuery(':img[id^=defect_]').filter(function(){
		var left = jQuery(this).position().left;
		var top = jQuery(this).position().top;
		if(!hasDefect &&(x >= left && x <= left+21) && (y >= top && y <= top+22)){
			jQuery(this).remove();
			hasDefect = true;
		}
		return ((x >= left && x <= left+21) && (y >= top && y <= top+22));
	}).length;
	
	return hasDefect;
}