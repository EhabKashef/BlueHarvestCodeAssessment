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
        <div class="panel-heading"><span class="lead">Create Account For Customer ID #${id}</span></div>
        
        
        
		<div class="panel-body">
	        <div class="formcontainer">
	        <div id="postResultDiv"></div>
			
<form name="account" id="accountForm" action="add" method="post" class="form-horizontal">

			            
	    <input type="hidden" id="custId"   value="${id}">

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="initialCredit">initialCredit</label>
	                        <div class="col-md-7">
	                        	<input type="text" class="form-control input-sm" id="initialCredit" placeholder="Enter initialCredit"/>

							
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
        <div class="panel-heading"><span class="lead">List of Accounts </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>InitialCredit</th>
		                <th width="150"></th>
		            
		            </tr>
		            </thead>
		            <tbody>
		           
					
						<#if accounts?has_content>
		 
			<#list accounts as u>
				 
				
				 <tr >
		                <td>${u.getId()}</td>
		                <td>${u.getInitialCredit()}</td>
		                <td><button onclick="window.location.href='/BlueHarvestAssessment/gettransactins/${u.getId()}'" type="button"  class="btn btn-success custom-width">Transactions</button> </td>
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