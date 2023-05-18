package team01.issuetracker.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team01.issuetracker.domain.Issue;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class IssueRepositoryTest {
    @Autowired
    IssueRepository issueRepository;

    @Test
    @DisplayName("issue 객체를 생성하여 레포지토리에 저장하면 저정된 이슈 타이블과 생성한 이슈 타이틀은 같아야 한다.")
    void insertIssue() {
        Issue issue = Issue.builder().title("삽입 테스트").description("듀이는.. 자고싶다..").isOpen(false).memberId(1L).build();
        Issue insertIssue = issueRepository.save(issue);

        assertThat(insertIssue.getTitle()).isEqualTo(issue.getTitle());
    }

    @Test
    void findIssueOne() {
        Optional<Issue> issue = issueRepository.findById(1L);
        if (issue.isPresent()) {
            System.out.println(issue.get().getTitle());
        }
    }
}