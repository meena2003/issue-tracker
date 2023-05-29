package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team01.issuetracker.domain.Label;
import team01.issuetracker.repository.LabelRepository;
import team01.issuetracker.service.dto.response.LabelDTO;
import team01.issuetracker.service.dto.response.LabelsResponseDTO;
import team01.issuetracker.service.vo.Count;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LabelService {
    @Autowired
    private final LabelRepository labelRepository;

    public LabelsResponseDTO getLabels() {
        //TODO: 카운터..는.. 나중에ㅜㅜ
        Count count = Count.builder() // 임시 값(명세서)
                .label(4)
                .milestone(2)
                .opened(0)
                .closed(0)
                .build();

        List<LabelDTO> labels = labelRepository.findAll().stream()
                .map(l -> LabelDTO.of(l))
                .collect(Collectors.toList());

        return LabelsResponseDTO.builder()
                .count(count)
                .labels(labels)
                .build();
    }

    public void create(LabelDTO labelDTO) {
        labelRepository.save(Label.create(labelDTO));
    }

    public void update(LabelDTO labelDTO, Long labelId) {
        Label label = findLabelById(labelId);

        label.update(labelDTO);

        labelRepository.save(label);
    }

    public void delete(Long labelId) {
        Label label = findLabelById(labelId);

        label.getIssueLabels().stream()
                .map(issueLabel -> issueLabel.deleteLabel(label));

        labelRepository.delete(label);
    }

    public Label findLabelById(Long labelId) {
        return labelRepository.findById(labelId)
                .orElseThrow(() -> new RuntimeException("해당 레이블을 찾을 수 없습니다."));
    }

}
