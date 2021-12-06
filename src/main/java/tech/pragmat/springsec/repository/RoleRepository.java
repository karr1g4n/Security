package tech.pragmat.springsec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.pragmat.springsec.model.MyRole;

@Repository
public interface RoleRepository extends CrudRepository<MyRole,Integer> {
    MyRole findFirstByName(String name);
}
