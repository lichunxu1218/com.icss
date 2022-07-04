$(function () {
    var cid = getParameter("cid");
    route_list(cid, 1)

})

function bottom(oop, cid) {
    //分页页码
    var count = oop.total;
    var endPage = oop.pages;
    alert(count)
    $("#pagecount").text(count);
    $("#pages").text(endPage);
    var str1 = " <li><a id=\"first\">首页</a></li> <li class=\"threeword\"><a id='back'>上一页</a></li>";
    obj.data.navigatepageNums.forEach(function (nr) {
        str1 += '<li><a class="nr_page">' + nr + '</a></li>'
    });
    var str1 = " <li><a id=\"end\">尾页</a></li> <li class=\"threeword\"><a id='next'>下一页</a></li>";

    $("#ul2").html(str1)

    $(document).on("click","#first",function () {
        route_list(cid, 1);
    });
    $(document).on("click","#end",function () {
        route_list(cid, endPage)
    });
    $(document).on("click","#back",function () {
        route_list(cid, obj.data.prePage)
    });
    $(document).on("click","#next",function () {
        route_list(cid,  obj.data.nextPage)
    });
    $(document).on("click",".nr_page",function () {
        route_list(cid, obj.data.pageNum)
    });

    $("#ul2").html(str);
}

function route_list(cid, page) {
    $.ajax({
        url: "http://www.travel.com/route/getAll",
        data: 'cid=' + cid + '&page=' + page,
        type: "get",
        dataType: "json",
        success: function (obj) {
            // 清空数据
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
                //左侧数据内容
                bottom(obj.data, cid)
            }
        }
    });
}

