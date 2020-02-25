package users;
public class User{
    private String name = "";
    public User(){

    }
    public User(String name){
        this.name = name;
    }
    public String getname(){
        return this.name;
    }
    public void setname(String name){
        this.name = name;
    }
}