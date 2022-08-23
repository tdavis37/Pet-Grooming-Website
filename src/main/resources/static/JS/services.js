/*alert("services.petgrooming.com wants to know your location");


$('nav .button').click(function(){
    $('nav .button span').toggleClass("rotate");
  });
    $('nav ul li .first').click(function(){
      $('nav ul li .first span').toggleClass("rotate");
    });
    $('nav ul li .second').click(function(){
      $('nav ul li .second span').toggleClass("rotate");
    });*/
    
function bookNowClick (event) {
	var cmbPetType = document.getElementById("cmbPetType");
	var petType = cmbPetType.options[cmbPetType.selectedIndex].value;
	if(petType == -1) {
		alert("Please select Pet Type");
		return;
	}
	var cmbBreed = document.getElementById("cmbBreed");
	var breed = cmbBreed.options[cmbBreed.selectedIndex].value;
	if(breed == -1) {
		alert("Please select Breed");
		return;
	}
	var cmbAge = document.getElementById("cmbAge");
	var age = cmbAge.options[cmbAge.selectedIndex].value;
	if(age == -1) {
		alert("Please select Age");
		return;
	}
	
	window.location.href = `registerproduct?petType=${petType}&breed=${breed}&age=${age}`;
}
