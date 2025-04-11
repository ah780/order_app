public class MenuIteam {
    String name;
    double price;

    public MenuIteam(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getInfo() {
        return "Name: " + name + ", Price: " + price + "\n";
    }

}
