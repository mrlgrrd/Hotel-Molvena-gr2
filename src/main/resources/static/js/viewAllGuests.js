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
                var guestString = "<tr> <th>" + current.firstname + "</th> <th>  " + current.preposition + "</th> <th> " +
                    current.lastname + "</th> <th> " + current.address + "</th> <th> " + current.zipCode + "</th> <th> " +
                    current.city + "</th> <th> " + current.country + "</th> <th> " + current.phone + "</th> <th> " +
                    current.email + "</th> <th> " + current.passportNumber + "</th> <th> " + current.nationality +
                    "</th><th><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showModal("
                    +current.id+")'>Update Guest</button></th><th><button type='button' class='btn btn-danger' onclick='javascript:deleteGuest("
                    +current.id+")'>Delete Guest</button></th></tr>";

                guestList = guestList + guestString;

            });

            $("#guests").html(guestList);
        }
    });
}

function deleteGuest(id){
console.log(id);
    $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/guestcontroller/deleteguest?id=" + id,
            // type actie
            type : "delete",
            // als de actie lukt, voer deze functie uit
            success: function(id){
                getGuests();
            }
        });

}

function showModal(id){


    console.log(id);

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

    var generateButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>"+
                                "<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='updateRoom("+id+");'>Save changes</button>";

    $("#buttonsmodal").html(generateButtons);

//    var inputRoomType = Number($("#roomType"));
//
//    var newRoom = {
//        number : nr,
//        roomType : inputRoomType
//        };
//
//    var newRoomJson = JSON.stringify(newRoom);
//
//    $.ajax({
//        url : "http://localhost:8080/api/controller/updateroom?number=" + nr,
//        type : "update",
//        data : newRoomJson,
//        contentType : "application/json",
//        success : function(data){
//            console.log(newRoomJson);
//
//        rooms.updateRoom(current.number, current.roomType);
//        }
//
//    });
}

function updateRoom(guest_id){

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

        getGuests();

}

$(document).ready(function(){
    getGuests();
})