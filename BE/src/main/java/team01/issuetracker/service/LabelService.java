package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team01.issuetracker.repository.LabelRepository;
import team01.issuetracker.repository.MilestoneRepository;
import team01.issuetracker.service.dto.response.LabelDTO;
import team01.issuetracker.service.dto.response.LabelsResponseDTO;
import team01.issuetracker.service.vo.Count;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LabelService {
    //Todo: 고민거리: 서비스에서 모든 레포에 접근하게 하는게 맞나..?
    @Autowired
    LabelRepository labelRepository;
    @Autowired
    MilestoneRepository milestoneRepository;


    public LabelsResponseDTO getLabels() {
        Count count = Count.builder()
                .label((int) labelRepository.count())
                .milestone(milestoneRepository.countByIsOpen(true))
                .build();

        List<LabelDTO> labels = labelRepository.findAll().stream()
                .map(LabelDTO::of)
                .collect(Collectors.toList());

        return LabelsResponseDTO.builder()
                .count(count)
                .labels(labels)
                .build();
    }
}
