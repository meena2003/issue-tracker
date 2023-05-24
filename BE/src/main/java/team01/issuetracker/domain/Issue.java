package team01.issuetracker.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@AllArgsConstructor
@Builder
@Table("issue")
public class Issue {
    @Id //pk 지정
    @Column("id")
    private Long id;
    @Column("member_id")
    private AggregateReference<Member, @NonNull Long> memberId;
    @Column("title")
    private String title;
    @Column("description")
    private String description;
    @Column("is_open")
    private boolean isOpen;
    @Column("create_date_time")
    private Timestamp createAt;
    @Column("milestone_id")
    private AggregateReference<Milestone, @NonNull Long> milestoneId;

    //1:N 관계, idColumn : 자식 엔티티가 가지는 외래키 keyColumn : 자식 엔티티의 기본키
    @MappedCollection(idColumn = "issue_id", keyColumn = "id")
    private Set<Manager> managers = new HashSet<>();

    @MappedCollection(idColumn = "issue_id", keyColumn = "id")
    private Set<IssueLabel> issueLabels = new HashSet<>();


    private void addManager(Member member) {
        managers.add(createManager(member));
    }

    private Manager createManager(Member member) {
        return Manager.builder().memberId(memberId.getId()).build();
    }


}
