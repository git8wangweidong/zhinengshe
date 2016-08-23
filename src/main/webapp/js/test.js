$(function(){
    $('#ispeed ul li').click(function(){
      $('#ispeed input').val($(this).html());
   
    // $.ajax({
    //   url:"",
    //   type:"post",
    //   data:{},
    //   dataType:"json",
    //   success:function(data){

    //   },error:function(err){
    //     // showMsg();
    //   }
    // })
  });
});


$(function(){
  $('.getval ul li').click(function(){
      $(this).parent().parent().find('input').eq(1).val($(this).html());})
});

$(function(){
                   if(window.hasOwnProperty("ontouchstart")) {
                  var _event = 'touchend';
                }else {
                  var _event = 'click';
              }
              var base={
                      inIt:function(){
                       this.bGs();
                      },
                      bGs:function(){
                           var ulli=$(".ulcont  li");
                           ulli.on(_event,function(){
                                $(this).addClass('libgs').siblings('li').removeClass('libgs');
                               
                           })

                      }
              }
              base.inIt();
      })
