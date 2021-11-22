package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import track.individual.read4share.model.Category;
import track.individual.read4share.repository.CategoryRepo;

import java.util.ArrayList;
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
    public List<String> getAllNames() {
        List<String> catNames = new ArrayList<String>();
        for (Category cat : catRepo.findAll())
            catNames.add(cat.getName());
        return catNames;
    }

    @Override
    public Optional<Category> findById(Long catId) {
        return catRepo.findById(catId);
    }
}
