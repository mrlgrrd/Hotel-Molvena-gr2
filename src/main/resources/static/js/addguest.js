function addGuest(){

	var newGuest = getGuestDetails(null);


        //Communicate with Java
        $.ajax({
        	url : "http://localhost:8080/api/guestcontroller/addguest",
        	type : "post",
        	data : newGuest,
        	contentType: "application/json",
        	success : function(id,data){
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