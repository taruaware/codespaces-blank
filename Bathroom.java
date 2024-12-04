public class Bathroom {
    private String type; // Type of the bathroom (e.g., "Men's", "Women's")
    private boolean isOpen; // Whether the bathroom is open or closed

    // Constructor
    public Bathroom(String type) {
        this.type = type;
        this.isOpen = Math.random() < 0.5; // Randomly assign open or closed status
    }

    // Getter for the bathroom type
    public String getType() {
        return type;
    }

    // Getter to check if the bathroom is open
    public boolean isOpen() {
        return isOpen;
    }

    // Method to get the current status of the bathroom
    public String getStatus() {
        return type + " Bathroom is " + (isOpen ? "Open" : "Closed");
    }

    // Method to toggle the bathroom's status (open/closed)
    public void toggleStatus() {
        this.isOpen = !this.isOpen;
    }
}