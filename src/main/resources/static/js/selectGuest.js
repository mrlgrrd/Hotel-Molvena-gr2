function composeGuestString(current){
	var guestString = "<tr> <th>" + removenull(current.firstname) + "</th> <th>  " + removenull(current.preposition) + "</th> <th> " +
	removenull(current.lastname) + "</th> <th> " +
	removenull(current.city) + "</th> <th> " + removenull(current.country) + "</th><th><button type='button' class='btn btn-info' onclick='javascript:selectGuest("
    +current.id+")'>Select Guest</button></th><th><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalReadOnly("
	+current.id+")'>See details</button></th></tr>";

	return guestString;
}

function showchooseroom(){
    $("#containersearchguest").hide();
    $("#containersearchroom").show();
}

function showaddguest(){
    $("#containersearchguest").show();
    $("#containersearchroom").hide();

    //Haal de waardes van rooms op
}

function selectGuest(id){

    $.ajax({
    	url : "http://localhost:8080/api/guestcontroller/findguest?id=" + id,
    	type : "get",
    	success: function(data){
    	    var personString;
    			if(data.preposition == null){
    			    personString = data.firstname + " " + data.lastname;
    			} else {
    			    personString = data.firstname + " " + data.preposition + " " + data.lastname;
    			}
    			$("#guest").text(personString);
    			console.log(personString);
    			$("#guestid").text(data.id);


    	}
    })

}

function makeGuestBooking(){
    showModalAddGuest();
    var generateButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>"+
    	"<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='addSelectGuest();'>Add guest</button>";

    	$("#buttonsupdatemodal").html(generateButtons);
}

function addSelectGuest(){

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
                        findLastEntry();

                    }
                })
    }

function findLastEntry(){
// ajax is een methode voor get/post requests
    $.ajax({
        // waar moet hij de request op uitvoeren
        url : "http://localhost:8080/api/guestcontroller/findlastentry",
        // type actie
        type : "get",
        // als de actie lukt, voer deze functie uit
        success: function(data){

        	var personString;
                			if(data.preposition == null){
                			    personString = data.firstname + " " + data.lastname;
                			} else {
                			    personString = data.firstname + " " + data.preposition + " " + data.lastname;
                			}
                			$("#guest").text(personString);
                			console.log(personString);
                			$("#guestid").text(data.id);
        }
    });
}

function makeGuestBooking(){

    var id = $("#guestid").text();
    console.log(id);
    $.ajax({
        	url : "http://localhost:8080/api/guestcontroller/findguest?id=" + id,
        	type : "get",
        	success: function(data){

                makeBooking(data);
                console.log(data);

        	}
        })
}

function makeBooking(bookingGuest){

        var bookingObject = {
                	guest : bookingGuest,
                	desiredPeriodFrom : null,
                };

        var booking = JSON.stringify(bookingObject);

        console.log(bookingGuest);
        console.log(bookingObject);


        //Communicate with Java
        $.ajax({
        	url : "http://localhost:8080/api/bookingcontroller/newbooking/"+booking,
        	type : "post",
        	data : booking,
        	contentType: "application/json",
        	success : function(){

                    }
                })

    }