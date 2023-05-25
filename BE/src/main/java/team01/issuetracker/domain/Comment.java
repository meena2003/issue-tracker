package team01.issuetracker.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "Comment")
public class Comment {
    @Id
    @Column("id")
    private Long id;
    @Column("description")
    private String description;
}
