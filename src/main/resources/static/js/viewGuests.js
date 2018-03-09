function test(){
    console.log("hallo")
}

function composeGuestString(current){
	var guestString = "<tr> <td>" + removenull(current.firstname) + "</td> <td>  " + removenull(current.preposition) + "</td> <td> " +
	removenull(current.lastname) + "</td> <td> " +
	removenull(current.city) + "</td> <td> " + removenull(current.country) + "</td> <td> " + removenull(current.phone) + "</td> <td> " +
	removenull(current.email) + "</td> <td><button type='button' class='btn btn-warning' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalReadOnly("
	+current.id+")'>Details</button></td><td><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateGuestModal' onclick='javascript:showGuestModalUpdate("
	+current.id+")'>Edit</button></td><td><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteGuestModal' onclick='javascript:showDeleteModal("
	+current.id+")'>Delete</button></td></tr>";

	return guestString;
}