public class Instructor extends User{
    

    private String name;
    private String phone_number;
    private String specialization;
    private boolean isAvailable;
    


    public Instructor(String name, String phone_number, String specialization, boolean isAvailable){

        this.name = name;
        this.phone_number = phone_number;
        this.specialization = specialization;
        this.isAvailable = isAvailable;

    }


    public String getName(){
        return name;
    }

    public String getPhone_number(){
        return phone_number;
    }

    public String getSpecialization(){
        return specialization;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }



    public void setName(String name){
        this.name = name;
    }

    public void setPhone_number(String phone_number){
        if (phone_number.matches("\\d{10}")) {
            this.phone_number = phone_number;
        } else {
            System.out.println("Invalid phone number. Please enter a 10-digit number.");
        }
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }


}
