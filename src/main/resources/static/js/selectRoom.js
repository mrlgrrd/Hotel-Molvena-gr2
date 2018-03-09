var beginStay;
var endStay;
var roomids;

function searchRoom(){
    var inputCheckIn = $("#checkIn").val();
    var inputCheckOut = $("#checkOut").val();
    var inputType = $("#roomType").val();
    var InputNrOfBeds = Number($("#nrOfBeds").val());

    var roomTheme = $("#roomTheme").val();

    console.log("input checkIn: " + inputCheckIn);
    console.log("input nrofbeds: " + InputNrOfBeds);

    var checkInList = inputCheckIn.split("-");
    var checkInObject = {
        dayOfMonth : checkInList[2],
        month : checkInList[1],
        year : checkInList[0]
    };

    var checkInJson = JSON.stringify(checkInObject);
    beginStay = inputCheckIn;
    endStay = inputCheckOut;

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
        nrOfBeds : InputNrOfBeds,
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

                if(current.theme == null){
                    theme == ""}
                    else {theme = current.theme};
                    console.log("thema input: " + current.theme + " " + current.number);
                    console.log("thema laten zien: " + theme + " " + current.number);

                if(current.roomType == "HONEYMOON"){
                    typeRoom = "Honeymoon"}
                    else if(current.roomType == "DELUXE"){
                        typeRoom = "Deluxe"}
                    else if (current.roomType == "STANDARD"){
                        typeRoom = "Standard"}

                var roomString = "<tr> <td>" + current.number + "</td> <td>  " + theme + "</td> <td>  " + typeRoom +"</td> <td> " + current.nrOfPeople + "</td> <td> " + "<button type='button' class='btn btn-info' onclick='javascript:selectRoom("+current.id+")'>Select Room</button></th>";

                foundRooms = foundRooms + roomString;
                });

            $("#availableRooms").html(foundRooms);

            }

    });

}

function selectRoom(id){
     $.ajax({
        	url : "http://localhost:8080/api/roomcontroller/findroombyid?id=" + id,
        	type : "get",
        	success: function(data){
        	    var roomString;

        			//$("#room").text(roomString);
        			//console.log(roomString);
        			var room_id = id;
        			console.log(room_id);


        	}
        });

     getRoomData(beginStay, endStay, id);
}