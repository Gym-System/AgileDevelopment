package EntityClass.DAO;

import EntityClass.VO.Person;

public interface PersonDAO {
    // insert
    Boolean insertPerson(Person person);

    // delete
    Boolean deletePerson(String userName);

    // update
    Person changePersonPassword(String userName, String password);
    Person changePersonEmail(String userName, String email);
    Person changePersonTeleNo(String userName, String teleNo);

    // select
    Person queryByUserName(String userName);

}
