$(document).ready(function(){
    alert("entro a js cita");
$(document).on('click','.btn_actu_cita',function(){
                 var bton=$('.btn_actu_cita').index(this);
        var cod=$('.cod').eq(bton).val();
         



            $.ajax({
             url:'ServletActualizarCita',
             data:{
                 cc:cod
                 
                        
             },
             success:function(result){
                 cargar();
             }
                    
         });
         
         
         
         
         
});
});


