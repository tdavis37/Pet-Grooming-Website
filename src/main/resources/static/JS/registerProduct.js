var baserServerURL = "http://localhost:8080";

function initialize() {
	var queryString = window.location.search;
	var urlParams = new URLSearchParams(queryString);
	var petType =  urlParams.get("petType");
	var breed =  urlParams.get("breed");
	var age =  urlParams.get("age");
	console.log(petType,breed,age);
	resultFromServer({type: petType,breed: breed,age: age}).then(data => {
		console.log(data)
		if(data && data.length) {
			renderData(data);
		}
		else {
			console.log("No Record Found");
		}
	}) ;
}

function renderData(arrRows) {
	var tblBody = document.getElementById("tblDataBody");
	tblBody.innerHTML = "";
	arrRows.forEach(data => {
		var row = document.createElement("tr");
		var index = 0;
		var cell = row.insertCell(index++);
		cell.innerHTML = data.id;
		cell = row.insertCell(index++);
		cell.innerHTML = data.pettype;
		cell = row.insertCell(index++);
		cell.innerHTML = data.breed;
		cell = row.insertCell(index++);
		cell.innerHTML = data.age;
		tblBody.appendChild(row);
	});
}

async function resultFromServer(item) {
	const res = await fetch(baserServerURL + "/findByTypeBreedAge",{
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(item)
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

//initialize();