package team01.issuetracker.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@ToString
@Getter
@AllArgsConstructor
@Builder
@Table("manager")
public class Manager {
    @Id
    @Column("id")
    private Long id;
    @Column("member_id")
    private Long memberId;
}
