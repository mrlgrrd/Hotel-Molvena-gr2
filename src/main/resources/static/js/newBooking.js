//function postData(){
//
//    //Get values from input texts
//    var inputDesiredPeriodFrom = $("#dfrom").val();
//    var inputDesiredPeriodTill = $("#dtill").val();
////    var inputGuestId = $("#guest").val();
////    var inputRoom = $("#room").val();
//
//
//    //Put in a object
//    var newBookingObject = {
//        desiredPeriodFrom : inputDesiredPeriodFrom,
//        desiredperiodTill : inputDesiredPeriodTill,
////        guest.id : inputGuestId,
////        rooms.id : inputRoom,
//    };
//
//    var newBooking = JSON.stringify(newBookingObject);
//
//    console.log(newBooking);
//
//    //Communicate with Java
//    $.ajax({
//        url : "http://localhost:8080/api/bookingcontroller/newbooking",
//        type : "post",
//        data : newBooking,
//        contentType: "application/json",
//        success : function(data){
//
//            //Geef een bevestiging dat de booking is toegevoegd
//            $("#confirmation").text("You've successfully added a booking!")
//
//            //Maak de velden leeg
//            $("#dfrom").val("");
//            $("#dtill").val("");
////            $("#guest").val("");
////            $("#room").val("");
//
//
//        }
//    })
//
//}