function getBookings(){
    // als de pagina geladen is, start deze functie
    $(document).ready(function(){

    // ajax is een methode voor get/post requests
    $.ajax({
        // waar moet hij de request op uitvoeren
        url : "http://localhost:8080/api/bookingcontroller/allbookings",
        // type actie
        type : "get",
        // als de actie lukt, voer deze functie uit
        success: function(data){

            var bookingList = "";

            $.each(data, function(index, current){

                var bookingString = "<tr> <td>" + current.guestID + "</th> <td>  " + current.roomID + "</th> <td> " + current.desiredPeriodFrom + "</td> <td> " + current.desiredPeriodTill + "</td><td><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateRoomModal' onclick='javascript:updateRoom(" +current.id+")' >Update Room</button></th> <th><button type='button' class='btn btn-danger' onclick='javascript:deleteRoom(" +current.id+")'>Delete Room</button></td></td>";

                bookingList = bookingList + bookingString;

            });

            $("#bookings").html(bookingList);
        }
    });
    });

};

$(document).ready(getBookings);

//function deleteRoom(roomId){
//
//     var deletableRoom = { id : roomId};
//
//    var delRoomJson = JSON.stringify(roomId);
//
//    $.ajax({
//            // waar moet hij de request op uitvoeren
//            url : "http://localhost:8080/api/roomcontroller/deleteroom?id=" + roomId,
//            // type actie
//            type : "delete",
//            contentType : "application/json",
//            data : delRoomJson,
//            // als de actie lukt, voer deze functie uit
//            success: function(data){
//               getRooms();
//            }
//        });
//
//}
//
//function updateRoom(roomId){
//
//    var inputRoomType = Number($("#roomType"));
//
//    var newRoom = {
//        id : roomId,
//        roomType : inputRoomType
//        };
//
//    var newRoomJson = JSON.stringify(newRoom);
//
//    $.ajax({
//        url : "http://localhost:8080/api/roomcontroller/updateroom?id=" + roomId,
//        type : "update",
//        data : newRoomJson,
//        contentType : "application/json",
//        success : function(data){
//            getRooms();
//        }
//
//    });
//
//}
