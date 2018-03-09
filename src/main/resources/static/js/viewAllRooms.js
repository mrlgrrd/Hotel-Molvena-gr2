

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
                var theme = "";
                var cleanRoom = "";
                var typeRoom = "";
                var occupied = "";

                if(current.theme == null){
                    theme == ""}
                    else {theme = current.theme};

                if(current.roomType == "HONEYMOON"){
                    typeRoom = "Honeymoon"}
                else if(current.roomType == "DELUXE"){
                    typeRoom = "Deluxe"}
                else if (current.roomType == "STANDARD"){
                    typeRoom="Standard"}
                    else {typeRoom = "not defined"};

                if(current.clean == null){
                    cleanRoom = ""}
                    else if (current.clean == false){cleanRoom = "Dirty"}
                    else if (current.clean == true){cleanRoom = "Clean"};

                if(current.occupied == null){
                                occupied = ""}
                                else if (current.occupied == false){occupied = "Available"}
                                else if (current.occupied == true){occupied = "Occupied"};

                var roomString = "<tr> <td>" + current.number + "</th> <td>  " + theme + "</th> <td>  " + typeRoom +"</th> <td> " + current.nrOfPeople + "</th> <td> " + occupied
                + "</td><td><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateRoomModal' onclick='openUpdateModal("+current.id+")'>Edit</button></th>"
                + "<th><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteGuestModal' + onclick='openDeleteModal("+current.id+","+current.number+")'>Delete</button></td></td>";

                roomList = roomList + roomString;

                });

                $("#rooms").html(roomList);
            }
        });
    });

};

$(document).ready(getRooms());

function openDeleteModal(id, number){
    $("#deleteRoomModal").modal('show');
    var generateDeleteButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancel</button>"
                                +"<button type='button' class='btn btn-danger' data-dismiss='modal' onclick='deleteRoom("+id+");'>Delete</button>";

    $("#deleteNumber").text(number);
    $("#deleteModalFooter").html(generateDeleteButtons);
}

function deleteRoom(id){

    $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/roomcontroller/deleteroom?id=" + id,
            // type actie
            type : "delete",
            // als de actie lukt, voer deze functie uit
            success : function(id){
                getRooms();
            }
        });
}

function openUpdateModal(id){

    $.ajax({
            url : "http://localhost:8080/api/roomcontroller/findroombyid?id=" + id,
            type : "get",
            success: function(data){
                var theme = "";
                var typeRoom = "";
                var occupied = "";
                var clean = "";

                if(data.theme == null){
                    theme == ""}
                    else {theme = data.theme};

                if(data.roomType == "HONEYMOON"){
                    typeRoom = 0}
                    else if(data.roomType == "DELUXE"){
                      typeRoom = 1}
                    else if (data.roomType == "STANDARD"){
                      typeRoom = 2}
                    else {typeRoom = "not defined"};

                if(data.occupied == null){
                    occupied = ""}
                 else if (data.occupied == false){occupied = "false"}
                 else if (data.occupied == true){occupied = "true"};

                 if(data.clean == null){
                    clean = ""}
                    else if (data.clean == false){clean = "false"}
                    else if (data.clean == true){clean = "true"};

                $("#theme").val(theme);
                $("#roomType").val(typeRoom);
                $("#roomNumber").val(data.number);
                $("#nrOfBeds").val(data.nrOfPeople);
                $("#clean").val(clean);
                $("#occupied").val(occupied);

            }
        })

    var generateUpdateButtons = "<button type='button' class='btn btn-secondary' data-dismiss='modal'>Cancel</button>"
                                +"<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='updateRoom("+id+");'>Edit</button>";

    $("#updateModalFooter").html(generateUpdateButtons);

}

function updateRoom(id){

    var inputTheme = $("#theme").val();
    var inputTypeRoom = $("#roomType").val();
    var numberTypeRoom = Number(inputTypeRoom);
    var inputNumber=  $("#roomNumber").val();
    var numberRoomNumber = Number(inputNumber);
    var inputNrOfPeople = $("#nrOfBeds").val();
    var numberNrOfPeople = Number(inputNrOfPeople);
    var inputClean = $("#clean").val();
    var inputOccupied = $("#occupied").val();

    console.log("clean = " + inputClean);

    var newRoom = {
        id : id,
        roomType : numberTypeRoom,
        nrOfPeople : numberNrOfPeople,
        number : numberRoomNumber,
        clean : inputClean,
        theme : inputTheme,
        occupied : inputOccupied
        };

    var newRoomJson = JSON.stringify(newRoom);

    $.ajax({
        url : "http://localhost:8080/api/roomcontroller/updateroom/"+ id,
        type : "put",
        data : newRoomJson,
        contentType : "application/json",
        success : function(id, data){
            getRooms();
        }

    });

}

function searchRoom(){
    var input = $('#searchRoomTheme').val();

        $.ajax({
                // waar moet hij de request op uitvoeren
                url : "http://localhost:8080/api/roomcontroller/searchroomtheme/" + input,
                // type actie
                type : "get",
                // als de actie lukt, voer deze functie uit
                success: function(input){
                var roomList = "";
                    $.each(input, function(index, current){


                    var theme = "";
                    var cleanRoom = "";
                    var typeRoom = "";
                    var occupied = "";

                    if(current.theme == null){
                        theme == ""}
                        else {theme = current.theme};

                    if(current.roomType == "HONEYMOON"){
                        typeRoom = "Honeymoon"}
                    else if(current.roomType == "DELUXE"){
                        typeRoom = "Deluxe"}
                    else if (current.roomType == "STANDARD"){
                        typeRoom="Standard"}
                        else {typeRoom = "not defined"};

                    if(current.clean == null){
                        cleanRoom = ""}
                        else if (current.clean == false){cleanRoom = "Dirty"}
                        else if (current.clean == true){cleanRoom = "Clean"};

                    if(current.occupied == null){
                        occupied = ""}
                        else if (current.occupied == false){occupied = "Available"}
                        else if (current.occupied == true){occupied = "Occupied"};

                    var roomString = "<tr> <td>" + current.number + "</th> <td>  " + theme + "</th> <td>  " + typeRoom +"</th> <td> " + current.nrOfPeople + "</th> <td> " + occupied + "</td> <td> " + cleanRoom
                    + "</td><td><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateRoomModal' onclick='openUpdateModal("+current.id+")'>Edit</button></th>"
                    + "<th><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteGuestModal' + onclick='openDeleteModal("+current.id+")'>Delete</button></td></td>";

                    roomList = roomList + roomString;

                    });

                    $("#rooms").html(roomList);
                    }
        });
}

function relocateNewRoom(){
    location.href = "http://localhost:8080/newroom.html";
}
