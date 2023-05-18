package team01.issuetracker.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Data
@Builder
@Table("issue")
public class Issue {
    @Id //pk 지정
    @Column("id")
    private Long id;
    @Column("member_id")
    private Long memberId;
    @Column("title")
    private String title;
    @Column("description")
    private String description;
    @Column("is_open")
    private boolean isOpen;
    @Column("milestone_id")
    private Long milestoneId;
    @Column("create_date_time")
    private Timestamp createAt;

    //1:N 관계, idColumn : 자식 엔티티가 가지는 외래키 keyColumn : 자식 엔티티의 기본키
    //@MappedCollection(idColumn = "issue_id", keyColumn = "comment_id")
    //private List<Comment> comments;

}
