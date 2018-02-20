$.get("/api/initializerooms", function (result) {

	console.log("number:", result.number);
	console.log("type:", result.roomType);

});