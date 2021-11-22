package track.individual.read4share.service;

import org.springframework.stereotype.Service;
import track.individual.read4share.model.Category;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<String> getAll() {
        return null;
    }

    @Override
    public Optional<Category> findByid(Long catId) {
        return Optional.empty();
    }
}
