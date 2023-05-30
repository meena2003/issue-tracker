package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team01.issuetracker.repository.MemberRepository;
import team01.issuetracker.service.dto.response.AssigneeDTO;
import team01.issuetracker.service.dto.response.AssigneesResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssigneeService {

    private final MemberRepository memberRepository;

    public AssigneesResponseDTO getAssignees() {
        List<AssigneeDTO> assignees = memberRepository.findAll().stream()
                .map(AssigneeDTO::of)
                .collect(Collectors.toList());

        return AssigneesResponseDTO.builder()
                .assignees(assignees)
                .build();
    }
}
