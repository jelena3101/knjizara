$(document).ready(function() {
	var wrapper = $(".genre"); //Fields wrapper
	
	$(wrapper).on("click",".remove-field", function(e){ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove();
	})
});
