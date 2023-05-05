    let petID = 0;
    let shelterID = 0;
    let pets = [[${pets}]];
        function refreshPage(){
          window.setInterval(() => window.location.reload(), 200)  ;
        }

    function validateForm() {
      var x = document.forms["name"].value;
      if (x == "" || x == null) {
        alert("Name must be filled out");
        return false;
      }
    }

   function feedAllOrganicPets() {
        for (let i =0; i < pets.length; i++){
            let tempPet = pets[i];
            if (tempPet.type=='ORGANIC_CAT' || tempPet.type=='ORGANIC_DOG') {
            feed(tempPet.id);
            }
        }
    }

   function oilAllRoboticPets() {
        for (let i =0; i < pets.length; i++){
            let tempPet = pets[i];
            if (tempPet.type=='ROBOTIC_CAT' || tempPet.type=='ROBOTIC_DOG') {
            oil(tempPet.id);
            }
        }
    }

        function feed(petID) {
            let pet = pets.find(item=> item.id === petID);

            if (pet.type=='ORGANIC_DOG'){
                fetch("http://localhost:8080/api/organicDog/" + petID, {
                method: "PUT",
                    })
                .then((response) => response.json())
                .then((result) => {
                console.log("Success:", result);
                })
                .catch((error) => {
                console.error("Error:", error);
                });
            }

            if (pet.type=='ORGANIC_CAT')
            fetch("http://localhost:8080/api/organicCat/" + petID, {
            method: "PUT",
                })
            .then((response) => response.json())
            .then((result) => {
            console.log("Success:", result);
            })
            .catch((error) => {
            console.error("Error:", error);
            });

        }

        function oil(petID) {
            let pet = pets.find(item=> item.id === petID);

            if (pet.type=='ROBOTIC_DOG'){
                fetch("http://localhost:8080/api/roboticDog/" + petID, {
                method: "PUT",
                    })
                .then((response) => response.json())
                .then((result) => {
                console.log("Success:", result);
                })
                .catch((error) => {
                console.error("Error:", error);
                });
            }

            if (pet.type=='ROBOTIC_CAT')
            fetch("http://localhost:8080/api/roboticCat/" + petID, {
            method: "PUT",
                })
            .then((response) => response.json())
            .then((result) => {
            console.log("Success:", result);
            })
            .catch((error) => {
            console.error("Error:", error);
            });

        }

        function adopt(petID) {
            fetch("http://localhost:8080/api/organicDog/" + petID, {
            method: "DELETE",
                })
            .then((response) => response.json())
            .then((result) => {
            console.log("Success:", result);
            })
            .catch((error) => {
            console.error("Error:", error);
            });
        }
        function adoptOrganicCat(petID) {
            fetch("http://localhost:8080/api/organicCat/" + petID, {
            method: "DELETE",
                })
            .then((response) => response.json())
            .then((result) => {
            console.log("Success:", result);
            })
            .catch((error) => {
            console.error("Error:", error);
            });
        }
        function adoptRoboticDog(petID) {
            fetch("http://localhost:8080/api/roboticDog/" + petID, {
            method: "DELETE",
                })
            .then((response) => response.json())
            .then((result) => {
            console.log("Success:", result);
            })
            .catch((error) => {
            console.error("Error:", error);
            });
        }
        function adoptRoboticCat(petID) {
            fetch("http://localhost:8080/api/roboticCat/" + petID, {
            method: "DELETE",
                })
            .then((response) => response.json())
            .then((result) => {
            console.log("Success:", result);
            })
            .catch((error) => {
            console.error("Error:", error);
            });
        }

        function tick(shelterID) {
            fetch("http://localhost:8080/shelters/" + shelterID, {
            method: "PUT",
                })
            .then((response) => response.json())
            .then((result) => {
            console.log("Success:", result);
            })
            .catch((error) => {
            console.error("Error:", error);
            });
            window.location.reload();
        }

    timeLeft = 10;
    function countdown() {
        timeLeft--;
        document.getElementById("seconds").innerHTML = timeLeft + " seconds until next tick!";
        if (timeLeft > 0) {
            setTimeout(countdown, 1000);
        }
    };

    setTimeout(countdown, 1000);

    //every 10 seconds refresh the page and tick all pets
    window.setInterval(() => tick([[${shelter.id}]]), 10000)

        window.onload = function() {
                        localStorage.setItem("catchName", $('#petID').val());
                        }
                        let name = localStorage.getItem('catchName');
                        console.log('catchName');