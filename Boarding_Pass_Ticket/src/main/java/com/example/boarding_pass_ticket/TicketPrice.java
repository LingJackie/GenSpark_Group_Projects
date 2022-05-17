public class TicketPrice {

    int age;
    double originalTicketPrice;
    double discountedTicketPrice;
    String gender;

    public TicketPrice() {}

    public TicketPrice (String gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    public double generateTicketPriceDiscount(int age, String gender) {

        if(age <= 12) {discountedTicketPrice = originalTicketPrice * 0.5;}       // 50% discount for kids
        else if (age >= 60) {discountedTicketPrice = originalTicketPrice * 0.4;} // 60% discount for the elderly
        else {
            if (gender.equals("female")) {
                discountedTicketPrice = originalTicketPrice * 0.75;             // 25% discount for females
            }
        }
        return discountedTicketPrice;
    }

    //Setters
    public void setAge(int age) {this.age = age;}
    public void setGender(String gender) {this.gender = gender;}
    public void setOriginalTicketPrice(int OriginalTicketPrice) {this.originalTicketPrice = OriginalTicketPrice;}
    public void setDiscountedTicketPrice(int discountedTicketPrice) {this.discountedTicketPrice = discountedTicketPrice;}

    //Getters
    public int getAge() {return age;}
    public String getGender() {return gender;}
    public double getOriginalTicketPrice() {return originalTicketPrice;}
    public double getDiscountedTicketPrice() {return discountedTicketPrice;}

}
