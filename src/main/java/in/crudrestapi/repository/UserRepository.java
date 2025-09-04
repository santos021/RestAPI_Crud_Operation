package in.crudrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.crudrestapi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
