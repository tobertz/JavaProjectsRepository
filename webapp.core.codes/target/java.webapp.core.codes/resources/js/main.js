jQuery.extend (
    jQuery.expr[':'].containsCI = function (a, i, m) {
        //-- faster than jQuery(a).text()
        var sText   = (a.textContent || a.innerText || "");     
        var zRegExp = new RegExp (m[3], 'i');
        return zRegExp.test (sText);
    	
    	//return jQuery.trim(jQuery(a).text()).toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
    }
);

function getInspectionDate(dateStr){
//	var dateStr = "Fri Jan 11 13:24:27 GMT+08:00 2013"; //FOR TESTING
	
	var date;
	if(typeof(dateStr)=='undefined' || dateStr==null ){
		date = new Date();
	}else{
		if(dateStr.indexOf('GMT')>=0){
			var s1 = dateStr.substr(0, dateStr.indexOf('GMT'));
			var s2 = dateStr.substr(dateStr.indexOf('GMT')+10);
			dateStr = s1+s2;
		}
		
		date = new Date(dateStr);
	}
	var time = date.getHours()+date.getMinutes()+date.getSeconds()+date.getMilliseconds();
	
//	//SHIFT is from 7AM to < 7AM (6:59:59 999)
//	if(time>0 && date.getHours()<7){
//		date.setDate(date.getDate()-1);
//	} 
	
	var month;
	try{
		month = date.getMonthName(true);
	}catch(e){
		alert('The script "/resources/js/datepicker/date.js" has not been included in your page!');
		month = 'XXX';
	}
	
	var min = date.getMinutes() < 10 ? '0'+date.getMinutes() : date.getMinutes();
	var hours = date.getHours() < 10 ? '0'+date.getHours() : date.getHours();
	var seconds = date.getSeconds() < 10 ? '0'+date.getSeconds() : date.getSeconds();
	return date.getDate()+'-'+month+'-'+date.getFullYear() + ' ' + hours + ':' + min + ':' +  seconds;
//	return date.getDate()+'-'+month+'-'+date.getFullYear();
}

function loadScripts(scripts){
	var contextPath = jQuery('#contextPath').val();
	var length = scripts.length;
	for(var i=0; i<length; i++){
		var script = contextPath+scripts[i];
		var ant = $('script[src="'+script+'"]').length;
		
		if(ant == 0) {
			var em = document.createElement('script');
			em.type = 'text/javascript';
			em.async = true;
			em.src = script;
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(em, s);
		}
	}
}	