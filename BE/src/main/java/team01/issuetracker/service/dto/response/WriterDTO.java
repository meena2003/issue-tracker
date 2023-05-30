package team01.issuetracker.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team01.issuetracker.domain.Member;

@Getter
@Builder
@AllArgsConstructor
public class WriterDTO {

    private final long id;
    private final String name;
    private final String imgUrl;

    public static WriterDTO of(Member writer) {
        return WriterDTO.builder()
                .id(writer.getId())
                .name(writer.getName())
                .imgUrl(writer.getFileURL())
                .build();
    }
}
