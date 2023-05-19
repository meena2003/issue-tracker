package team01.issuetracker.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team01.issuetracker.domain.Issue;

import java.util.Optional;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class IssueRepositoryTest {
    @Autowired
    IssueRepository issueRepository;

    @Test
    @DisplayName("issue 객체를 생성하여 레포지토리에 저장하면 저정된 이슈 타이블과 생성한 이슈 타이틀은 같아야 한다.")
    void insertIssue() {
        long count = issueRepository.count();
        Issue issue = Issue.builder().title("삽입 테스트").description("듀이는.. 자고싶다..").isOpen(false).memberId(1L).build();
        Issue insertIssue = issueRepository.save(issue);

        assertThat(insertIssue.getId()).isEqualTo(count + 1);
        assertThat(insertIssue.getTitle()).isEqualTo(issue.getTitle());
    }

    @Test
    @DisplayName("issue id 1번의 제목은 듀이입니다와 같아야 한다.")
    void findIssueOne() {
        Optional<Issue> findIssue = issueRepository.findById(1L);
        if (findIssue.isPresent()) {
            assertThat(findIssue.get().getTitle()).isEqualTo("듀이입니다");
        }
    }

    @Test
    @DisplayName("issue 한개를 삭제하면 기존 이슈 갯수 -1 과 같아야 한다.")
    void deleteOneIssue() {
        long count = issueRepository.count();
        issueRepository.deleteById(1L);
        assertThat(issueRepository.count()).isEqualTo(count - 1);
    }
}