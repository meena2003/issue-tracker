package team01.issuetracker.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MiniLabel {
    private final String title;
    private final String bgColorCode;
}
