package com.marco.appws;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marco.appws.io.entity.UserEntity;

/**
 * This interface by extending CrudRepository has all the basic crud methods already implemented.
 * It is possible to add custom crud methods to do specific operations on the db.
 * CrudRepository needs as arguments the class of the entity and the type of the id.
 * @author marco
 *
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	/**
	 * All the custom SELECT methods need to start with find followed By{paramenter_name}
	 */
	UserEntity findByEmail(String email);

}
