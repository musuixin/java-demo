$(document).ready(function () {
    $("#获取验证码").click(function () {
        var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
        var ie=$("label[for='inputEmail']");
        var obj=$('input[name="email"]');
        if(obj.val() === ""){ //输入不能为空
            ie.text("邮箱输入为空");
            ie.attr("class","text-danger");
            return false;
        }else if(!reg.test(obj.val())){ //正则验证不通过，格式不对
            ie.text("邮箱格式不对！");
            ie.attr("class","text-danger");
            return false;
        }
        time(this);
        $.post({
            url: "/SignlnRegister2_war_exploded/getCode",
            data: {"toEmail": trim($("#inputEmail").val())},
            dataType: "text",
            success: function (data) {
                $("#注册").attr("disabled", false);
                ie.text("邮箱");
                ie.attr("class","");
                obj.attr("readonly"," readonly");
                alert("发送成功");
            }
        });
    });
    $('input[name="code"]').keyup(function () {
        $('label[for="inputCode"]').text("验证码");
        $('label[for="inputCode"]').attr("class", "");
    });
    $('input[name="email"]').keyup(function () {
        $("label[for='inputEmail']").text("邮箱");
        $("label[for='inputEmail']").attr("class", "");
    });

    $('input[name="uname"]').keyup(function () {
        var xx;
        var iu = $('input[name="uname"]');
        var li = $('label[for="inputUserame"]');
        $.ajax({
            url: "/SignlnRegister2_war_exploded/Uname",
            type: "post",
            async: true,
            data: {uname: iu.val()},
            success: function (data) {
                if (data == "false") {
                    li.text("用户名");
                    li.attr("class", "");
                    $("#注册").attr("disabled", false);
                } else {
                    xx = data;
                    li.text("用户名重复");
                    li.attr("class", "text-danger");
                    $("#注册").attr("disabled", true);
                }
            }
        });
    });
    $('input[name="email"]').keyup(function () {
        var xx;
        var iu = $('input[name="email"]');
        var li = $('label[for="inputEmail"]');
        $.ajax({
            url: "/SignlnRegister2_war_exploded/Email",
            type: "post",
            async: true,
            data: {email: iu.val()},
            success: function (data) {
                if (data == "false") {
                    li.text("邮箱");
                    li.attr("class", "");
                    $("#注册").attr("disabled", false);
                    $("#获取验证码").attr("disabled", false);
                } else {
                    xx = data;
                    li.text("邮箱重复");
                    li.attr("class", "text-danger");
                    $("#注册").attr("disabled", true);
                    $("#获取验证码").attr("disabled", true);
                }
            }
        });
    });
});
function yz() {
    var upwd = $('input[name="upwd"]');
    var opwd = $('input[name="opwd"]');
    var label = $('label[for="inputConfirmPassword"]');
    var yz;
    var code = $('label[for="inputCode"]');
    var li = $('label[for="inputUserame"]');
    var lableemail = $('label[for="inputEmail"]');
    if (trim(upwd.val()) !== trim(opwd.val())) {
        label.text("两次密码不一致");
        label.attr("class", "text-danger");
        return false;
    }
    if (trim(opwd.val()).length <6) {
        label.text("密码长度小于六个字符");
        label.attr("class", "text-danger");
        return false;
    }
    $.ajax({
        url: "/SignlnRegister2_war_exploded/UnameCode",
        type: "post",
        async: false,
        data: $('form').serialize(),
        success: function (data) {
            if (data == "false") {
                li.text("用户名");
                li.attr("class", "");
                $("#注册").attr("disabled", false);
            } else {
                yz = data;
                if (data =="true") {
                    li.text("用户名重复");
                    li.attr("class", "text-danger");
                    $("#注册").attr("disabled", true);
                }
                else if (data =="true1"){
                    lableemail.text("邮箱被更改");
                    lableemail.attr("class", "text-danger");
                    $("#注册").attr("disabled", true);
                }
                else if (data =="true3"){
                    lableemail.text("没有获取验证码");
                    lableemail.attr("class", "text-danger");
                    $("#注册").attr("disabled", true);
                }
                else {
                    code.text("验证码错误");
                    code.attr("class", "text-danger");
                }
            }
        }
    });
    if (yz == "true" ||yz =="true1"||yz =="true2"||yz =="true3") {
        return false;
    }
    alert("注册成功!请登陆");
    return true;
}
function yanZheng() {
    // var upwd = $('input[name="upwd"]');
    // var opwd = $('input[name="opwd"]');
    var label = $('label[for="inputConfirmPassword"]');
    label.text("确认密码");
    label.attr("class", "");

    // if (trim(upwd.val()) === trim(opwd.val())&&trim(opwd.val()).length>=6) {
    //     $("#注册").attr("disabled", false);
    //     label.text("确认密码");
    //     label.attr("class", "");
    //     return true;
    // }
    // else if (trim(opwd.val()).length <= 6) {
    //     $("#注册").attr("disabled", true);
    //     label.text("密码长度小于六个字符");
    //     label.attr("class", "text-danger");
    //     return false;
    // }
    // else {
    //     $("#注册").attr("disabled", true);
    //     label.text("两次密码不一致");
    //     label.attr("class", "text-danger");
    //     return false;
    // }
}

var wait = 60;

function time(btn) {
    var obj=$('input[name="email"]');
    if (wait == 0) {
        btn.removeAttribute("disabled");
        $("#获取验证码").text("获取验证码");
        obj.removeAttr("readonly");
        wait =60;
    } else {
        btn.setAttribute("disabled", true);
        $("#获取验证码").text("重新发送(" + wait + ")");
        wait--;
        setTimeout(function () {
                time(btn)
            },
            1000)
    }
}

//去掉前后空格
function trim(str) {
    return str.replace(/(^\s*)|(\s*$)/g, "");
}