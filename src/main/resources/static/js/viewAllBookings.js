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
                        var bookingString = "<tr> <td>" + booking.id + "</td> <td>  " + booking.desiredPeriodFrom + "</td> <td> " + booking.desiredPeriodTill + "</td> <td> " + booking.guest.firstname + " " + booking.guest.lastname + "</td> <td> " + booking.guest.email + "</td> <td>" + booking.guest.phone + "</td> ";

                        // geeft de data van de snowboards weer die bij de persoon horen (ManyToMany)
                        $.each(booking.rooms, function(roomIndex, room) {
                        roomString = roomString + "#"+ room.number+ ";          ";
                        });
                        bookingString = bookingString+ "<td> " + roomString + "</td>" + "<td><button type='button' class='btn btn-info'>Edit</button></th>" + "<th><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteBookingModal' onclick='javascript:showDeleteModal("+booking.id+")'>Delete</button></td></td>";

                        bookingList += bookingString;

                    });

                    $("#bookings").html(bookingList);
                }
            });
            });

        };

        $(document).ready(showBookingList);

        function goToNewBooking(){
        location.href = "http://localhost:8080/newbooking.html";
        }


        function searchBooking(){
        	var input = $("#searchBooking").val();
        	console.log(input);

        	if(input == ""){
        		showBookingList();
        	} else {
            // ajax is een methode voor get/post requests
            $.ajax({
                    // waar moet hij de request op uitvoeren
                    url : "/api/bookingcontroller/searchbooking/" + input,
                    // type actie
                    type : "get",
                    // als de actie lukt, voer deze functie uit
                    success: function(showBookingData){
                     console.log(input);
                        var bookingList = "";

                        $.each(showBookingData, function(bookingIndex, booking){

                        var roomString = "";
                        var bookingString = "<tr> <td>" + booking.id + "</td> <td>  " + booking.desiredPeriodFrom + "</td> <td> " + booking.desiredPeriodTill + "</td> <td> " + booking.guest.firstname + " " + booking.guest.lastname + "</td> <td> " + booking.guest.email + "</td><td> " + booking.guest.phone + "</td> ";

                        // geeft de data van de snowboards weer die bij de persoon horen (ManyToMany)
                        $.each(booking.rooms, function(roomIndex, room) {
                        roomString = roomString + "#"+ room.number+ ";          ";
                        });
                        bookingString = bookingString+ "<td> " + roomString + "</td>" + "<td><button type='button' class='btn btn-info'>Edit</button></th>" + "<th><button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deleteBookingModal' onclick='javascript:showDeleteModal("+booking.id+")'>Delete</button></td></td>";;

                        bookingList += bookingString;

                        });


                    	$("#bookings").html(bookingList);
                    }
                });
        }
        }

        $(document).ready(function(){
        	showBookingList();
        })


