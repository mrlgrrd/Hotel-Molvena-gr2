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