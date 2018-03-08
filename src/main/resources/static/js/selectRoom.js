function searchRoom(){
    var inputCheckIn = $("#checkIn").val();
    var inputCheckOut = $("#checkOut").val();
    var inputType = $("#roomType").val();
    var nrOfBeds = Number($("#nrOfBeds").val());
    var roomTheme = $("#roomTheme").val();

    console.log("input checkIn: " + inputCheckIn);

    var checkInList = inputCheckIn.split("-");
    var checkInObject = {
        dayOfMonth : checkInList[2],
        month : checkInList[1],
        year : checkInList[0]
    };

    var checkInJson = JSON.stringify(checkInObject);

    console.log("checkoutn: "+ inputCheckOut);
    var checkOutList = inputCheckOut.split("-");
    var checkOutObject = {
        dayOfMonth : checkOutList[2],
        month : checkOutList[1],
        year : checkOutList[0]
    };

    var checkOutJson = JSON.stringify(checkOutObject);

    var findRoom = {
        roomType : inputType,
        nrOfPeople : nrOfBeds,
        theme : roomTheme
        };
    findRoom.checkOut = inputCheckOut;
    findRoom.checkIn = inputCheckIn;

    var findRoomJson = JSON.stringify(findRoom);


    console.log("findroom: " + findRoomJson);

    $.ajax({
            url : "http://localhost:8080/api/roomcontroller/selectroom",
            type : "post",
            data : findRoomJson,
            contentType : "application/json",
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