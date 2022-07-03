$(function () {
    var username = sessionStorage.key("username");
    alert(username)
    if(username==null){
        document.getElementsByClassName(".login").style.display ="none";
        document.getElementsByClassName(".login_out").style.display ="";
    }else{
        document.getElementsByClassName(".login").style.display ="";
        document.getElementsByClassName(".login_out").style.display ="none";
    }
    $.get("header.html",function (data) {
        $("#header").html(data);
    });
    $.get("footer.html",function (data) {
        $("#footer").html(data);
    });
});