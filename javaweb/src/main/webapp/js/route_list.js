$(function () {
    var value = getParameter("value")

    var cid = getParameter("cid");

    route_list(cid, 1, value)



function route_list(cid, page, value) {
    if (value == null) {
        value = ""
    }
    alert("list"+value)
    $.ajax({
        url: "http://www.travel.com/route/select",
        data: 'cid=' + cid + '&page=' + page + '&value=' + value,
        type: "get",
        dataType: "json",
        success: function (obj) {

            if (obj.code == 1) {

                var str = ""
                obj.data.list.forEach(function (nr) {
                    str += '<li>\n' +
                        '     <div class="img"><img src="' + nr.rimage + '" width="299px" height="169px"></div>\n' +
                        '     <div class="text1">\n' +
                        '     <p>' + nr.rname + '</p>\n' +
                        '     <br/>\n' +
                        '        <p>' + nr.routeintroduce + '</p>\n' +
                        '        </div>\n' +
                        '        <div class="price">\n' +
                        '        <p class="price_num">\n' +
                        '      <span>&yen;</span>\n' +
                        '        <span>' + nr.price + '</span>\n' +
                        '      <span>起</span>\n' +
                        '       </p>\n' +
                        '       <p><a href="route_detail.html">查看详情</a></p>\n' +
                        '        </div>\n' +
                        '  </li>';

                })
                $("#ul1").html(str);
                //底部数据内容
                bottom(obj.data, cid)
            }
        }
    });
}

})

function bottom(p, cid) {
    //分页页码
    var count = p.total;
    var endPage = p.pages;

    $("#pagecount").text(count);
    $("#pages").text(endPage);
    var str1 = " <li><a id=\"first\">首页</a></li> <li class=\"threeword\"><a id='back'>上一页</a></li>";
    p.navigatepageNums.forEach(function (nr) {

        str1 += '<li><a class="nr_page">' + nr + '</a></li>'
    });
    str1 += " <li><a id=\"end\">尾页</a></li> <li class=\"threeword\"><a id='next'>下一页</a></li>";

    $("#ul2").html(str1)

    $(document).on("click", "#first", function () {
        route_list(cid, 1);
    });
    $(document).on("click", "#end", function () {
        route_list(cid, endPage)
    });
    $(document).on("click", "#back", function () {
        route_list(cid, p.prePage)
    });
    $(document).on("click", "#next", function () {
        route_list(cid, p.nextPage)
    });
    $(document).on("click", ".nr_page", function () {
        route_list(cid, p.pageNum)
    });


    $("#ul2").html(str1);
}