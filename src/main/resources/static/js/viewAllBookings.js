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

                        var roomString = "";
                        var bookingString = "<tr> <td>" + booking.id + "</td> <td>  " + booking.desiredPeriodFrom + "</td> <td> " + booking.desiredPeriodTill + "</td> <td> " + booking.guest.id + "</td> <td> " + booking.guest.firstname + "</td> <td> " + booking.guest.lastname + "</td> ";

                        // geeft de data van de snowboards weer die bij de persoon horen (ManyToMany)
                        $.each(booking.rooms, function(roomIndex, room) {
                            roomString = roomString + "#"+ room.id+ " " +room.theme +";          ";
                        });
                        bookingString = bookingString+ "<td> " + roomString + "</td>" + "<td><button type='button' class='btn btn-info'>Update Room</button></th>" + "<th><button type='button' class='btn btn-danger'>Delete Room</button></td></td>";;

                        bookingList += bookingString;

                    });

                    $("#bookings").html(bookingList);
                }
            });
            });

        };

        $(document).ready(showBookingList);