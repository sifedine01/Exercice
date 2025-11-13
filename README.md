# Flight Booking App Exercise
A simple Android application demonstrating a master-detail flight booking UI. Users can browse a list of flights, sort them, and view a detailed ticket upon selection. This project is built with Kotlin and uses Fragments to create a responsive split-screen layout.

---

## ✨ Features

* **View Flights**: See a scrolling list of flights with key details (airline, time, price).
* **Sort Flights**: The list can be sorted by:
    * Price (Low to High)
    * Price (High to Low)
    * Airline Name
* **Master-Detail Interface**: A split-screen layout shows the list and details simultaneously, perfect for tablets or landscape mode.
* **View Flight Details**: Select a flight from the list to populate the detail pane with a ticket-style layout.
* **Custom Dialog**: Shows a custom-themed "Success" dialog on (mock) ticket download.

---

## 🛠️ Technologies & Components

* **Language**: Kotlin
* **Architecture**: Master-Detail UI
* **Core Components**:
    * `Fragment` (for the split-screen UI)
    * `RecyclerView` (to display the flight list)
    * `ViewBinding` (to interact with views safely)
    * `CardView` (for the list items and detail card)
    * `AlertDialog` (for the custom success popup)

---

## 📂 Project Structure

The project is structured into two main fragments hosted by a single activity:

* `MainActivity.kt`: The host activity that manages the two fragments and their communication via an interface.
* `FlightListFragment.kt`: The "master" fragment displaying the `RecyclerView` of flights and sorting buttons.
* `FlightDetailFragment.kt`: The "detail" fragment displaying the selected flight's ticket information.
* `FlightAdapter.kt`: The `RecyclerView.Adapter` that binds `Flight` data to the list items.
* `Flight.kt`: The `Serializable` data model for a flight.

---

## 🚀 How to Run

1.  **Clone the repository**:
    * Requires the [GitHub CLI](https://cli.github.com/).
    ```bash
    gh repo clone sifedine01/Exercice
    ```
    * Or use HTTPS:
    ```bash
    git clone [https://github.com/sifedine01/Exercice.git](https://github.com/sifedine01/Exercice.git)
    ```

2.  **Open in Android Studio**:
    * Open Android Studio.
    * Select "Open an Existing Project".
    * Navigate to the cloned project folder.
3.  **Run the app**:
    * Let Gradle sync and build the project.
    * Click the "Run" button (▶) and select an emulator or physical device.

    > **Note:** This layout is designed for a split-screen view, so it will look best on a tablet or a phone in **landscape mode**.

---

## 👥 Contributors

* Add contributors here!
    * Example: `[@sifedine01](https://github.com/sifedine01)`
