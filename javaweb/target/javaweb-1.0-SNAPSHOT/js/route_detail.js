$(function () {
    var rid = getParameter("rid")
    // alert(rid)
    // var rid=1
    $.ajax({
        url: "http://www.travel.com/route/detail",
        data: 'rid=' + rid,
        type: "get",
        dataType: "json",
        success: function (obj) {
            console.log(obj)
            if (obj.code == 1) {

                forImg(obj.data.imgList);

                fortabSeller(obj.data.tabSeller)

                fortabRoute(obj.data.tabRoute)
            }
        }
    });
    //大小图片显示
    fimg();
    //收藏功能
    forfavorite()

})

//展示路线的详细信息（价格等）
function fortabRoute(route) {

    $(".routeRname").text(route.rname)
    $(".pros_title").text(route.rname)
    $(".hot").text(route.routeintroduce)
    $(".price strong").text("￥" + route.price)
    // $(".collect span").text("'已收藏'<span id='rcount'>" + route.count + "</span>>次")
    str = "已收藏 <span id='rcount'>" + route.count + "</span>次"

    $(".collect span").html(str)
}

//展示路线的图片信息
function forImg(list) {

    var str = ' <dt>\n' +
        '       <img alt="" class="big_img" src="' + list[0].bigpic + '">\n' +
        '        </dt>\n' +
        '        <dd >' +
        '<a class="up_img up_img_disable"></a>\n';


    for (i = 0; i < list.length; i++) {
        if (i > 3) {
            str += '  <a title="" class="little_img" data-bigpic="' + list[i].bigpic + '" style="display:none;">\n' +
                '         <img src="' + list[i].smallpic + '">\n' +
                '   </a>'
        } else {
            str += '  <a title="" class="little_img" data-bigpic="' + list[i].bigpic + '">\n' +
                '        <img src="' + list[i].smallpic + '">\n' +
                '   </a>'
        }
    }
    str += '<a class="down_img down_img_disable" style="margin-bottom: 0;"></a> </dd>'
    fimg();
    $(".prosum_left").html(str)

}

//展示路线商家信息
function fortabSeller(seller) {

    str = ' <p>经营商家 ：' + seller.sname + '</p>\n' +
        ' <p>咨询电话 : ' + seller.consphone + '</p>\n' +
        ' <p>地址 ： ' + seller.address + '</p>'
    $(".pros_other").html(str)
}


function fimg() {
    $(document).ready(function () {
        //焦点图效果
        //点击图片切换图片
        $('.little_img').on('mousemove', function () {
            $('.little_img').removeClass('cur_img');
            var big_pic = $(this).data('bigpic');
            $('.big_img').attr('src', big_pic);
            $(this).addClass('cur_img');
        });
        //上下切换
        var picindex = 0;
        var nextindex = 4;
        $('.down_img').on('click', function () {
            var num = $('.little_img').length;
            if ((nextindex + 1) <= num) {
                $('.little_img:eq(' + picindex + ')').hide();
                $('.little_img:eq(' + nextindex + ')').show();
                picindex = picindex + 1;
                nextindex = nextindex + 1;
            }
        });
        $('.up_img').on('click', function () {
            var num = $('.little_img').length;
            if (picindex > 0) {
                $('.little_img:eq(' + (nextindex - 1) + ')').hide();
                $('.little_img:eq(' + (picindex - 1) + ')').show();
                picindex = picindex - 1;
                nextindex = nextindex - 1;
            }
        });
        //自动播放
        // var timer = setInterval("auto_play()", 5000);
    });


}

//自动轮播方法
function auto_play() {
    var cur_index = $('.prosum_left dd').find('a.cur_img').index();
    cur_index = cur_index - 1;
    var num = $('.little_img').length;
    var max_index = 3;
    if ((num - 1) < 3) {
        max_index = num - 1;
    }
    if (cur_index < max_index) {
        var next_index = cur_index + 1;
        var big_pic = $('.little_img:eq(' + next_index + ')').data('bigpic');
        $('.little_img').removeClass('cur_img');
        $('.little_img:eq(' + next_index + ')').addClass('cur_img');
        $('.big_img').attr('src', big_pic);
    } else {
        var big_pic = $('.little_img:eq(0)').data('bigpic');
        $('.little_img').removeClass('cur_img');
        $('.little_img:eq(0)').addClass('cur_img');
        $('.big_img').attr('src', big_pic);
    }
}

//收藏功能
function forfavorite() {
    var uid = window.sessionStorage.getItem("uid")
    var rid = getParameter("rid")
    // alert("用户id为" + uid+",rid->."+rid)

    if (uid == null) {
        //显示点击收藏
        favoriteStatic(1)
        //未登录状态被点击收藏
        $(".btn").eq(0).click(function () {
            var f = confirm("请先登录！")
            if (f == true) {
                location.href = 'login.html'
            }
        });
    } else {

        $.ajax({
            url: "http://www.travel.com/favorite/select",
            data: 'rid=' + rid + '&uid=' + uid,
            type: "get",
            dataType: "json",
            success: function (obj) {

                var str = "";
                if (obj.data != null) {

                    favoriteStatic(0)
                    str = "http://www.travel.com/favorite/subCount"
                } else {

                    favoriteStatic(1)
                    str = "http://www.travel.com/favorite/addCount"
                }

                //点击事件
                $(".btn").eq(0).click(function () {
                    var rcount = $("#rcount").text()
                    // alert(rcount)
                    str += '?rid=' + rid + '&uid=' + uid + '&rcount=' + rcount;
                    console.log("拼接后的url" + str)
                    $.ajax({
                        url: str,
                        data: '',
                        type: "get",
                        dataType: "json",
                        success: function (obj) {
                            favoriteStatic(!obj.code)
                            location.reload();
                        }
                    });
                });
            }
        });
    }
}

//状态 收藏状态的判定，按钮中内容变化 ，收藏 1-> 点击收藏 0->取消收藏
function favoriteStatic(num) {

    if (num == 1) {
        $(".btn").eq(0).text("点击收藏")
    } else {
        $(".btn").eq(0).text("取消收藏")
    }
}

