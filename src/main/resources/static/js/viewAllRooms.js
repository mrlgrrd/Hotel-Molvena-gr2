

function getRooms(){
    // als de pagina geladen is, start deze functie
    $(document).ready(function(){

    // ajax is een methode voor get/post requests
    $.ajax({
        // waar moet hij de request op uitvoeren
        url : "http://localhost:8080/api/roomcontroller/showrooms",
        // type actie
        type : "get",
        // als de actie lukt, voer deze functie uit
        success: function(data){

            var roomList = "";

            $.each(data, function(index, current){
            console.log(current.clean);
            console.log(current.roomType);

                var roomString = "<tr> <td>" + current.number + "</th> <td>  " + current.roomType + "</th> <td> " + current.nrOfPeople + "</th> <td> " + current.occupied + "</td> <td> " + current.clean
                + "</td><td><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateRoomModal' data-id="+current.id+" >Update Room</button></th>"
                + "<th><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteGuestModal' + onclick='openDeleteModal("+current.id+")'>Delete Room</button></td></td>";

                roomList = roomList + roomString;

            });

            $("#rooms").html(roomList);
        }
    });
    });

};

$(document).ready(getRooms());

function openDeleteModal(idRoom){
    $("#deleteRoomModal").modal('show');
    var generateDeleteButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Close</button>"
                                +"<button type='button' class='btn btn-danger' onclick='deleteRoom("+idRoom+");'>Delete room</button>";

    $("#deleteModalFooter").html(generateDeleteButtons);
}

function deleteRoom(idRoom){

    $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/roomcontroller/deleteroom?id=" + idRoom,
            // type actie
            type : "delete",
            // als de actie lukt, voer deze functie uit
            success : function(idRoom){
                getRooms();
            }
        });
}

function updateRoom(roomId){

    var inputRoomType = Number($("#roomType"));

    var newRoom = {
        id : roomId,
        roomType : inputRoomType
        };

    var newRoomJson = JSON.stringify(newRoom);

    $.ajax({
        url : "http://localhost:8080/api/roomcontroller/updateroom?id=" + roomId,
        type : "update",
        data : newRoomJson,
        contentType : "application/json",
        success : function(data){
            getRooms();
        }

    });

}
