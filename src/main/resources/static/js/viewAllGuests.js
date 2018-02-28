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
                    "</th><th><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateRoomModal' onclick='javascript:updateRoom("
                    +current.id+")'>Update Room</button></th><th><button type='button' class='btn btn-danger' onclick='javascript:deleteGuest("
                    +current.id+")'>Delete Guest</button></th></tr>";

                guestList = guestList + guestString;

            });

            $("#guests").html(guestList);
        }
    });


}

//Omwerken naar guest
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

$(document).ready(function(){
    getGuests();

})

function updateRoom(nr){

    var inputRoomType = Number($("#roomType"));

    var newRoom = {
        number : nr,
        roomType : inputRoomType
        };

    var newRoomJson = JSON.stringify(newRoom);

    $.ajax({
        url : "http://localhost:8080/api/controller/updateroom?number=" + nr,
        type : "update",
        data : newRoomJson,
        contentType : "application/json",
        success : function(data){
            console.log(newRoomJson);

        rooms.updateRoom(current.number, current.roomType);
        }

    });

}