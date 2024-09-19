document.addEventListener("DOMContentLoaded", function () {
    const flipContainer = document.getElementById("flip-card");

    // Add an event listener to flip the card only once
    flipContainer.addEventListener("mouseenter", function () {
        flipContainer.classList.add("flipped");
    });
});
