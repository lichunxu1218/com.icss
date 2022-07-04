$(function () {
    login()
    $(".search a").click(function () {
        window.sessionStorage.setItem("value", $(".search input").val())
        location.href="route_list.html"
    });
    $.ajax({
        url:"http://www.travel.com/category/getAll",
        data: "",
        type:"get",
        dataType:"json",
        success:function (obj) {
            var str = '<li className=\"nav-active\"><a href=\"index.html\">首页</a></li>';
            obj.data.forEach(function (category) {

                str+='<li><a href="route_list.html?cid='+category.cid+'">'+category.cname+'</a></li>';
            })
            str+=' <li><a href="favoriterank.html">收藏排行榜</a></li>';

            $("#category").html(str);
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

