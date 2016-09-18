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
  $('#isdefcult ul li').click(function(){
      $('#isdefcult input').val($(this).html());})
});
$(function(){
  $('#isknowledge ul li').click(function(){
      $('#isknowledge input').val($(this).html());})
  
});

$(function(){
  $('#iscount ul li').click(function(){
      $('#iscount input').val($(this).html());})
});
$(function(){
  $('#ispractice ul li').click(function(){
      $('#ispractice input').val($(this).html());})
});
$(function(){
  $('#isdifficulty ul li').click(function(){
      $('#isdifficulty input').val($(this).html());})
});
$(function(){
  $('#iscareful ul li').click(function(){
      $('#iscareful input').val($(this).html());})
});
$(function(){
  $('#iscourse ul li').click(function(){
      $('#iscourse input').val($(this).html());})
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
