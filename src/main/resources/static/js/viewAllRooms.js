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
                var roomString = "<tr> <th>" + current.number + "</th> <th>  " + current.roomType + "</th> <th> " + current.occupied + "</th> <th> " + current.isClean + "</th></tr>";

                roomList = roomList + roomString;

            });

            $("#rooms").html(roomList);
        }
    });
    });

}
$(document).ready(getRooms);