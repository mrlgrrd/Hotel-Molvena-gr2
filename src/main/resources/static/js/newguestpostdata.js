function postData(){

    //Get values from input texts
    var inputFirstName = $("#fname").val();
    var inputPreposition = $("#preposition").val();
    var inputLastName = $("#lname").val();
    var inputAddress = $("#address").val();
    var inputZipcode = $("#zipcode").val();
    var inputCity = $("#city").val();
    var inputCountry = $("#country").val();
    var inputPhone = $("#phone").val();
    var inputEmail = $("#email").val();
    var inputPassportnr = $("#passportnr").val();
    var inputNationality = $("#nationality").val();

    //Put in a object
    var newGuestObject = {
        firstName : inputFirstName,
        preposition : inputPreposition,
        lastName : inputLastName,
        address : inputAddress,
        zipCode : inputZipcode,
        city : inputCity,
        country : inputCountry,
        phone : inputPhone,
        email : inputEmail,
        passportNumber : inputPassportnr,
        nationality : inputNationality,
    };

    var newGuest = JSON.stringify(newGuestObject);

    console.log(newGuest);

    //Communicate with Java
    $.ajax({
        url : "http://localhost:8080/api/guestcontroller/addguest",
        type : "post",
        data : newGuest,
        contentType: "application/json",
        success : function(data){

            //Geef een bevestiging dat de gast is toegevoegd
            $("#confirmation").text("You've successfully added "+inputFirstName+" "+inputLastName)

            //Maak de velden leeg
            $("#fname").val("");
            $("#preposition").val("");
            $("#lname").val("");
            $("#address").val("");
            $("#zipcode").val("");
            $("#city").val("");
            $("#country").val("");
            $("#phone").val("");
            $("#email").val("");
            $("#passportnr").val("");
            $("#nationality").val("");

        }
    })

}