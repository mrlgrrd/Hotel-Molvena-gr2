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

function showDeleteModal(id){

	console.log("Ik zit in showdeletemodal")

	$.ajax({
		url : "http://localhost:8080/api/guestcontroller/findguest?id=" + id,
		type : "get",
		success: function(data){

			var firstname = data.firstname;
			var preposition = data.preposition;
			var lastname = data.lastname;

                //In case of a preposition, it should be shown. Otherwise it shouldn't
                if(preposition == null){
                	$("#textdeletemodal").text("Are you sure you want to delete "+firstname+" "+lastname+" out of the system?");
                } else{
                	$("#textdeletemodal").text("Are you sure you want to delete "+firstname+" "+preposition+" "+" "+lastname+" out of the system?");
                }

                var generateButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>"+
                "<button type='button' class='btn btn-danger' data-dismiss='modal' onclick='deleteGuest("+id+");'>Delete guest</button>";

                $("#buttonsdeletemodal").html(generateButtons);
            }
        })

}

function deleteGuest(id){
	console.log(id);
	$.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/guestcontroller/deleteguest?id=" + id,
            // type actie
            type : "delete",
            // als de actie lukt, voer deze functie uit
            success : function(id){
            	getGuests();
            }
        });

}

function showGuestModalReadOnly(id){

	$('.countryselect').prop('disabled',true);
	$('.form-control').prop('readonly', true);

	$("#updateModalHeader").text("Details:");

	showGuestModal(id);

	var removeTable = findGuestBookings(id);
	console.log(removeTable);
	if(removeTable){
	    $("#bookingtable").html("");
	}

	$("#buttonsupdatemodal").html("");
}

function showGuestModalUpdate(id){

    removeBookingTable();

	var modaltext

	if(id == null){
		modaltext = "Add new guest";
		$("#updateModalHeader").text(modaltext+":");

	}
	else {
		modaltext = "Update guest";
		$("#updateModalHeader").text(modaltext+":");
	}

	$('.countryselect').prop('disabled',false);
	$('.form-control').prop('readonly', false);

	showGuestModal(id);

	var generateButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>"+
	"<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='updateGuest("+id+");'>"+modaltext+"</button>";

	$("#buttonsupdatemodal").html(generateButtons);
}

function showGuestModal(id){
	console.log(id);

	if (id == null){
		emptyInputFields();
	}
	else {
		$.ajax({
			url : "http://localhost:8080/api/guestcontroller/findguest?id=" + id,
			type : "get",
			success: function(data){
				fillInputFields(data);

			}
		})
	}


}

function updateGuest(guest_id){

	console.log(guest_id);

    //Get values from input texts
    var inputFirstname = $("#fname").val();
    var inputPreposition = $("#preposition").val();
    var inputLastname = $("#lname").val();
    var inputAddress = $("#address").val();
    var inputZipcode = $("#zipcode").val();
    var inputCity = $("#city").val();
    var inputCountry = $("#country").val();
    var inputPhone = $("#phone").val();
    var inputEmail = $("#email").val();
    var inputPassportnr = $("#passportnr").val();
    var inputNationality = $("#nationality").val();

        //Put in a object
        var updateGuestObject = {
        	id : guest_id,
        	firstname : inputFirstname,
        	preposition : inputPreposition,
        	lastname : inputLastname,
        	address : inputAddress,
        	zipCode : inputZipcode,
        	city : inputCity,
        	country : inputCountry,
        	phone : inputPhone,
        	email : inputEmail,
        	passportNumber : inputPassportnr,
        	nationality : inputNationality,
        };

        var updateGuest = JSON.stringify(updateGuestObject);

        console.log(updateGuest);

        //Communicate with Java
        $.ajax({
        	url : "http://localhost:8080/api/guestcontroller/addtoguest",
        	type : "post",
        	data : updateGuest,
        	contentType: "application/json",
        	success : function(data){
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
            		var guestString = "<tr> <th>" + removenull(current.firstname) + "</th> <th>  " + removenull(current.preposition) + "</th> <th> " +
            		removenull(current.lastname) + "</th> <th> " +
            		removenull(current.city) + "</th> <th> " + removenull(current.country) + "</th> <th> " + removenull(current.phone) + "</th> <th> " +
            		removenull(current.email) + "</th> <th><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalReadOnly("
            		+current.id+")'>See details</button></th><th><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalUpdate("
            		+current.id+")'>Update Guest</button></th><th><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteGuestModal' onclick='javascript:showDeleteModal("
            		+current.id+")'>Delete Guest</button></th></tr>";

            		guestList = guestList + guestString;

            	});

            	$("#guests").html(guestList);
            }
        });
}
}

