function addRoom(){
    // get values from the post button form
    var roomNumber = $("#roomNumber").val();
    var EroomType = $("#roomType").val();

    var newRoomObject = {
        number : roomNumber,
        roomType : EroomType
	    };

    console.log(newRoomObject);

	var newRoom = JSON.stringify(newRoomObject);

    $.ajax({
        url : "http://localhost:8080/api/controller/addroom", //url van de api waar de save functie staat in java
        type : "post",
        data : newRoomObject,
        contentType : "application/json",
        success  :function(data){
        	console.log("post succesfull");
        	        }
    });

}
