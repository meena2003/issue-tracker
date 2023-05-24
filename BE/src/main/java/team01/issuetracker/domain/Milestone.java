package team01.issuetracker.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.sql.Timestamp;


@Getter
@AllArgsConstructor
@ToString
@Builder
@Table("milestone")
public class Milestone {
    @Id
    @Column("id")
    private long id;
    @Column("title")
    private String title;
    @Column("description")
    private String description;
//    @Column("is_open")
//    private boolean isOpen;
//    @Column("create_date_time")
//    private Timestamp createAt;
//    @Column("due_date")
//    private Date dueDate;


}
