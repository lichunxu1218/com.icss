$(function () {
    // http://www.travel.com/favorite/myfavorite?uid=1&page=1
    var uid = window.sessionStorage.getItem("uid");
    loadData(1, uid)
})

function loadData(page, uid) {
    $.ajax({
        url: "http://www.travel.com/favorite/myfavorite",
        data: 'uid=' + uid + '&page=' + page,
        type: "get",
        dataType: "json",
        success: function (obj) {
            var str = '';
            obj.data.list.forEach(function (route) {
                str += '<div class="col-md-3">\n' +
                    '             <a href="route_detail.html?rid='+route.rid+'">\n' +
                    '          <img src="' + route.rimage + '" alt="">\n' +
                    '        <div class="has_border">\n' +
                    '      <h3>' + route.rname + '</h3>\n' +
                    '        <div class="price">网付价<em>￥</em><strong>' + route.price + '</strong><em>起</em></div>\n' +
                    '      </div>\n' +
                    '      </a>\n' +
                    '     </div>'
            })
            $(".row").html(str);
            funpage(obj, uid)
        }
    })
}

//和分页相关
function funpage(obj, uid) {
    var pageArray = obj.data.navigatepageNums;

    var str = '<li onclick="loadData(1,\'' + uid + '\')"><a href="javascript:void(0);" >首页</a></li>\n' +
        '                            <li class="threeword" onclick="loadData(' + obj.data.prePage + ',\'' + uid + '\')"><a href="javascript:void(0);" >上一页</a></li>';
    pageArray.forEach(function (p) {

        if (obj.data.pageNum == p) {
            str += '<li class="curPage" onclick="loadData(' + p + ',\'' + uid + '\')"><a href="javascript:void(0);">' + p + '</a></li>';
        } else {
            str += '<li onclick="loadData(' + p + ',\'' + uid + '\')"><a href="javascript:void(0);">' + p + '</a></li>';
        }

    })

    str += '<li class="threeword" onclick="loadData(' + obj.data.nextPage + ',\'' + uid + '\')"><a href="javascript:void(0);">下一页</a></li>\n' +
        '                            <li class="threeword" onclick="loadData(' + obj.data.pages + ',\'' + uid + '\')"><a href="javascript:void(0);">末页</a></li>\n';


    $("#pageNum").html(str);
}