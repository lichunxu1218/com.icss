console.log("login.js加载成功")
$("#btn_sub").click(function () {

    console.log("测试登录信息是否采集->" + $("#loginForm").serialize());
    $.ajax({
        url: "http://www.travel.com/loginUser",
        data: $("#loginForm").serialize(),
        type: "get",
        dataType: "json",
        success: function (obj) {
            if (obj.code = 1) {
                alert("登陆成功!")
            } else {
                alert("登陆失败")
            }
        },
        error: function () {
            alert("失败")
        }
    });
});