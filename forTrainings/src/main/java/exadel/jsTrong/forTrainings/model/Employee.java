package exadel.jsTrong.forTrainings.model;

public class Employee {
    private String id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private boolean isAdmin;
    private boolean isExternal;

    public Employee(String id, String login, String password,
                    String name, String surname, String mail, String phone,
                    boolean isAdmin, boolean isExternal) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phone = phone;
        this.isAdmin = isAdmin;
        this.isExternal = isExternal;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }


    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    public boolean getExternal() {
        return isExternal;
    }

    public void setExternal(boolean isExternal) {
        this.isExternal = isExternal;
    }
}
