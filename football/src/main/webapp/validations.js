/**
 * 
 */
 //validation file
            
           //validation flags 
            var showbtnchk = false;
            var showbtnrad = false;
            var firstname = false;
            var lastname = false;
            var emailid = false;
            var phoneno = false;
            var pinflag = false;
            var addressflag = false;

            // validation for Age list
            document.getElementById("agelist").oninput = function(){
                canSubmit();
                canUpdate();
            }
            // validation for Country list
            document.getElementById("country").oninput = function(){
                
                canSubmit();
            }
            // validation for State list
            document.getElementById("state").oninput = function(){
                
                canSubmit();
            }
            // validation for City list
            document.getElementById("city").oninput = function(){
                
                canSubmit();
            }
            
            document.getElementById("addresstextbox").oninput =function(){
				canUpdate();
			}
			

            // validation function for radio buttons which will run on onclick
            function checkRadio(){
                var getSelectedValue = document.querySelector(   
                'input[name="desiredteam"]:checked');
                if(getSelectedValue != null){
                    showbtnrad = true;
                    canSubmit();
                    console.log(showbtnrad);
                }
                else{
                    showbtnrad = false;
                    console.log(showbtnrad);
                    canSubmit();
                }
            
            }
            
           
            
            // validation function for check buttons which will run on onclick
            function checkButton() {    
            var getSelectedValue = document.querySelector(   
                'input[name="pos"]:checked');
                if(getSelectedValue != null){
                    showbtnchk = true;
                    canSubmit();
                    console.log(showbtnchk);
                }
                else{
                    showbtnchk = false;
                    console.log(showbtnchk);
                    canSubmit();
                }
            }

            // validation for first name
            document.getElementById("firstName").oninput= function() {
                var regName = /^[a-zA-Z]+$/;
                var fname = document.getElementById('firstName').value;
                if(fname ===""){
                    document.getElementById("first_name_err").innerHTML="This field cant be left empty";
                    document.getElementById("firstName").style.borderColor="red";
                    firstname = false;
                    
                }else if(!regName.test(fname)){
                    document.getElementById("first_name_err").innerHTML="First name can't have spaces or numbers";
                    document.getElementById("firstName").style.borderColor="red";
                    firstname = false;
                }
                
                else{
                    firstname = true;
                    
                    canSubmit();
                    
                    document.getElementById("first_name_err").innerHTML="";
                    document.getElementById("firstName").style.border="1px solid grey";
                    console.log(firstname);
                }
            }

            // validation for last name
            document.getElementById("lname").oninput= function() {
                var regName = /^[a-zA-Z\s]*$/;
                var lname = document.getElementById('lname').value;
                if(lname ===""){
                    document.getElementById("last_name_err").innerHTML="This field cant be left empty";
                    document.getElementById("lname").style.borderColor="red";
                    lastname = false;
                    
                }

                else if(!regName.test(lname)){
                    document.getElementById("last_name_err").innerHTML="Last name can't have numeric value";
                    document.getElementById("lname").style.borderColor="red";
                    lastname = false;
                    
                }
                
                else{
                    canSubmit();
                    canUpdate();
                    document.getElementById("last_name_err").innerHTML="";
                    document.getElementById("lname").style.border="1px solid grey";
                    lastname = true;
                    console.log(lastname);
                }
            }

            // validation for phone number
            document.getElementById("pno").oninput= function() {
                var regName = /^\d{10}$/;
                var no = document.getElementById('pno').value;
                if(no ===""){
                    document.getElementById("pno_err").innerHTML="This field cant be left empty";
                    document.getElementById("pno").style.borderColor="red";
                    phoneno = false;
                    
                }
                else if(!regName.test(no)){
                    document.getElementById("pno_err").innerHTML="Phone No. must be a 10 digit numeric value";
                    document.getElementById("pno").style.borderColor="red";
                    phoneno = false;
                    
                }
                
                else{
                    canSubmit();
                    canUpdate();
                    document.getElementById("pno_err").innerHTML="";
                    document.getElementById("pno").style.border="1px solid grey";
                    phoneno = true;
                    console.log(phoneno);
                }
            }

            // validation for Email ID
            document.getElementById("email").oninput= function() {
                var x = document.myform.email.value;
                var atpos = x.indexOf("@");
                var dotpos = x.lastIndexOf(".");
                if(x ===""){
                    document.getElementById("email_err").innerHTML="This field cant be left empty";
                    document.getElementById("email").style.borderColor="red";
                    emailid = false;
                    
                }
                else if(atpos<1 || dotpos<atpos+2 || dotpos+2>= x.length){
                    document.getElementById("email_err").innerHTML="Enter a valid Email ID";
                    document.getElementById("email").style.borderColor="red";
                    emailid = false;
                    
                }
                 
                else{
                    canSubmit();
                    canUpdate();
                    document.getElementById("email_err").innerHTML="";
                    document.getElementById("email").style.border="1px solid grey";
                    emailid = true;
                    console.log(emailid);
                }
            }

            // validation for PIN Number
            document.getElementById("pin").oninput= function() {
                var regName = /^\d{6}$/;
                var pin = document.getElementById('pin').value;
                if (pin ===""){
                    document.getElementById("pin_err").innerHTML="";
                    document.getElementById("pin").style.borderColor="grey";
                }
                else if(!regName.test(pin)){
                    document.getElementById("pin_err").innerHTML="pin must be of 6 digits";
                    document.getElementById("pin").style.borderColor="red";
                    
                }
                
                else{
                    canSubmit();
                    canUpdate();
                    document.getElementById("pin_err").innerHTML="";
                    document.getElementById("pin").style.border="1px solid grey";
                }
            }

            // toggle button enable disable
            document.getElementById("togglebtn").onclick= function(){
                if(document.getElementById("email").hasAttribute("disabled")){
                    document.getElementById("email").disabled=false;
                }
                else {
                    document.getElementById("email").disabled=true;
                }
            }
            
                // Function to enable and disable submit button
                function canSubmit(){ 
                    if(firstname==true && lastname==true && emailid==true && phoneno==true && 
                        document.getElementById("agelist").value !="" &&
                        document.getElementById("country").value !=""&&
                        document.getElementById("city").value !=""&&
                        document.getElementById("state").value !="" && showbtnchk==true && showbtnrad==true)
                        {

                        document.getElementById("submitbtn").disabled=false;
                        
                        }
                    else{
                    document.getElementById("submitbtn").disabled=true;
                    
                    }
                }
                // After Submission message
                $('form').on('submit',function(){
                    alert('YOUR RESPONSE HAS BEEN SUBMITTED');
                });