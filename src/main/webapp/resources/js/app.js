/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 function activarMenu(menu){
                    
                    $("[href$='/tpfmz"+menu+"']").parent().addClass("active");
                    validacionesHtml5();
                };
   
  function validacionesHtml5(){
      addRequerido();
  }
  function addRequerido(){
      
      $("[type='text']").attr("required",true);
      $("[type='password']").attr("required",true);
      
  }

