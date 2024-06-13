package co.unicauca.example.service;

import co.unicauca.example.domain.ResponseDto;
import co.unicauca.example.model.User;

import java.util.List;

/**
 * Interface defining available operations for user management.
 *
 * @author juliansmartinez@unicauca.edu.co
 * @version 1.0
 */
public interface IUserService {

    /**
     * Saves a user in the system.
     *
     * @param payload The user to be saved.
     * @return A response containing the saved user and a status message.
     */
    ResponseDto<User> saveUser(User payload);

    /**
     * Finds a user by their unique identifier.
     *
     * @param userId The unique identifier of the user to find.
     * @return A response containing the found user and a status message, or an error message if the user does not exist.
     */
    ResponseDto<User> findById(Long userId);

    /**
     * Retrieves a list of all users registered in the system.
     *
     * @return A response containing the list of users and a status message.
     */
    ResponseDto<List<User>> findAll();
}
