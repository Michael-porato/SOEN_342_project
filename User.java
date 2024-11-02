public abstract class User {
    
    private int userID;
    private String name;
    private String email;
    private String username;
    private String password;


    public User(int userID, String name, String email, String username, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password; 
    }


    public int getUserID(){
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
 
    //eventually validation for password
    public String getPassword() {
        return password; 
    }

   
    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }


    public void setUserID(int userID){
        this.userID = userID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
