var baserServerURL = "http://localhost:8080";

function swap(referTo) {
    if(referTo.getAttribute("data-tab") == "login"){
        document.getElementById("form-body").classList.remove('active');
        referTo.parentNode.classList.remove('signup');
      } else {
        document.getElementById("form-body").classList.add('active');
        referTo.parentNode.classList.add('signup');
      }
}

function authenticate() {
		var username = document.getElementById("txtEmail").value;
		var password = document.getElementById("txtPassword").value;
		if(username && password) {
			authFromServer(username,password).then(data => {
				console.log(data)
			if(data && data.id) {
				alert("Login Successful!");
				window.location.replace("servicesDC");
			}
			else {
				alert("Sorry, we couldn't find your account.");
			}
			}) ;
			
		}
		else {
			alert("Please enter username and password");
		}
		
}

async function authFromServer(username,password) {
	const res = await fetch(baserServerURL + "/app/authenticate",{
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({username: username,password: password})
	});
	if(res && res.json) {
		try {
			var data = await res.json();
		return data;
		}
		catch(e) {
			
		}
	}
	return null;
}

function register() {
	var firstName = document.getElementById("txtFirstName").value;
	var lastName = document.getElementById("txtLastName").value;
	var email = document.getElementById("txtRegEmail").value;
	var password = document.getElementById("password").value;
	var reenterPassword = document.getElementById("txtRegReenterPassword").value;
	if(!firstName) {
		alert("Please enter First Name");
	}
	else if(!lastName) {
		alert("Please enter Last Name");
	}
	else if(!email) {
		alert("Please enter Email");
	}
	else if(!password) {
		alert("Please enter Password");
	}
	else if(!reenterPassword) {
		alert("Please enter Re-enter Password");
	}
	else if(password !== reenterPassword) {
		alert("Password and Re-enter Password should be same");
	}
	else {
		var customer = {email: email,password: password,firstName: firstName,lastName: lastName};
		registerFromServer(customer).then(data => {
				console.log(data)
				if(data && data.id) {
					alert("User registered successfully!");
				}
			}) ;
	}
}

async function registerFromServer(customer) {
	const res = await fetch(baserServerURL + "/app/register",{
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(customer)
	});
	var data = await res.json();
	return data;
}

async function authFromServer(username,password) {
	const res = await fetch(baserServerURL + "/app/authenticate",{
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({username: username,password: password})
	});
	if(res && res.json) {
		try {
			var data = await res.json();
		return data;
		}
		catch(e) {
			
		}
	}
	return null;
}

// keeps track of every movement on the keyboard
var pass = document.getElementById("password");
    var pass = document.getElementById("password");
    pass.addEventListener('keyup', function() {
        checkPassword(pass.value);
    })
//actually checks for password validation
    function checkPassword(password) {
        var strenghthBar = document.getElementById("strength");
        //default strength set here
        var strength = 0;
        //if keys match any of the expressions below A through Z upper or lower 0 through 9, it adds to strength
        if(password.match(/[a-zA-Z0-9][a-zA-Z0-9]+/)) {
            strength += 1;
        }
        //if keys match any of the expressions below of ~<>?,  it adds to strength
        if (password.match(/[~<>?]+/)) {
            strength += 1;
        }
        if (password.match(/[!@$^&*()]+/)) {
            strength +=1;
        }
        if (password.length > 5) {
            strength += 1;
        }

        switch(strength) {
            case 0: 
                strenghthBar.value = 20;
                break;
            case 1:
                strenghthBar.value = 40;
                break;
            case 2:
                strenghthBar.value = 60;
                break;
            case 3:
                strenghthBar.value = 80;
                break;
            case 4:
                strenghthBar.value = 100;
                break;
        }
    }
   