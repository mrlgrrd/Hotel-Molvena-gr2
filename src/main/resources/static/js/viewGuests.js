function test(){
    console.log("hallo")
}

function composeGuestString(current){
	var guestString = "<tr> <th>" + removenull(current.firstname) + "</th> <th>  " + removenull(current.preposition) + "</th> <th> " +
	removenull(current.lastname) + "</th> <th> " +
	removenull(current.city) + "</th> <th> " + removenull(current.country) + "</th> <th> " + removenull(current.phone) + "</th> <th> " +
	removenull(current.email) + "</th> <th><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalReadOnly("
	+current.id+")'>See details</button></th><th><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalUpdate("
	+current.id+")'>Update Guest</button></th><th><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteGuestModal' onclick='javascript:showDeleteModal("
	+current.id+")'>Delete Guest</button></th></tr>";

	return guestString;
}