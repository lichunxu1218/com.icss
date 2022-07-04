$(function () {
    login()

    $.ajax({
        url:"http://www.travel.com/category/getAll",
        data: "",
        type:"get",
        dataType:"json",
        success:function (obj) {
            $(".nav").empty();
            var str="<li class=\"nav-active\"><a href=\"index.html\">首页</a></li>"
            $.forEach(obj.data,function (inedex,category) {
                str+= '<li><a class="head_lan">'+category.cname+'</a></li>' ;
            })
           str="<li><a href=\"favoriterank.html\">收藏排行榜</a></li"
            $(".nav").append(str);
        }
    });
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

