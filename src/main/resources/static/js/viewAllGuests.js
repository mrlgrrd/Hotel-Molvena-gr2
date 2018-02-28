function getGuests(){


    // ajax is een methode voor get/post requests
    $.ajax({
        // waar moet hij de request op uitvoeren
        url : "http://localhost:8080/api/guestcontroller/allguests",
        // type actie
        type : "get",
        // als de actie lukt, voer deze functie uit
        success: function(data){

            var guestList = "";

            $.each(data, function(index, current){
                var guestString = "<tr> <th>" + current.firstname + "</th> <th>  " + current.preposition + "</th> <th> " +
                    current.lastname + "</th> <th> " + current.address + "</th> <th> " + current.zipCode + "</th> <th> " +
                    current.city + "</th> <th> " + current.country + "</th> <th> " + current.phone + "</th> <th> " +
                    current.email + "</th> <th> " + current.passportNumber + "</th> <th> " + current.nationality +
                    "</th><th><button type='button' class='btn btn-info' data-toggle='modal' data-target='#updateRoomModal' onclick='javascript:updateRoom("
                    +current.id+")'>Update Room</button></th><th><button type='button' class='btn btn-danger' onclick='javascript:deleteGuest("
                    +current.id+")'>Delete Guest</button></th></tr>";

                guestList = guestList + guestString;

            });

            $("#guests").html(guestList);
        }
    });


}

//Omwerken naar guest
function deleteRoom(id){
console.log(id);
    alert("Room " + nr + " has been deleted.");
    $.ajax({
            // waar moet hij de request op uitvoeren
            url : "http://localhost:8080/api/guestcontroller/deleteguest?id=" + id,
            // type actie
            type : "delete",
            // als de actie lukt, voer deze functie uit
            success: function(nr){
                getGuests();
            }
        });

}

$(document).ready(function(){
    getGuests();

})

//function getData(){
//
//
//
//
//        $.ajax({
//        url:"http://localhost:8080/api/controller/allguests",
//        type:"get",
//        success : function(data){
//                console.log("this is the data: "+ data);
//
//                var personList = "Dit zijn de personen: </br>";
//                console.log(personList);
//
//                $.each(data, function(index, current){
//                var niceString = "</br>" + current.address + current.country + current.city;
//                console.log(niceString);
//
//
//                personList = personList + niceString;
//                console.log(personList);
//
//
//
//                });
//                $("#guests").html(personList);
//    }
//
//    });
//
//    }
//
//
//
//$(document).ready(function(){
//    getData();
//
//})