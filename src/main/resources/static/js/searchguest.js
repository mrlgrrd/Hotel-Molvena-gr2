function searchguest(){
	var input = $("#searchGuest").val();
	console.log(input);

	if(input == ""){
		getGuests();
	} else {
    // ajax is een methode voor get/post requests
    $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/guestcontroller/searchguest/" + input,
            // type actie
            type : "get",
            // als de actie lukt, voer deze functie uit
            success: function(data){

            	var guestList = "";

            	$.each(data, function(index, current){
            		var guestString = composeGuestString(current);

            		guestList = guestList + guestString;

            	});

            	$("#guests").html(guestList);
            }
        });
}
}