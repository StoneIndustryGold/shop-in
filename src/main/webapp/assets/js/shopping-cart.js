console.log('shopping-cart.js');//用来测试数据

$('.item-count').change(function() {//拿到jsp用class的民命链接change-修改。function-函数
    console.log('数量变了，发送ajax请求');//当函数被修改时显示数量变了
    
    var csrfParamName = $('meta[name="_csrf_parameter"]').attr('content');//防攻击
    var csrfParamValue = $('meta[name="_csrf"]').attr('content');//防攻击
    
    var data = {
    	cellponesId: $(this).data('cellpones-id'),//接受来自jsp页面的商品id
    	count: $(this).val()//接受jsp页面传来的数量
    };
    data[csrfParamName] = csrfParamValue;//防攻击
    
    $.ajax('/shop-in/uc/shopping-cart/update-item-count', {//跳转的路径工程名不要写错了
        method: 'POST',//本次提交事post提交
        data: data // 该data将以表单数据格式编码成文本（Content-Type: application/x-www-form-urlencoded）
    }).then(function(cart) {//then那么 function函数（cart）
        console.log('请求成功，更新总金额');
        console.log(cart);
        $('#totalCost').html(cart.totalCost / 100);//#拿到id链接用cart.总金额 
    }).fail(function() {
        console.error('请求失败');//不行就报错
    });
});