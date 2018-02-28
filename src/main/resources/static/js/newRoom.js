function addRoom(){
    // get values from the post button form
    var roomNumber = Number($("#roomNumber").val());
    var EroomType = Number($("#roomType").val());

    var newRoomObject = {
        number : roomNumber,
        roomType : EroomType
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
