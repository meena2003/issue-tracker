package team01.issuetracker.repository;

import org.springframework.data.repository.CrudRepository;
import team01.issuetracker.domain.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {


}
