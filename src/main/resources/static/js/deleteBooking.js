function showDeleteModal(id){

	console.log("Ik zit in showdeletemodal")

	$.ajax({
		url : "http://localhost:8080/api/bookingcontroller/findbooking/" + id,
		type : "get",
		success: function(data){

			var firstname = data.id;
			var lastname = data.id;

            $("#textdeletemodal").text("Are you sure you want to delete "+firstname+" "+lastname+" out of the system?");


                var generateButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>"+
                "<button type='button' class='btn btn-danger' data-dismiss='modal' onclick='deleteBooking("+id+");'>Delete booking</button>";

                $("#buttonsdeletemodal").html(generateButtons);
            }
        })

}

function deleteBooking(id){
	console.log(id);
	$.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/bookingcontroller/deletebooking/" + id,
            // type actie
            type : "delete",
            // als de actie lukt, voer deze functie uit
            success : function(id){
            	showBookingList();
            }
        });

}