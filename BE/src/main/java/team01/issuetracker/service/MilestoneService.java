package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team01.issuetracker.domain.Issue;
import team01.issuetracker.domain.Milestone;
import team01.issuetracker.repository.IssueRepository;
import team01.issuetracker.repository.MilestoneRepository;
import team01.issuetracker.service.dto.response.MilestoneDTO;
import team01.issuetracker.service.dto.response.MilestoneResponseDTO;
import team01.issuetracker.service.vo.Count;
import team01.issuetracker.service.vo.MilestoneVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;
    private final IssueRepository issueRepository;

    /*
    todo: 마일스톤 db와 연결
     */
    public MilestoneResponseDTO getMilestone(String status) {

        Count count = Count.builder() // 임시 값(명세서)
                .label(4)
                .milestone(1)
                .opened(1)
                .closed(1)
                .build();

        List<MilestoneDTO> milestones = new ArrayList<>();
        if (status.equals("open")) {
            LocalDate localDate = LocalDate.parse("2023-05-10");
            milestones.add(MilestoneDTO.of(new MilestoneVO(1L, "테스크01"
                    , "테스크01 내용", localDate, 1L, 1L)));
        } else {
            milestones.add(MilestoneDTO.of(new MilestoneVO(2L, "테스크02"
                    , "테스크02 내용", null, 1L, 0L)));
        }

        return MilestoneResponseDTO.builder()
                .count(count)
                .milestones(milestones)
                .build();
    }

    public void create(MilestoneDTO milestoneDTO) {
        milestoneRepository.save(Milestone.create(milestoneDTO));
    }

    public void update(MilestoneDTO milestoneDTO, Long milestoneId) {
        Milestone milestone = findMilestoneById(milestoneId);

        milestone.update(milestoneDTO);

        milestoneRepository.save(milestone);
    }

    public void stateChanges(Long milestoneId) {
        Milestone milestone = findMilestoneById(milestoneId);

        milestone.statusUpdate();

        milestoneRepository.save(milestone);
    }

    // 로직의 문제... 다음엔 IssueMilestone 테이블을 만들자 ㅠ
    public void delete(Long milestoneId) {
        Milestone milestone = findMilestoneById(milestoneId);
        List<Issue> issues = milestone.getIssues();

        for (Issue issue : issues) {
            issue.setMilestoneId(null);
        }

        issueRepository.saveAll(issues);
        milestoneRepository.delete(milestone);
    }

    public Milestone findMilestoneById(Long milestoneId) {
        return milestoneRepository.findById(milestoneId)
                .orElseThrow(() -> new RuntimeException("해당 마일스톤을 찾을 수 없습니다."));
    }

}
