var username = sessionStorage.key("username");
if(username==null){
    document.getElementsByClassName(".login").style.display ="none";
    document.getElementsByClassName(".login_out").style.display ="";
}else{
    document.getElementsByClassName(".login").style.display ="";
    document.getElementsByClassName(".login_out").style.display ="none";
}