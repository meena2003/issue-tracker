package team01.issuetracker.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FilterRequestDTO {
    private final boolean isOpen;
    private final Long assignees;
    private final Long labels;
    private final Long milestones;
    private final Long writers;
}
