package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team01.issuetracker.domain.Label;
import team01.issuetracker.service.dto.response.LabelsResponseDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LabelService {

    public LabelsResponseDTO getLabels() {
        List<Label> labels = new ArrayList<>();
        labels.add(new Label(1L, "FE", "FE 담당"
                , "#655CC7", "#FFFFFF"));
        labels.add(new Label(2L, "BE", "BE 담당"
                , "#EC8D8D", "#FFFFFF"));
        labels.add(new Label(3L, "iOS", "iOS 담당"
                , "#A3D485", "#FFFFFF"));
        labels.add(new Label(4L, "bug", "버그 상황"
                , "#14D6B6", "#FFFFFF"));

        return LabelsResponseDTO.of(labels);
    }
}
