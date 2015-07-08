package exadel.jsTrong.forTrainings.dao;


import exadel.jsTrong.forTrainings.model.Employee;

public interface DaoGeneric<TYPE> {
  //  void updateType();
   // TYPE selectByName();
    Employee selectByAuthorization(String login, String password);
 //   TYPE selectBySurname();
   // TYPE selectById();
}
