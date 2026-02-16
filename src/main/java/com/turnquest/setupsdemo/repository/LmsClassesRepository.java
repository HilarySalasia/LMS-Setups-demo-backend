package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.LmsClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This is a Spring Data JPA repository for LmsClasses.
 * It provides methods to perform CRUD operations on the LmsClasses entity.
 * It extends JpaRepository which provides JPA related methods that we can use with our entity.
 *
 * @Repository makes this class as a Bean in Spring Application Context.
 * It also indicates that this class is a Data Access Object (DAO).
 *
 * JpaRepository is a JPA specific extension of Repository which provides some additional methods, such as flushing the persistence context and deleting records in a batch.
 * It takes the domain class to manage as well as the id type of the domain class as type arguments.
 */
@Repository
public interface LmsClassesRepository extends JpaRepository<LmsClasses, Long> {

    /**
     * This method is used to find an LmsClasses entity by its claShtDesc attribute.
     * It returns an Optional of LmsClasses. Optional is a container object which may or may not contain a non-null value.
     * If a value is present, isPresent() will return true and get() will return the value.
     *
     * @param claShtDesc the short description of the class to find
     * @return an Optional of the LmsClasses entity
     */
    Optional<LmsClasses> findByClaShtDesc(String claShtDesc);
}