$(function () {
    login()
    //数据内容展示含查询
    $(".search a").click(function () {
        var value = $(".search input").val()

        var cid = getParameter("cid")
        location.href = "route_list.html?cid=" + cid + "&value=" + value
    });

    $.ajax({
        url: "http://www.travel.com/category/getAll",
        data: "",
        type: "get",
        dataType: "json",
        success: function (obj) {
            var str = '<li className=\"nav-active\"><a href=\"index.html\">首页</a></li>';
            obj.data.forEach(function (category) {

                str += '<li><a href="route_list.html?cid=' + category.cid + '">' + category.cname + '</a></li>';
            })
            str += ' <li><a href="favoriterank.html">收藏排行榜</a></li>';

            $("#category").html(str);
        }
    });


})

$("#exit").click(function () {
    $.ajax({
        url: 'http://www.travel.com/exitLogin',
        data: '',
        type: 'get',
        dataType: 'json',
        success: function (obj) {
			//清除缓存
            window.sessionStorage.removeItem("username");
            window.sessionStorage.removeItem("uid"); 
            login();
        }
    })
});

function login() {
    var username = window.sessionStorage.getItem("username");

    if (username == null) {
        $(".login_out").show()
        $(".login").hide()
    } else {
        $(".login_out").hide()
        $(".login").show()
        $("#span_username").text(username)
    }
}

