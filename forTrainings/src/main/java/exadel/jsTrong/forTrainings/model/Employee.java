package exadel.jsTrong.forTrainings.model;

public class Employee {
    private String id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private boolean isAdmin;

    public Employee(String id, String name, String surname, String login, String password, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
