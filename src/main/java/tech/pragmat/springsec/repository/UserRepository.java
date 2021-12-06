package tech.pragmat.springsec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.pragmat.springsec.model.MyUser;

@Repository
public interface UserRepository extends CrudRepository<MyUser, Integer> {

    MyUser findFirstByName(String name);
}
