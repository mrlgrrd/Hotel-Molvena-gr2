function searchRoom(){
    var inputCheckIn = $("#checkIn").val();
    var inputCheckOut = $("#checkOut").val();
    var inputType = $("#roomType").val();
    var nrOfBeds = Number($("#nrOfBeds").val());
    var roomTheme = $("#roomTheme").val();

    var findRoom = {
        roomType : inputType,
        nrOfPeople : nrOfBeds,
        checkIn : inputCheckIn,
        checkOut : inputCheckOut,
        theme : roomTheme
        };

    var findRoomJson = JSON.stringify(findRoom);

    $.ajax({
            url : "http://localhost:8080/api/roomcontroller/selectroom",
            type : "post",
            data : findRoomJson,
            success: function(data){
                var foundRooms = "";

                $.each(data, function(index, current){

                var theme = "";
                var typeRoom = "";

                if(data.theme == null){
                    theme == ""}
                    else {theme = data.theme};

                if(data.roomType == "HONEYMOON"){
                    typeRoom = "Honeymoon"}
                    else if(data.roomType == "DELUXE"){
                        typeRoom = "Deluxe"}
                    else if (data.roomType == "STANDARD"){
                        typeRoom = "Standard"}

                var roomString = "<tr> <td>" + current.number + "</th> <td>  " + theme + "</th> <td>  " + typeRoom +"</th> <td> " + current.nrOfPeople + "</th> <td> ";

                foundRooms = foundRooms + roomString;
                });

            $("#availableRooms").html(foundRooms);

            }

    });

}