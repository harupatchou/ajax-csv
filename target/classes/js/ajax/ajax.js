$(function(){
        $("#response").html("Response Values");

        $("#ajaxInsert").click( function(){

        	var JSONdata = {
                	name: $("#shopName").val(),
                	categoryId: $("#cateHiddenId1").val(),
                	address: $("#shopAddress").val(),
                	detail: $("#shopDetail").val()
                };

            /*alert(JSON.stringify(JSONdata));*/

            $.ajax({
                type : 'post',
                url : '/shop/ajax',
                dataType : 'json',
                data : JSON.stringify(JSONdata),
                contentType: 'application/JSON',
                scriptCharset: 'utf-8'
            }).done(function(data) {
                    // Success
                    alert("success");
                    alert(JSON.stringify(data));
                    $("#response").html(JSON.stringify(data));
            }).fail(function(data) {

                    // Error
                	 $('#ajaxRe').load('/shop/insertAjaxIndex');
            });
        })
        
         $("#ajaxSearch").click( function(){

        	var JSONdata = {
                	name: $("#ajaxData").val(),
                	categoryId: $("#").val(),
                	address: $("#").val(),
                	no: $("#").val()
                };

            /*alert(JSON.stringify(JSONdata));*/

            $.ajax({
                type : 'post',
                url : '/shop/ajaxSearch',
                dataType : 'json',
                data : JSON.stringify(JSONdata),
                contentType: 'application/JSON',
                scriptCharset: 'utf-8'
            }).done(function(data) {
                    // Success
                    alert("success");
                    alert(JSON.stringify(data));
                    $("#response").html(JSON.stringify(data));
            }).fail(function(data) {

                    // Error
                	 $('#ajaxSe').load('/shop/searchAjaxIndex');
            });
        })
        
        
    });
    
   