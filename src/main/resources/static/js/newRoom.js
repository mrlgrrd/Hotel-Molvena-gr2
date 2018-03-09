function addRoom(){
    // get values from the post button form
    var roomNumber = Number($("#roomNumber").val());
    var EroomType = Number($("#roomType").val());
    var roomTheme = $("#roomTheme").val();
    var nrOfBeds = Number(("#nrOfBeds").val());
    var roomOccupied = $("#occupied").val();
    var roomClean = $("#clean").val();

    var newRoomObject = {
        number : roomNumber,
        roomType : EroomType,
        theme : roomTheme,
        nrOfPeople : nrOfBeds,
        occupied : roomOccupied,
        clean : roomClean
	    };

	var newRoom = JSON.stringify(newRoomObject);
        console.log(newRoom);
    $.ajax({
        url : "http://localhost:8080/api/roomcontroller/addroom", //url van de api waar de save functie staat in java
        type : "post",
        data : newRoom,
        contentType : "application/json",
        success  :function(data){
        	console.log("post succesfull");
        	        }
    });

}