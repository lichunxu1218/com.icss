$(function () {

    var cid = getParameter("cid");

    route_list(cid, 1, "")

})

function route_list(cid, page, value) {

    var value = getParameter("value");

    if (!value) {
        value = "";
    }
    value = window.decodeURIComponent(value);
    // alert(value);
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
                        '       <p><a href="route_detail.html?rid="'+nr.rid+'">查看详情</a></p>\n' +
                        '        </div>\n' +
                        '  </li>';

                })
                $("#ul1").html(str);
                //底部数据内容
                bottom(obj.data, cid, value)
            }
        }
    });
}


function bottom(data, cid, rname) {
    // //分页页码
    // var count = obj.data.total;
    // var endPage = obj.data.pages;
    //
    // $("#pagecount").text(count);
    // $("#pages").text(endPage);
    // var str1 = " <li><a id=\"first\">首页</a></li> <li class=\"threeword\"><a id='back'>上一页</a></li>";
    // obj.data.navigatepageNums.forEach(function (nr) {
    //
    //     str1 += '<li><a class="nr_page">' + nr + '</a></li>'
    // });
    // str1 += "  <li class=\"threeword\"><a id='next'>下一页</a></li> <li><a id=\"end\">尾页</a></li>";
    //
    // $("#ul2").html(str1);
    //
    // $(document).on("click", "#first", function () {
    //     route_list(cid, 1, rname);
    // });
    // $(document).on("click", "#end", function () {
    //     route_list(cid, endPage, rname)
    // });
    // $(document).on("click", "#back", function () {
    //     route_list(cid, obj.data.prePage, rname)
    // });
    // $(document).on("click", "#next", function () {
    //     route_list(cid, obj.data.nextPage, rname)
    // });
    // $(document).on("click", ".nr_page", function () {
    //     route_list(cid, obj.data.pageNum, rname)
    // });


    $("#pagecount").text(data.total);
    $("#pages").text(data.pages);
    var pageArray = data.navigatepageNums;

    var str = '<li onclick="route_list(' + cid + ',1,\'' + rname + '\')"><a href="javascript:void(0);" >首页</a></li>\n' +
        '                            <li class="threeword" onclick="route_list(' + cid + ',' + data.prePage + ',\'' + rname + '\')"><a href="javascript:void(0);" >上一页</a></li>';
    pageArray.forEach(function (p) {

        if (data.pageNum == p) {
            str += '<li class="curPage" onclick="route_list(' + cid + ',' + p + ',\'' + rname + '\')"><a href="javascript:void(0);">' + p + '</a></li>';
        } else {
            str += '<li onclick="route_list(' + cid + ',' + p + ',\'' + rname + '\'")"><a href="javascript:void(0);">' + p + '</a></li>';
        }

    })

    str += '<li class="threeword" onclick="route_list(' + cid + ',' + data.nextPage + ',\'' + rname + '\')"><a href="javascript:void(0);">下一页</a></li>\n' +
        '                            <li class="threeword" onclick="route_list(' + cid + ',' + data.pages + ',\'' + rname + '\')"><a href="javascript:void(0);">末页</a></li>\n';


    $("#ul2").html(str);
}