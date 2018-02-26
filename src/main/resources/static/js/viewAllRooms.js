function getRooms(){
    // als de pagina geladen is, start deze functie
    $(document).ready(function(){

    // ajax is een methode voor get/post requests
    $.ajax({
        // waar moet hij de request op uitvoeren
        url : "http://localhost:8080/api/controller/showrooms",
        // type actie
        type : "get",
        // als de actie lukt, voer deze functie uit
        success: function(data){

            var roomList = "";

            $.each(data, function(index, current){

                var roomString = "<tr> <th>" + current.number + "</th> <th>  " + current.roomType + "</th> <th> " +
                current.occupied + "</th> <th> " + current.isClean +
                "</th><th><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateRoomModal' onclick='javascript:updateRoom(" +
                current.number+")'>Update Room</button></th> <th><button type='button' class='btn btn-danger' onclick='javascript:deleteRoom(" +current.number+
                ")'>Delete Room</button></th></tr>";
                var roomString = "<tr> <th>" + current.number + "</th> <th>  " + current.roomType + "</th> <th> " + current.occupied + "</th> <th> " + current.isClean + "</th><th><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateRoomModal' onclick='javascript:updateRoom(" +current.number+")' >Update Room</button></th> <th><button type='button' class='btn btn-danger' onclick='javascript:deleteRoom(" +current.number+")'>Delete Room</button></th></tr>";

                roomList = roomList + roomString;

            });

            $("#rooms").html(roomList);
        }
    });
    });

};

$(document).ready(getRooms);

function deleteRoom(nr){

    $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/controller/deleteroom?number=" + nr,
            // type actie
            type : "delete",
            // als de actie lukt, voer deze functie uit
            success: function(nr){
                rooms.deleteRoom(nr);
            }
        });

}

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
