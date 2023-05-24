package team01.issuetracker.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team01.issuetracker.domain.Label;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class LabelsResponseDTO {

    private final List<Label> labels;

    public static LabelsResponseDTO of(List<Label> labels) {
        return LabelsResponseDTO.builder()
                .labels(labels)
                .build();
    }
}
