jQuery(document).ready(function(){
	var selectedChkBox = new Array();
	Date.firstDayOfWeek = 0;
	Date.format = 'mm/dd/yyyy';
	
	jQuery('.date-pick').datePicker({clickInput:true,startDate:'01/01/1996'});
	jQuery('#updateJoborder_joborder_dateEntered').datePicker({startDate:'01/01/1996',clickInput:true});
	

	jQuery('.deleteButton').click(function() {
		 jQuery("input:checkbox[name=chkOption]:checked").each(function() {
			selectedChkBox.push(jQuery(this).attr('value'));
		 });
		
		 var form = jQuery(this).closest("form");
		 var href = jQuery(this).attr("href");	
		 
		 if(selectedChkBox.length == 0){
			 alert("Please select item on checkbox");
			 return false;
		 }
		 
		 confirmed = window.confirm("Click OK to continue delete. Click Cancel to stop.");
		 if (confirmed)
		 {
			 if(href != null){
				 form.attr("action",href);
			 }

		 	return true;
		 } 
		 return false;
	});
	

	
	jQuery(".updateButton").click(function(){
		selectedChkBox = new Array();
		
		jQuery("input:checkbox[name=chkOption]:checked").each(function() {
			selectedChkBox.push(jQuery(this).attr('value'));
		});
		var href = jQuery(this).attr("href");
		if(selectedChkBox.length > 1){
			alert("Please select only one item");
		}else if(selectedChkBox.length == 0){
			alert("Please select an item");
		}else{
			window.location.href=href+selectedChkBox[0];
		}
		return false;
	});
	
	jQuery(".addButton").click(function(){
		var href = jQuery(this).attr("href");
		window.location.href=href;
		return false;
	});
	
	
});

var timeout         = 500;
var closetimer		= 0;
var ddmenuitem      = 0;