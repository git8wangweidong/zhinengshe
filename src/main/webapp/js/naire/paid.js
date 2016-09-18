var pay_order_id; //订单ID

//支付方法
var payment_Method = {
    orderConfirm: function(options) {
        var settings = {
            title: '支付确认',
            buyNum: '',
            payMoney: '',
            btnOKFn: '',
            btnCancelFn: '',
            marginLeft: 256
        };
        $.extend(settings, options);

        var htmlStr = '<div class="paid_mark"><div class="show_smallWrap" style="width:510px;left:50%;top:50%;margin-left:-' + settings.marginLeft + 'px; margin-top:-100px;"><div class="head_title"><p>' + settings.title + '</p><i class="small_close"></i></div><div class="small_wrap" style="width:auto;"><div class="small_content"><p class="default_p1">账号余额为：<span class="num_Warning">' + Number(settings.leave_money).toFixed(2) + '元</span>，系统将扣除<span class="num_Warning">' + Number(settings.payMoney).toFixed(2) + '元</span></p></div></div><div class="btn_wrap"><a class="btn_ok WJButton" href="javascript:;">确定</a><a class="btn_cancel WJButton uniteC" href="javascript:;">取消</a></div></div></div>';
        $('body').append(htmlStr);
        var $mark = $('body').find('.paid_mark');
        if (settings.btnOKFn) {
            $mark.on('click', '.btn_ok', function() {
                $mark.find(".btn_ok").removeClass("btn_ok");
                settings.btnOKFn();
            });
        }
        $mark.on('click', '.btn_cancel', function() {
            if (settings.btnCancelFn == '') {
                $mark.remove();
            } else {
                settings.btnCancelFn();
            }
        });
        $mark.on('click', '.small_close', function() {
            $mark.remove();
        });
    },
    goPay: function(options) {
        var settings = {
            title: '支付确认',
            needPay: '',
            btnOKFn: '',
            btnCancelFn: '',
            marginLeft: 256,
            type: ''  // 购买来源
        };
        $.extend(settings, options);

        var form_str = '<form name="onlinepay_form" id="onlinepay_form" action="/member/payredirect/" target="_blank" method="post"><input type="hidden" name="order_id" /><input type="hidden" name="_xsrf" /></form>';
        var payment_ul_str = '<div class="mt10"><p class="default_p2">请选择以下支付方式：</p><ul class="payment_ul"><li class="payment_mode"><div class="zfb payment" name="alipay"></div></li><li class="payment_mode mleft10"><div class="wx payment" name="wechatpay"></div></li></ul></div>';

        var htmlStr = '<div class="paid_mark"><div class="show_smallWrap" style="width:510px;left:50%;top:50%;margin-left:-' + settings.marginLeft + 'px; margin-top:-100px;"><div class="head_title"><p>' + settings.title + '</p><i class="small_close"></i></div><div class="small_wrap" style="width:auto;"><div class="small_content"><div><div class="plugin_choose_paid_type"><p class="default_p1">扣除账户余额（<span class="num_Warning">' + Number(settings.leave_money).toFixed(2) + '元</span>）后，需支付<span class="num_Warning">' + Number(settings.needPay).toFixed(2) + '元</span></p>' + payment_ul_str + form_str + '</div></div></div></div></div></div>';

        $('body').append(htmlStr);
        var $mark = $('body').find('.paid_mark');
        if(settings.btnOKFn){
            $mark.on('click','.payment_mode',function(){
                var pay_channel = $(this).find(".payment").attr("name");
                if (settings.type) {
                    if (pay_channel == 'alipay') {
                        _hmt.push(['_trackEvent', 'pluginAliPay', 'click', settings.type +'_pluginAliPay']);
                    }else{
                        _hmt.push(['_trackEvent', 'pluginWxPay', 'click', settings.type +'_pluginWxPay']);
                    }
                }
                var order_id = JSON.parse($.ajax({url:'/member/payorder/', type:'post', data: {'money':Number(settings.needPay).toFixed(2),'pay_channel':pay_channel,'_xsrf': getCookie('_xsrf')}, async:false}).responseText).order_id;
                $("#onlinepay_form input[name='order_id']").val(order_id);
                $("#onlinepay_form input[name='_xsrf']").val(getCookie('_xsrf'));
                $("#onlinepay_form").submit();
                pay_order_id = order_id;
                settings.btnOKFn();
            });
        }
        $mark.on('click', '.small_close', function() {
            $(".paid_mark").remove();
        });
    },
    payConfirm: function(options) {
        var settings = {
            title: '支付成功确认',
            payStatus: true,
            btnOKFn: '',
            btnCancelFn: '',
            marginLeft: 256
        };
        $.extend(settings, options);
        if (options.pay_order_id){
            pay_order_id = options.pay_order_id;
        }

        var contentHtml = '';
        if (settings.payStatus) {
            contentHtml = '<p class="p1">支付完成前，请勿关闭此窗口。</p><p class="p1">支付完成后，请根据支付情况点击以下按钮。</p><div class="paid_wrap"><a class="paidFailure" href="javascript:;">遇到问题</a><a class="paidSuccess" href="javascript:;" style="color:#53a4f4;">支付成功</a></div>';
        } else {
            contentHtml = '<p class="p1">您未完成支付。</p>';
        }
        var htmlStr = '<div class="paid_mark"><div class="show_smallWrap" style="width:510px;left:50%;top:50%;margin-left:-' + settings.marginLeft + 'px; margin-top:-100px;"><div class="head_title"><p>' + settings.title + '</p><i class="small_close"></i></div><div class="small_wrap" style="width:auto;"><div class="small_content"><div class="plugin_paid_confim">' + contentHtml + '</div></div></div></div></div>';
        $('body').append(htmlStr);
        var $mark = $('body').find('.paid_mark');
        if (settings.btnOKFn) {
            $mark.on('click', '.paidSuccess', function() {
                $mark.find(".paidSuccess").removeClass("paidSuccess");
                settings.btnOKFn();
            });
        }
        if (settings.btnCancelFn) {
            $mark.on('click', '.paidFailure', function() {
                window.open("/about/zxzx/");
                settings.btnCancelFn();
            });
        }
        $mark.on('click', '.small_close', function() {
            $(".paid_mark").remove();
        });
        var check_order_id = window.setInterval(check_order, 3000);

        function check_order() {
            getOrderStatus(function(data) {
                orderStatus = JSON.parse(data).order_status;
                if (orderStatus == 1) {
                    settings.btnOKFn();
                    // $(".paid_mark").remove();
                    window.clearInterval(check_order_id);
                }
            });
        }
    },
    markRemove: function() {
        $('.paid_mark').remove();
    }
};

