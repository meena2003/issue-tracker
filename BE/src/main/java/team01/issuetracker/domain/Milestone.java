package team01.issuetracker.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@ToString
@Builder
@Table("milestone")
public class Milestone {
    @Id
    @Column("id")
    private Long id;
    @Column("title")
    private String title;
    @Column("description")
    private String description;
    @Column("is_open")
    private boolean isOpen;
    @Column("create_date_time")
    private LocalDateTime createAt;
    @Column("due_date")
    private LocalDate dueDate;

}
