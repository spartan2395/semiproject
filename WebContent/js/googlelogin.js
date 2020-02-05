

  var googleUser = {};
  var startApp = function() {
    gapi.load('auth2', function(){
      // Retrieve the singleton for the GoogleAuth library and set up the client.
      auth2 = gapi.auth2.init({
        client_id: '261347811871-g4ri915lfl53tn24smcrch9r9fcr7dtm.apps.googleusercontent.com',
        cookiepolicy: 'single_host_origin',
        // Request scopes in addition to 'profile' and 'email'
        //scope: 'additional_scope'
      });
      attachSignin(document.getElementById('google'));
    });
  };
 
  function attachSignin(element) {
    console.log(element.id);
    auth2.attachClickHandler(element, {},
        function(googleUser) {
              var i = googleUser.getBasicProfile().getEmail();
              if(document.getElementById("formtag").getAttribute("action") == "MemberServlet"){
            	  location.href = "MemberServlet?command=googlelogin&email="+i;
              }else{
            	  location.href ="DoctorServlet?command=googlelogin&email="+i;
              }
        }, function(error) {
          alert(JSON.stringify(error, undefined, 2));
        });
  }