//充值
var account_Recharge = {
    save_account: function(){
        window.location.href = '/member/mywallet';
        return;
    }
};

//购买短信
var sms_paid = {
    validationNum: function(obj, isDisc) {
        //没有第二个参数说明不能输入点
        if (isDisc) {
            obj.val(obj.val().replace(/[^\d.]/g, "")); //清除“数字”和“.”以外的字符
        } else {
            if (obj.attr('id') == "contactInfo") {
                obj.val(obj.val().replace(/[^\d-]/g, ""));
            } else {
                obj.val(obj.val().replace(/[^\d]/g, ""));
            }
        }
        obj.val(obj.val().replace(/^\./g, "")); //验证第一个字符是数字而不是.
        obj.val(obj.val().replace(/\.{2,}/g, ".")); //只保留第一个. 清除多余的.
        obj.val(obj.val().replace(".", "$#$").replace(/\./g, "").replace("$#$", "."));
    },
    buy_sms: function(buy_number) {
        $.ajax({
            url: '/member/buysms/',
            type: 'post',
            dataType: "JSON",
            data: {
                'number': buy_number,
                '_xsrf': getCookie('_xsrf')
            },
            success: function(ret) {
                if (ret.info != '') {
                    loadMack({
                        off: 'on',
                        Limg: 1,
                        text: ret.info,
                        set: 1000
                    });
                } else {
                    window.location.href = '/member/mywallet';
                    return;
                }
            }
        });
    }

};

//联系人发送短信
var Contacts = {
    send_sms: function() {
        var url = '/contact/sms/consume_to_send_sms/';
        var data = {
            '_xsrf': getCookie('_xsrf')
        };
        var $oMark = new idyC.loading({
            text: '发送中'
        });
        $oMark.open();
        idyC.ajaxPost(url, data, function(result) {
            $oMark.remove();

            var rsp_info = JSON.parse(result);
            var rsp_status = rsp_info.status;

            if (rsp_status == 'success') {
                window.location.href = '/contact/sms/showSMSTip';
                return;
            }
        });
    },
    send_sms_from_collect: function(){
        var url = '/sms/collect/consumetosend/';
        var data = {
            pid: project_id,
            '_xsrf': getCookie('_xsrf')
        };
        var $oMark = new idyC.loading({
            text: '发送中'
        });
        $oMark.open();
        idyC.ajaxPost(url, data, function(result) {
            $oMark.remove();

            var rsp_info = JSON.parse(result);
            var rsp_status = rsp_info.status;

            if (rsp_status == 'success') {
                window.location.href = '/collect/sendsms/' + project_id + '/';
                return;
            }
        });
    }
};

//题型购买
var question_paid = {
    bay_question: function(options) {
        $.ajax({
            "url": "/plugin/ajax/consume/",
            "type": "POST",
            "dataType": "JSON",
            "async": false,
            "data": {
                'plugin_id_list': options.calTypeList,
                'month_count': options.month_count,
                '_xsrf': getCookie('_xsrf')
            },
            success: function(data) {
                if (!data.info) {
                    var success_list = [];
                    paidSuccessFun(data);
                } else {
                    unlockPaid.showSmallWrap({
                        title: '提示',
                        contentHtml: data.info,
                        type: 'alert'
                    });
                }
                $('body').find('.paid_mark').remove();
            }
        });
    }
};

//有偿收集
var paid_Collection = {
    save_pconvert: function(pid, costInfo) {
        getConditionData();
        var getdata = JSON.stringify(conditionData);
        $.ajax({
            url: '/collect/paid/' + pid,
            data: {
                act: 'comfirm_order',
                data: getdata,
                c_id: costInfo.zkqOid,
                use_ticket: costInfo.syqVal,
                c_type: costInfo.c_type,
                "_xsrf": getCookie('_xsrf')
            },
            dataType: "JSON",
            type: "POST",
            timeout: 15000,
            success: function(ret) {
                console.log(ret.status);
                if (ret.status == "200") {
                    window.location.href = '/collect/paid/' + pid;
                } else {
                    loadMack({
                        off: 'on',
                        Limg: 1,
                        text: '网络繁忙，请稍后再试！',
                        set: 1000
                    });
                }
            }
        });
    }
};

//支付请求
function getOrderStatus(successCallback) {
    $.ajax({
        url: '/member/validatepayorder/',
        type: 'post',
        data: {
            'order_id': pay_order_id,
            '_xsrf': getCookie('_xsrf')
        },
        success: successCallback
    });
}