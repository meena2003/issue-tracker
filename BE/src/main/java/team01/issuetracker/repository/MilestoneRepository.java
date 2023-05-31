package team01.issuetracker.repository;

import org.springframework.data.repository.CrudRepository;
import team01.issuetracker.domain.Milestone;

import java.util.List;
import java.util.Optional;

public interface MilestoneRepository extends CrudRepository<Milestone, Long> {
    List<Milestone> findAll();

    List<Milestone> findAllByIsOpen(boolean state);

    int countByIsOpen(boolean state);

    Optional<Milestone> findById(Long id);
}
