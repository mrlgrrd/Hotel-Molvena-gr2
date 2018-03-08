function getGuestDetails(guest_id){

    //Get values from input texts
    var inputFirstname = $("#fname").val();
    var inputPreposition = $("#preposition").val();
    var inputLastname = $("#lname").val();
    var inputAddress = $("#address").val();
    var inputZipcode = $("#zipcode").val();
    var inputCity = $("#city").val();
    var inputCountry = $("#country").val();
    var inputPhone = $("#phone").val();
    var inputEmail = $("#email").val();
    var inputPassportnr = $("#passportnr").val();
    var inputNationality = $("#nationality").val();

        //Put in a object
        var guestObject = {
        	id : guest_id,
        	firstname : inputFirstname,
        	preposition : inputPreposition,
        	lastname : inputLastname,
        	address : inputAddress,
        	zipCode : inputZipcode,
        	city : inputCity,
        	country : inputCountry,
        	phone : inputPhone,
        	email : inputEmail,
        	passportNumber : inputPassportnr,
        	nationality : inputNationality,
        };

        var guest = JSON.stringify(guestObject);
        return guest;

}