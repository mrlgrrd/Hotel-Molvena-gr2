function getGuests(){
    // ajax is een methode voor get/post requests
    $.ajax({
        // waar moet hij de request op uitvoeren
        url : "http://localhost:8080/api/guestcontroller/allguests",
        // type actie
        type : "get",
        // als de actie lukt, voer deze functie uit
        success: function(data){

        	var guestList = "";

        	$.each(data, function(index, current){
        		var nationality
        		if(current.nationality == null){
        			nationality = "";
        		} else {
        			nationality = current.nationality;
        		}

        		guestString = composeGuestString(current);

        		guestList = guestList + guestString;

        	});

        	$("#guests").html(guestList);
        }
    });
}

function removenull(input){
	if(input == null){
		return "";
	} else {
		return input;
	}
}

$(document).ready(function(){
	getGuests();
})