package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team01.issuetracker.repository.IssueRepository;
import team01.issuetracker.repository.LabelRepository;
import team01.issuetracker.repository.MilestoneRepository;
import team01.issuetracker.service.dto.response.MilestoneDTO;
import team01.issuetracker.service.dto.response.MilestoneResponseDTO;
import team01.issuetracker.service.vo.Count;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MilestoneService {

    @Autowired
    private MilestoneRepository milestoneRepository;
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private LabelRepository labelRepository;

    public MilestoneResponseDTO getMilestone(boolean status) {

        Count count = Count.builder() // 임시 값(명세서)
                .label((int) labelRepository.count())
                .milestone((int) milestoneRepository.count())
                .opened(milestoneRepository.countByIsOpen(true))
                .closed(milestoneRepository.countByIsOpen(false))
                .build();

        List<MilestoneDTO> milestones = milestoneRepository.findAllByIsOpen(status).stream()
                .map(m -> MilestoneDTO.of(m, issueRepository.countByIsOpenAndMilestoneId(true, m.getId()), issueRepository.countByIsOpenAndMilestoneId(false, m.getId())))
                .collect(Collectors.toList());

        return MilestoneResponseDTO.builder()
                .count(count)
                .milestones(milestones)
                .build();
    }
}
