//username失去焦点的事件处理
$("#username").blur(function () {
    var reg = /^[a-zA-Z0-9]{6,10}$/;
    if ($(this).val() == "" || !reg.test($(this).val())) {
        $(this).removeClass("msg-success").addClass("msg-error");
    } else {
        $(this).removeClass("msg-error").addClass("msg-success");
        $.ajax({
            url: 'http://www.travel.com/getUserByUserName',
            data: 'username=' + $(this).val(),
            type: 'get',
            dataType: 'json',
            success: function (obj) {
                if (obj.code == 0) {
                    $("#username").removeClass("msg-success").addClass("msg-error");
                } else {
                    // alert("okkkk")
                    // location.href='login.html';
                    $("#username").removeClass("msg-error").addClass("msg-success");
                }
            }
        })
    }
});
//password失去焦点事件
$("#password").blur(function () {
    var reg = /^[a-zA-Z0-9]{6,10}$/;
    if ($(this).val() == "" || !reg.test($(this).val())) {
        $(this).removeClass("msg-success").addClass("msg-error");
    } else {
        $(this).removeClass("msg-error").addClass("msg-success");
    }
});
//email失去焦点事件
$("#email").blur(function () {
    var reg = /^[a-zA-Z0-9]{1,}@[a-z0-9]{2,4}\.com$/;
    if ($(this).val() == "" || !reg.test($(this).val())) {
        $(this).removeClass("msg-success").addClass("msg-error");
    } else {
        $(this).removeClass("msg-error").addClass("msg-success");
    }
});
//name失去焦点事件
$("#name").blur(function () {
    if ($(this).val() == "") {
        $(this).removeClass("msg-success").addClass("msg-error");
    } else {
        $(this).removeClass("msg-error").addClass("msg-success");
    }
});
//telephone失去焦点事件
$("#telephone").blur(function () {
    var reg = /^1[0-9]{10}$/;
    if ($(this).val() == "") {
        $(this).removeClass("msg-success").addClass("msg-error");
    } else {
        $(this).removeClass("msg-error").addClass("msg-success");
    }
});
//birthday失去焦点事件
$("#birthday").blur(function () {
    if ($(this).val() == "") {
        $(this).removeClass("msg-success").addClass("msg-error");
    } else {
        $(this).removeClass("msg-error").addClass("msg-success");
    }
});

$("#btnsubmit").click(function () {
    var count = 0;
    $("#registerForm").find("input").each(function () {
        if ($(this).hasClass("msg-success")) {
            count++;
        }
    });
    if (count == 6) {
        // alert("count=6")
        $.ajax({
            url: 'http://www.travel.com/registerUser',
            data: $("#registerForm").serialize(),
            type: 'get',
            dataType: 'json',
            success: function (obj) {
                if (obj.code == 0) {
                    $("#username").removeClass("msg-success").addClass("msg-error");
                } else {
                    location.href = "login.html";
                }
            }
        })
    }
});