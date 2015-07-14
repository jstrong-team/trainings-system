package mymail;

public class Main {
    private static mymail.Sender tlsSender = new mymail.Sender("antongrigorievd@gmail.com", "IronFi72");

    public static void main(String[] args){
        tlsSender.send("Test", "Testing test of testing mail.", "jsTrong<antongrigorievd@gmail.com>", "toxa.z@mail.ru", "table.xls");
    }
}
