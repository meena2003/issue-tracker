package team01.issuetracker.repository;

import org.springframework.data.repository.CrudRepository;
import team01.issuetracker.domain.Issue;

public interface IssueRepository extends CrudRepository<Issue, Long> {

}
