package team01.issuetracker.repository;

import org.springframework.data.repository.CrudRepository;
import team01.issuetracker.domain.Label;

public interface LabelRepository extends CrudRepository<Label, Long> {

}
