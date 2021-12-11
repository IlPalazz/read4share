package track.individual.read4share.service;


import track.individual.read4share.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    /**
     * Get all the categories
     * @return List with all the categories
     */
    List<Category> getAll();

    /**
     * Get a specific category by id
     * @param id category id
     * @return Category Object, otherwise Null if the id is not valid
     */
    Optional<Category> getById(Long id);

    /**
     * Get a specific category by
     * @param name Category name
     * @return Category Object, Null if the name is not valid
     */
    Optional<Category> getByName(String name);

    /**
     * Check whether a particular category id is valid
     * @param id Category id
     * @return True if the id is associated to a valid category, false otherwise
     */
    boolean isValid(Long id);

    /**
     * Check whether a particular category name already exists
     * @param name Category name
     * @return True if the name is not present inside the db, false otherwise
     */
    boolean isPresent(String name);

    /**
     * Save a new category inside the db
     * @param name Category name
     */
    void addCategory(String name);
}
