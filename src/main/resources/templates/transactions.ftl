<!DOCTYPE html>
<html lang ="en">
 <head>
        <title>${title}</title>
        <link href="/BlueHarvestAssessment/css/bootstrap.css" rel="stylesheet"/>
         
        <link href="/BlueHarvestAssessment/css/app.css" rel="stylesheet"/>
              <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  		<script src="/BlueHarvestAssessment/js/app/postrequest.js"></script>

    </head>
<body>
 	
  	<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Make Transaction With Account ID #${id}</span></div>
        
        
        
		<div class="panel-body">
	        <div class="formcontainer">
	        <div id="postResultDiv"></div>
			
<form name="transaction" id="transactionForm" action="add" method="post" class="form-horizontal">

			            
	    <input type="hidden" id="accountId"   value="${id}">

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="amount">Amount</label>
	                        <div class="col-md-7">
	                        	<input type="text" class="form-control input-sm" id="amount" placeholder="Enter amount"/>

							
							</div>
	                    </div>
	                </div>
	
	              

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="Create" class="btn btn-primary btn-sm" >
	                        
	                    </div>
	                </div>
  		</form>
			
			
	                 
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Transactions </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>Amount</th>
		       
		            
		            </tr>
		            </thead>
		            <tbody>
		           
					
						<#if transactions?has_content>
		 
			<#list transactions as u>
				 
				
				 <tr >
		                <td>${u.getId()}</td>
		                <td>${u.getAmount()}</td>
		             
		            </tr>
				
				
				
			</#list>
		 
	<#else>
		
	</#if>
					
					
					
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
     <div class="row">
	                    <div class="form-actions floatRight">
 	                        <button onclick="window.location.href='/BlueHarvestAssessment/'" type="button"  class="btn btn-primary btn-sm">HOME</button> 
	                        
	                    </div>
	                </div>
</div>
  	
  	
  	
</body>
</html>