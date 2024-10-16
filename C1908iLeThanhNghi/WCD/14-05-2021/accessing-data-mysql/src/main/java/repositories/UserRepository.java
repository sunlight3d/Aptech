package repositories;

import models.User;
import org.springframework.data.repository.CrudRepository;
//controller chua nghiep vu, business
//goi xuong db thong qua Repository
//Repo la interface, da thuc thi cac function CRUD
public interface UserRepository extends CrudRepository<User, Integer> {

}

