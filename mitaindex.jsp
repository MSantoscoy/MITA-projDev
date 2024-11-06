<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flight Booking @ MITA </title>
    <link rel="stylesheet" href="/mitastyle.css">

</head>

<body>
    <!-- Navigation Bar -->
    <nav class="navbar">
        <div class="logo">MITA</div>
        <ul class="nav-links">
            <li><a href="#">Home</a></li>
            <li><a href="#">Log In</a></li>
            <li><a href="#">Contact Us</a></li>
        </ul>
    </nav>

    <!-- intro Section -->
    <section class="intro">
        <div class="intro-content">
            <h1>Welcome to MITA</h1>
            <p>Book your dream flight</p>
        </div>
    </section>

    <!-- Book/Check-in Tabs -->
    <div class="container">
        <div class="main-tabs">
            <button id="flight-tab" class="tab active">Flight</button>
            <button id="checkin-tab" class="tab">Check-in</button>
        </div>

        <!-- Flight Booking Section -->
        <div id="flight-form-section" class="form-section">
            <div class="booking-tabs">
                <button id="one-way-tab" class="tab active">One Way</button>
                <button id="round-trip-tab" class="tab">Return</button>
                <button id="multi-city-tab" class="tab">Multi City</button>
            </div>

            <form class="flight-form">
                <!-- Trip type forms -->
                <div class="form-group">
                    <div class="input-group">
                        <label for="from-location">From:</label>
                        <input type="text" id="from-location" placeholder="Enter departure city">
                    </div>
                    <div class="input-group">
                        <label for="to-location">To:</label>
                        <input type="text" id="to-location" placeholder="Enter destination city">
                    </div>
                </div>

                <!-- Date Fields (One-Way/Return) -->
                <div class="form-group">
                    <div class="input-group">
                        <label for="departure-date">Departure Date:</label>
                        <input type="date" id="departure-date">
                    </div>
                    <div class="input-group return-group">
                        <label for="return-date">Return Date:</label>
                        <input type="date" id="return-date">
                    </div>
                </div>

                <!-- Passengers -->
                <div class="form-group">
                    <div class="input-group">
                        <label for="passengers">Passengers:</label>
                        <input type="number" id="passengers" min="1" value="1">
                    </div>
                </div>

                <!-- Submit Button -->
                <button type="submit" class="submit-btn">Search Flights</button>
            </form>
        </div>

        <!-- Check-in Section -->
        <div id="checkin-form-section" class="form-section" style="display:none;">
            <h2>Check-in</h2>
            <form class="checkin-form">
                <!-- Booking reference or e-ticket -->
                <div class="form-group">
                    <div class="input-group">
                        <label for="booking-reference">Booking Reference / E-ticket number:</label>
                        <input type="text" id="booking-reference" placeholder="Enter booking reference or e-ticket">
                    </div>
                </div>

                <!-- Last name -->
                <div class="form-group">
                    <div class="input-group">
                        <label for="last-name">Last Name:</label>
                        <input type="text" id="last-name" placeholder="Enter your last name">
                    </div>
                </div>

                <!-- Submit Button -->
                <button type="submit" class="submit-btn">Check-in</button>
            </form>
        </div>
    </div>

    <div class="container">

        <!-- Sidebar for filtering options -->

        <aside id="sidebar" class="sidebar" style="display: none;">
            <h2>Filter Flights</h2>
            <div class="filter-group">
                <label for="price-range">Price Range</label>
                <input type="range" id="price-range" name="price-range" min="100" max="2000">
            </div>
            <div class="filter-group">
                <label for="airline">Airlines</label>
                <select id="airline" name="airline">
                    <option value="any">Southwest Airlines</option>
                    <option value="delta">Delta Airlines</option>
                    <option value="american">American Airlines</option>
                    <option value="spirit">Spirit Airways</option>
                    <option value="spirit">Any</option>
                </select>
            </div>
            <button class="filter-btn">Apply Filters</button>
        </aside>

        <!-- Flight Selection List -->
        <div class="flight-selection-list">
            <div class="flight-option">
                <h3>Flight Option 1</h3>
                <p>From: LAX - Los Angeles</p>
                <p>To: AMD - Ahmedabad</p>
                <p>Departure: October 13, 2024</p>
                <p>Return: October 30, 2024</p>
                <button class="book-now-btn" data-from="LAX - Los Angeles" data-to="AMD - Ahmedabad"
                    data-departure="October 13, 2024" data-return="October 30, 2024" data-class="Economy">Book
                    Now</button>
            </div>
            <!-- Add more flight options here -->
            <div class="flight-selection-list">
                <div class="flight-option">
                    <h3>Flight Option 1</h3>
                    <p>From: LAX - Los Angeles</p>
                    <p>To: JFK - New York</p>
                    <p>Departure: October 13, 2024</p>
                    <p>Return: October 30, 2024</p>
                    <button class="book-now-btn" data-from="LAX - Los Angeles" data-to="AMD - Ahmedabad"
                        data-departure="October 13, 2024" data-return="October 30, 2024" data-class="Economy">Book
                        Now</button>
                </div>
            </div>

            <!-- Trip Details Card -->
            <div class="trip-details-card" style="display: none;">
                <h2>Trip Details</h2>
                <div class="trip-info">
                    <div class="trip-info-item">
                        <span>From:</span>
                        <strong id="trip-from"></strong>
                    </div>
                    <div class="trip-info-item">
                        <span>To:</span>
                        <strong id="trip-to"></strong>
                    </div>
                    <div class="trip-info-item">
                        <span>Departing:</span>
                        <strong id="trip-departure"></strong>
                    </div>
                    <div class="trip-info-item">
                        <span>Returning:</span>
                        <strong id="trip-return"></strong>
                    </div>
                    <div class="trip-info-item">
                        <span>Class:</span>
                        <strong id="trip-class"></strong>
                    </div>
                </div>
            </div>

            <!-- Passenger Details Section -->
            <div id="passenger-details" class="container passenger-details" style="display: none;">
                <h2>Who's Travelling?</h2>
                <form class="passenger-form">
                    <!-- Passenger 1 -->
                    <div class="form-group">
                        <div class="input-group">
                            <label for="passenger-name">Passenger Name:</label>
                            <input type="text" id="passenger-name" placeholder="Enter full name">
                        </div>
                        <div class="input-group">
                            <label for="passenger-dob">Date of Birth:</label>
                            <input type="date" id="passenger-dob">
                        </div>
                    </div>

                    <!-- Gender -->
                    <div class="form-group">
                        <div class="input-group">
                            <label for="gender">Gender:</label>
                            <select id="gender">
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="other">Other</option>
                            </select>
                        </div>
                    </div>

                    <!-- Contact Information -->
                    <div class="form-group">
                        <div class="input-group">
                            <label for="email">Email Address:</label>
                            <input type="email" id="email" placeholder="Enter your email">
                        </div>
                        <div class="input-group">
                            <label for="phone">Phone Number:</label>
                            <input type="tel" id="phone" placeholder="Enter your phone number">
                        </div>
                    </div>

                    <!-- Submit Button -->
                    <button type="submit" class="submit-btn">Proceed to Payment</button>
                </form>
            </div>


            <!-- Footer -->
            <footer>
                <p>&copy; 2024 MITA Airlines | All rights reserved</p>
            </footer>

            <script src="/mitascript.js"></script>

</body>

</html>
</ul>
</nav>
