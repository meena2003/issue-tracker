package team01.issuetracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team01.issuetracker.domain.Issue;

import java.util.List;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Long> {

    long countByIsOpen(boolean state);

    List<Issue> findAllByIsOpen(boolean state);

    List<Issue> findAll();

//    @Query("INSERT INTO issue_label (label_id, issue_id) VALUES (:labelId, :issueId)")
//    void saveIssueLabel(IssueLabel issueLabel);

//    List<Issue> test(FilterRequestDTO requestDTO);

    //TODO : 마일스톤 선택
//    @Query("select * from issue where milestone_id = :id")
//    List<Issue> findByMilestone(Long id);
}
