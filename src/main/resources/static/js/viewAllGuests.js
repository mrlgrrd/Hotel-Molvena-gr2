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
                var guestString = "<tr> <th>" + current.firstname + "</th> <th>  " + current.preposition + "</th> <th> " +
                    current.lastname + "</th> <th> " +
                    current.city + "</th> <th> " + current.country + "</th> <th> " + current.phone + "</th> <th> " +
                    current.email + "</th> <th><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalReadOnly("
                    +current.id+")'>See details</button></th><th><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalUpdate("
                    +current.id+")'>Update Guest</button></th><th><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteGuestModal' onclick='javascript:showDeleteModal("
                    +current.id+")'>Delete Guest</button></th></tr>";

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

    $("#buttonsupdatemodal").html("");
}

function showGuestModalUpdate(id){
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
    else {
    $.ajax({
        url : "http://localhost:8080/api/guestcontroller/findguest?id=" + id,
        type : "get",
        success: function(data){

            console.log(data);
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
                   var guestString = "<tr> <th>" + current.firstname + "</th> <th>  " + current.preposition + "</th> <th> " +
                                       current.lastname + "</th> <th> " +
                                       current.city + "</th> <th> " + current.country + "</th> <th> " + current.phone + "</th> <th> " +
                                       current.email + "</th> <th><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalReadOnly("
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