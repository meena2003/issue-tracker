package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team01.issuetracker.domain.Label;
import team01.issuetracker.domain.Member;
import team01.issuetracker.domain.Milestone;
import team01.issuetracker.repository.IssueRepository;
import team01.issuetracker.repository.LabelRepository;
import team01.issuetracker.repository.MemberRepository;
import team01.issuetracker.repository.MilestoneRepository;
import team01.issuetracker.service.dto.request.FilterRequestDTO;
import team01.issuetracker.service.dto.response.IssueResponseDTO;
import team01.issuetracker.service.dto.response.IssuesResponseDTO;
import team01.issuetracker.service.vo.Count;
import team01.issuetracker.service.vo.MiniLabel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IssueService {
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    LabelRepository labelRepository;
    @Autowired
    MilestoneRepository milestoneRepository;

    public IssuesResponseDTO getIssues(FilterRequestDTO requestDTO) {
        /*
        TODO: 필터값을 활용해 카운트값을 설정
         */
        Count count = Count.builder() // 필터에 따라서 값이 바뀜
                .label(4)
                .milestone(2)
                .opened(2)
                .closed(2)
                .build();

        //맴버 전체 조회
        Map<Long, Member> members = memberRepository.findAll().stream()
                .collect(Collectors.toMap(Member::getId, member -> member));
        //레이블 전체 조회
        Map<Long, Label> labels = labelRepository.findAll().stream()
                .collect(Collectors.toMap(Label::getId, label -> label));
        //마일스톤 전체 조회
        Map<Long, Milestone> milestones = milestoneRepository.findAll().stream()
                .collect(Collectors.toMap(Milestone::getId, milestone -> milestone));

        //issue -> issueResponseDTO로 변환
        List<IssueResponseDTO> issues = issueRepository.findAllByFilter(requestDTO.isOpen(), requestDTO.getMilestone(), requestDTO.getLabel(), requestDTO.getAssignee(), requestDTO.getWriters()).stream()
                .map(issue -> IssueResponseDTO.of(issue,
                        members.get(issue.getMemberId().getId()),
                        issue.getMilestoneId() == null ? "" : milestones.get(issue.getMilestoneId().getId()).getTitle(),
                        issue.getIssueLabels().stream().map(il -> MiniLabel.of(labels.get(il.getLabelId()))).collect(Collectors.toList())))
                .collect(Collectors.toList());

        System.out.println(issues);

        return IssuesResponseDTO.of(count, issues);
    }
}
