var guest_id;
var beginStay;
var endStay;
var roomids;

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
    			guest_id = id;
    			console.log(guest_id);


    	}
    })

}

function makeGuestBooking(){
    showModalAddGuest();
    var generateButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>"+
    	"<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='addSelectGuest();'>Add guest</button>";
        console.log("generate buttons");
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
        	success : function(data){
               guest_id = data.id;
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
                        var personString;
                        if(data.preposition == null){
                         personString = data.firstname + " " + data.lastname;
                     } else {
                         personString = data.firstname + " " + data.preposition + " " + data.lastname;
                     }
                     $("#guest").text(personString);
                     console.log(personString);
                     console.log(guest_id);

                 }
             })
    }

function makeBooking(){

        var bookingObject = {
                	desiredPeriodFrom : beginStay,
                	desiredPeriodTill : endStay,
                };

        var bookingModelObject = {
            booking : bookingObject,
            guestId : guest_id,
            roomIds : roomids,
        };

        var bookingModel = JSON.stringify(bookingModelObject);
        console.log(bookingModel);

        //Communicate with Java
        $.ajax({
        	url : "http://localhost:8080/api/bookingcontroller/newbooking",
        	type : "post",
        	data : bookingModel,
        	contentType: "application/json",
        	success : function(){

            }
        })

    }