function showBookingList(){
    // als de pagina geladen is, start deze functie
    $(document).ready(function(){

    // ajax is een methode voor get/post requests
    $.ajax({
        // waar moet hij de request op uitvoeren
        url : "/api/bookingcontroller/showbookings",
        // type actie
        type : "get",
        // als de actie lukt, voer deze functie uit
        success: function(showBookingData){

            var bookingList = "";

            $.each(showBookingData, function(bookingIndex, booking){


                var bookingString = "<tr> <td>" + booking.id + "</th> <td>  " + booking.desiredPeriodFrom + "</th> <td> " + booking.desiredPeriodTill + "</td> <td> "+ booking.guest.id + "</td> <td> " + booking.guest.firstname + "</td> <td> " + booking.guest.lastname + "</td></td>";

                bookingList = bookingList + bookingString;

            });

            $("#bookings").html(bookingList);
        }
    });
    });

};

$(document).ready(showBookingList);