package users;
public class User{
    private String name = "";
    private
    BuyBehavior clienttype;
    public User(){
        this.clienttype = new Casual();
    }
    public User(String name, BuyBehavior type){
        this.name = name;
        this.clienttype = type;
    }
    public String getname(){
        return this.name;
    }
    public void setname(String name){
        this.name = name;
    }

}