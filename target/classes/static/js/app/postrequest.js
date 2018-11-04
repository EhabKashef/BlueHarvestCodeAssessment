$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#accountForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		
		
		
		if(isNaN(parseFloat($("#initialCredit").val())) )
		{
			$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:red; padding:20px 20px 20px 20px'>" + 
			"Invalid Amount! <br>" );

		}else{
			$("#postResultDiv").html();
			ajaxPost();
			
		}
		
		
		
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    			initialCredit : $("#initialCredit").val(),
    			customerID :  $("#custId").val()
    	}
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url :  "/BlueHarvestAssessment/api/account/",
			data : JSON.stringify(formData),
			 
			success : function(result) {
				 
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>" );
			 
			 
			},
			error : function(e) {
				alert("Error!"+ e)
				//console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    
    
    
    
    
    
    function resetData(){
    	$("#initialCredit").val("");
    	setTimeout(function () { location.reload(true); }, 1000);
    }
    
    
    
    
  //----------------- trans  
    
    
    
    $("#transactionForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		
		if(isNaN(parseFloat($("#amount").val())) || $("#amount").val()==0)
		{
			$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:red; padding:20px 20px 20px 20px'>" + 
			"Invalid Amount! <br>" );

		}else{
			$("#postResultDiv").html();
			ajaxPosttransactionForm();
			
		}
		
		
		
	});
    
    
    function ajaxPosttransactionForm(){
    	
    	// PREPARE FORM DATA
    	var formDatatransaction = {
    			amount : $("#amount").val(),
    			account : { id :$("#accountId").val()} 
    	}
    	 
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url :  "/BlueHarvestAssessment/api/transaction/",
			data : JSON.stringify(formDatatransaction),
			 
			success : function(result) {
				 
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>" );
			 
			 
			},
			error : function(e) {
				alert("Error!"+ e)
				//console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetDatatransactionForm();

    }
    
    
    
    
    
    
    
    function resetDatatransactionForm(){
    	$("#amount").val("");
    	setTimeout(function () { location.reload(true); }, 1000);
    }
    
    
    
    
    function getAccountsTransactions(id) {
        console.log('Fetching User with id :'+id);
         
        window.location.replace(urls.BASE + "/getaccounts/"+id);
      
    }
    
    
    
    
})