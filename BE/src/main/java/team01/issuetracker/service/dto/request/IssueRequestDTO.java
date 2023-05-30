package team01.issuetracker.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class IssueRequestDTO {

    private final Long writerId;
    private final String title;
    private final String description;
    private final String fileUrl;
    private final List<Long> assigneeIds;
    private final List<Long> labelIds;
    private final Long milestoneId;
}
