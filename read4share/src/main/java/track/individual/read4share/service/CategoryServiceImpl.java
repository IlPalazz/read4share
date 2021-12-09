package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import track.individual.read4share.exception.ItemAlreadyExistingException;
import track.individual.read4share.model.Category;
import track.individual.read4share.repository.CategoryRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo catRepo;

    @Override
    public List<Category> getAll() {
        return catRepo.findAll();
    }

    @Override
    public Optional<Category> getById(Long id) {
        return catRepo.findById(id);
    }

    @Override
    public Optional<Category> getByName(String name) {
        return catRepo.findByNameIgnoreCase(name);
    }

    @Override
    public boolean isValid(Long id) {
        return this.getById(id).isPresent();
    }

    @Override
    public boolean isPresent(String name) {
        return this.getByName(name).isPresent();
    }

    @Override
    public void addCategory(String name) {
        if (this.isPresent(name))
            throw new ItemAlreadyExistingException("A category with the given name already exists");
        catRepo.save(Category.builder().name(name).build());
    }
}
