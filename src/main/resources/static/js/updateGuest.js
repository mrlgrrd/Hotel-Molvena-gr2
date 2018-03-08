function updateGuest(guest_id){

	console.log(guest_id);

	var updateGuest = getGuestDetails(guest_id);

        console.log(updateGuest);



        //Communicate with Java
        $.ajax({
        	url : "http://localhost:8080/api/guestcontroller/updateguest/"+guest_id,
        	type : "put",
        	data : updateGuest,
        	contentType: "application/json",
        	success : function(guest_id,data){
        		getGuests();
                //Maak de velden leeg
                $("#fname").val("");
                $("#preposition").val("");
                $("#lname").val("");
                $("#address").val("");
                $("#zipcode").val("");
                $("#city").val("");
                $("#country").val("");
                $("#phone").val("");
                $("#email").val("");
                $("#passportnr").val("");
                $("#nationality").val("");

            }
        })



}