$(document).ready(function(){
	getGuests();
})

function findGuestBookings(id){
	var removeTable = true;
	console.log("ben in de findguestbookings"+id)
    // ajax is een methode voor get/post requests
    $.ajax({
        // waar moet hij de request op uitvoeren
        url : "/api/bookingcontroller/findguestbookings/"+id,
        // type actie
        type : "get",
        // als de actie lukt, voer deze functie uit
        success: function(showBookingData){

        		var bookingList = "";
        		var makeTable = true;

        		$.each(showBookingData, function(bookingIndex, booking){
        			if(makeTable){
        				makeBookingTable();
        				makeTable = false;
        				removeTable = false;
        			}


        			var roomString = "";
        			var bookingString = "<tr> <td>" + booking.id + "</td> <td>  " + booking.desiredPeriodFrom + "</td> <td> " + booking.desiredPeriodTill + "</td> <td> " + booking.guest.id + "</td> <td> " + booking.guest.firstname + "</td> <td> " + booking.guest.lastname + "</td> ";

                        // geeft de data van de snowboards weer die bij de persoon horen (ManyToMany)
                        $.each(booking.rooms, function(roomIndex, room) {
                        	roomString = roomString + "#"+ room.id+ " " +room.theme +";          ";
                        });
                        bookingString = bookingString+ "<td> " + roomString + "</td>" + "<td><button type='button' class='btn btn-info'>Update Booking</button></th>" + "<th><button type='button' class='btn btn-danger'>Delete Booking</button></td></td>";

                        bookingList += bookingString;

                    });

        		$("#bookings").html(bookingList);
        		console.log(removeTable);
        		if(removeTable){
        		    removeBookingTable();
        		}
        	
        }
    });

};

function makeBookingTable(){
	var bookingtable = "<table style='width:100%' class='table table-striped'><thead><tr>"
	+"<th>Booking ID</th>"
	+"<th>From</th>"
	+"<th>Till</th>"
	+"<th>Guest ID</th>"
	+"<th>First name</th>"
	+"<th>Last name</th>"
	+"<th>Rooms</th>"
	+"<th>Update</th>"
	+"<th>Delete</th>"
	+"</tr>"
	+"</thead>"
	+"<tbody id='bookings'>"
	+"</tbody>"
	+"</table>";

	$("#bookingtable").html(bookingtable);
}

function removeBookingTable(){
    $("#bookingtable").html("")
}

function removenull(input){
	if(input == null){
		return "";
	} else {
		return input;
	}
}

function composeGuestString(current){
	var guestString = "<tr> <th>" + removenull(current.firstname) + "</th> <th>  " + removenull(current.preposition) + "</th> <th> " +
	removenull(current.lastname) + "</th> <th> " +
	removenull(current.city) + "</th> <th> " + removenull(current.country) + "</th> <th> " + removenull(current.phone) + "</th> <th> " +
	removenull(current.email) + "</th> <th><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalReadOnly("
	+current.id+")'>See details</button></th><th><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalUpdate("
	+current.id+")'>Update Guest</button></th><th><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteGuestModal' onclick='javascript:showDeleteModal("
	+current.id+")'>Delete Guest</button></th></tr>";

	return guestString;
}

function fillInputFields(data){
	$("#fname").val(data.firstname);
	$("#preposition").val(data.preposition);
	$("#lname").val(data.lastname);
	$("#address").val(data.address);
	$("#zipcode").val(data.zipCode);
	$("#city").val(data.city);
	$("#country").val(data.country);
	$("#phone").val(data.phone);
	$("#email").val(data.email);
	$("#passportnr").val(data.passportNumber);
	$("#nationality").val(data.nationality);
}

function emptyInputFields(){
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