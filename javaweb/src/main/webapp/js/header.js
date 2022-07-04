$(function () {
    login()
})

function login() {
    var username = window.sessionStorage.getItem("username");

    if (username==null){

        $(".login_out").show()
        $(".login").hide()
    }else {
        $(".login_out").hide()
        $(".login").show()
        $("#span_username").text(username)
    }
}
