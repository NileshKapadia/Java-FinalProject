/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    

$("#reg").click(function (e) {
       e.preventDefault();
alert('get js');
       var imgvalid = false;
       var formURL = "/photoupload";
       //var data = $("#myform").serialize();
       var jForm = new FormData();
       jForm.append("caption", $('#caption').val());
      // jForm.append("pass", $('#pass').val());
       // jForm.append("image", $('#image').val());

       jForm.append("image", $('#image').get(0).files[0]);
       var imgname = $("#image").val();
       var name = $("#caption").val();
      // var pass = $("#pass").val();
       var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png"];
       if (imgname.length > 0)
       {
           for (var j = 0; j < _validFileExtensions.length; j++) {
               var sCurExtension = _validFileExtensions[j];
               if (imgname.substr(imgname.length - sCurExtension.length, sCurExtension.length).toLowerCase() === sCurExtension.toLowerCase()) {

                   imgvalid = true;



               }

           }
       }



       if (imgvalid !== true)
       {
           alert('plaese emter the right image');
       }
    
       else if (name === "")
       {
           alert('username field cannot be empty');
       }
       else {
           alert("in else  get");
           $.ajax({
                  url: formURL,
                  type: "GET",
                 
                  processData: false,
                  contentType: false,
                  cache: false,
                  //processData: false,
                  success: function (data, textStatus, jqXHR) {
                      alert(data);
                     
                      if(data==="done")
                      {
                          alert('Your Image has been Uploaded');
                      }
                      },
                        error: function(jqxhr, status, errorMsg) {
                 alert('Failed! ' + errorMsg);
                   }
                
              });
       }



   });
   });




