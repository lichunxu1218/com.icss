$("#btn_sub").click(function () {

    console.log($("#loginForm").serialize())
    $.ajax({
        url: 'http://www.travel.com/loginUser',
        data: $("#loginForm").serialize(),
        type: 'get',
        dataType: 'json',
        success: function (obj) {
            if (obj.code == 1) {
                // alert("登录成功")
                // console.log("登录的-》》》》uid-》》"+obj.data.uid)
                window.sessionStorage.setItem("username", obj.data.username)
                window.sessionStorage.setItem("uid", obj.data.uid)
                location.href = "index.html"
            } else {
                alert("登录失败")
            }
        }
    })

});