$(document).ready(function(){
$(document).on('click','.eliminar',function(){
                 var bton=$('.eliminar').index(this);
        var docu=$('.codi').eq(bton).val();
          var nom=$('.nomb').eq(bton).val();
         var cla=$('.clav').eq(bton).val();
         var rol=$('.role').eq(bton).val();
         var sex=$('.sexo').eq(bton).val();
         var est=$('.esta').eq(bton).val();
        var ema=$('.emai').eq(bton).val();
         var tel=$('.tele').eq(bton).val();



            $.ajax({
             url:'ServletEliminar',
             data:{
                 dd:docu,
                 nn:nom,
                 cc:cla,
                 rr:rol,
                 ss:sex,
                 ee:est,
                 em:ema,
                 te:tel
                        
             },
             success:function(result){
                 $("#res").html(result);
                 cargar();
             }
                    
         });
         
         
         
         
         
});

});
function cargar(){
    $.ajax({
        url:"ServletConsultaUsuarios",
        success:function(result){
            $('#res').html(result);
        }
    });
};