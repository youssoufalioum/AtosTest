package net.atos.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.atos.test.entities.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {

}
