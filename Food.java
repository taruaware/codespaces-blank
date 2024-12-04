public class Food {
    private int calories;
    private String name;
    private double price;
    private int spiciness;
    private String info;

    public Food(int c, String n, double p, int s, String i) {
        calories = c;
        name = n;
        price = p;
        spiciness = s;
        info = i;
    }

    public void ChangeSpiciness(int p) {
        spiciness = p;
    }

    public void Coupon() {
        price -= 5.00;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getSpiciness() {
        return spiciness;
    }

    public String getInfo() {
        return info;
    }

    public int getCalories(){
         return calories;
    } 
}

