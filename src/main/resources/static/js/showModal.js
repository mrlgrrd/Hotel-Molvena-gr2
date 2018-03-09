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

	modaltext = "Edit";
	$("#updateModalHeader").text(modaltext+":");

	$('.countryselect').prop('disabled',false);
	$('.form-control').prop('readonly', false);

	showGuestModal(id);

	var generateButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancel</button>"+
	"<button type='button' class='btn btn-info' data-dismiss='modal' onclick='updateGuest("+id+");'>"+modaltext+"</button>";

	$("#buttonsupdatemodal").html(generateButtons);
}

function showModalAddGuest(){

	removeBookingTable();

	var modaltext

		modaltext = "Submit";
		$("#updateModalHeader").text(modaltext+":");



	$('.countryselect').prop('disabled',false);
	$('.form-control').prop('readonly', false);

	var id = null;
	showGuestModal(id);

	var generateButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>"+
	"<button type='button' class='btn btn-success' data-dismiss='modal' onclick='addGuest();'>"+modaltext+"</button>";

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

function makeBookingTable(){
	var bookingtable = "<table style='width:100%' class='table table-striped'><thead><tr>"
	+"<th>Booking ID</th>"
	+"<th>From</th>"
	+"<th>Till</th>"
	+"<th>Guest ID</th>"
	+"<th>First name</th>"
	+"<th>Last name</th>"
	+"<th>Rooms</th>"
	+"</tr>"
	+"</thead>"
	+"<tbody id='bookings'>"
	+"</tbody>"
	+"</table>";

	$("#bookingtable").html(bookingtable);
}

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
                        bookingString = bookingString+ "<td> " + roomString + "</td>";

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

function removeBookingTable(){
    $("#bookingtable").html("")
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