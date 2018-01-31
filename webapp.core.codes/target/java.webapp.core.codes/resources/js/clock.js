/**
 *	Also include /datePicker/date.js in your jsp when using this.
 */

function showClock() {
	var date = new Date();
	var month;
	try{
		month = date.getMonthName(true);
	}catch(e){
		var clockStr = jQuery("#clock").html();
		if(typeof(clockStr)!='undefined' && clockStr.indexOf('XXX')<0){
			alert('The script "/resources/js/datepicker/date.js" has not been included in your page!');
		}
		month = 'XXX';
	}
	var day = date.getDate();
	var year = date.getFullYear();
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var seconds = date.getSeconds();
	var dn = "AM";
//	if (hours > 12) {
//		dn = "PM";
//		hours = hours - 12;
//	}
	if (hours == 0){
		hours = 12;
	}
	if (minutes <= 9){
		minutes = "0" + minutes;
	}
	if (seconds <= 9){
		seconds = "0" + seconds;
	}
	//alert(day);
	//jQuery("#clock").html(getMonthString(month)+" "+day+", "+year+" "+hours + ":" + minutes +":"+seconds+" "+ dn);
	//jQuery("#clock").html(getMonthString(month)+" "+day+", "+year+" "+hours + ":" + minutes);
	jQuery("#clock").html(month+" "+day+", "+year+" "+hours + ":" + minutes);
	setTimeout("showClock()", 100);
}
showClock();

function getMonthString(month){
	
	alert('Please use date.getMonthName() from "/resources/js/datepicker/date.js" instead of getMonthString() from clock.js');
	
	return 'XXX';
//	switch(month){
//	case 0 :
//		return "Jan";
//	case 1 :
//		return "Feb";
//	case 2 :
//		return "Mar";
//	case 3 :
//		return "Apr";
//	case 4 :
//		return "May";
//	case 5 :
//		return "Jun";
//	case 6 :
//		return "Jul";
//	case 7 :
//		return "Aug";
//	case 8:
//		return "Sep";
//	case 9 :
//		return "Oct";
//	case 10 :
//		return "Nov";
//	case 11 :
//		return "Dec";
//	}
}

