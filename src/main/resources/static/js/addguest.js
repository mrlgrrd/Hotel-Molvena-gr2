function sayHello(name){

    $.get("/api/addGuest?name=" + name, function(result){
    console.log(.text(result));
    //$("#title").text(result);

});
}

$("#addGuestBtn").click(function(){
    var firstname = $("#fname").val();
    //console.log(firstname);
    addGuest(firstname);
});