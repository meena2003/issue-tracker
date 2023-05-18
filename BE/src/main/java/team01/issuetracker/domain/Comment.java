package team01.issuetracker.domain;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@Table(name = "Comment")
public class Comment {
    @Id
    private long commentId;
    //private AggregateResourceBundleLocator<Issue, Long> issueId; //외래키 역할
}
