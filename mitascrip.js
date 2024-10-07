document.addEventListener("DOMContentLoaded", function () {
    // Tab buttons for flight and check-in
    const flightTab = document.getElementById("flight-tab");
    const checkinTab = document.getElementById("checkin-tab");

    // Form sections
    const flightFormSection = document.getElementById("flight-form-section");
    const checkinFormSection = document.getElementById("checkin-form-section");

    // Tab buttons for trip types
    const oneWayTab = document.getElementById("one-way-tab");
    const roundTripTab = document.getElementById("round-trip-tab");
    const multiCityTab = document.getElementById("multi-city-tab");

    // Date input fields
    const returnDateGroup = document.querySelector(".return-group");

    // Get the search button, sidebar, and flight list
    const searchButton = document.querySelector(".submit-btn");
    const sidebar = document.getElementById("sidebar");
    const flightList = document.getElementById("flight-list");

    // Book Now buttons and trip details card
    const bookNowButtons = document.querySelectorAll(".book-now-btn");
    const tripDetailsCard = document.querySelector(".trip-details-card");

    // Function to switch between flight and check-in
    function activateMainTab(selectedTab) {
        flightTab.classList.remove("active");
        checkinTab.classList.remove("active");

        selectedTab.classList.add("active");

        if (selectedTab === flightTab) {
            flightFormSection.style.display = "block";
            checkinFormSection.style.display = "none";
        } else if (selectedTab === checkinTab) {
            flightFormSection.style.display = "none";
            checkinFormSection.style.display = "block";
        }
    }

    // Function to switch trip type tabs
    function activateFlightTab(selectedTab) {
        oneWayTab.classList.remove("active");
        roundTripTab.classList.remove("active");
        multiCityTab.classList.remove("active");

        selectedTab.classList.add("active");

        if (selectedTab === oneWayTab || selectedTab === multiCityTab) {
            returnDateGroup.style.display = "none";
        } else if (selectedTab === roundTripTab) {
            returnDateGroup.style.display = "block";
        }
    }

    // Function to update trip details
    function updateTripDetails(flightData) {
        document.getElementById("trip-from").textContent = flightData.from;
        document.getElementById("trip-to").textContent = flightData.to;
        document.getElementById("trip-departure").textContent = flightData.departure;
        document.getElementById("trip-return").textContent = flightData.return;
        document.getElementById("trip-class").textContent = flightData.class;
    }

    // Event listeners for main tabs
    flightTab.addEventListener("click", function () {
        activateMainTab(flightTab);
    });

    checkinTab.addEventListener("click", function () {
        activateMainTab(checkinTab);
    });

    // Event listeners for trip type tabs
    oneWayTab.addEventListener("click", function () {
        activateFlightTab(oneWayTab);
    });

    roundTripTab.addEventListener("click", function () {
        activateFlightTab(roundTripTab);
    });

    multiCityTab.addEventListener("click", function () {
        activateFlightTab(multiCityTab);
    });

    // Event listener for search button
    searchButton.addEventListener("click", function (event) {
        event.preventDefault(); // Prevent form submission (if needed)
        sidebar.style.display = "block"; // Show sidebar
        flightList.style.display = "block"; // Show flight list
    });

    // Event listener for Book Now button clicks
    bookNowButtons.forEach(function (button) {
        button.addEventListener("click", function () {
            // Get flight data from button attributes
            const flightData = {
                from: button.getAttribute("data-from"),
                to: button.getAttribute("data-to"),
                departure: button.getAttribute("data-departure"),
                return: button.getAttribute("data-return"),
                class: button.getAttribute("data-class"),
            };

            // Update the Trip Details card with selected flight info
            updateTripDetails(flightData);
            tripDetailsCard.style.display = "block";
            tripDetailsCard.scrollIntoView({ behavior: 'smooth' });
        });
    });
});