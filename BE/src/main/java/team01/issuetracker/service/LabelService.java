package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team01.issuetracker.domain.Label;
import team01.issuetracker.service.dto.response.LabelDTO;
import team01.issuetracker.service.dto.response.LabelsResponseDTO;
import team01.issuetracker.service.vo.Count;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LabelService {

    /*
    이 아이는 듀이의 수정을 기다리고 있습니다 ㅠ
     */
    public LabelsResponseDTO getLabels() {
        Count count = Count.builder() // 임시 값(명세서)
                .label(4)
                .milestone(2)
                .opened(0)
                .closed(0)
                .build();

        List<LabelDTO> labels = new ArrayList<>();
        labels.add(LabelDTO.of(new Label(1L, "FE", "FE 담당"
                , "#655CC7", "#FFFFFF")));
        labels.add(LabelDTO.of(new Label(2L, "BE", "BE 담당"
                , "#EC8D8D", "#FFFFFF")));
        labels.add(LabelDTO.of(new Label(3L, "iOS", "iOS 담당"
                , "#A3D485", "#FFFFFF")));
        labels.add(LabelDTO.of(new Label(4L, "bug", "버그 상황"
                , "#14D6B6", "#FFFFFF")));

        return LabelsResponseDTO.builder()
                .count(count)
                .labels(labels)
                .build();
    }
}
