package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team01.issuetracker.service.dto.response.AssigneeDTO;
import team01.issuetracker.service.dto.response.AssigneesResponseDTO;
import team01.issuetracker.service.vo.Assignee;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssigneeService {

    /*
    이 담당자 아이도 듀이의 도움이 필요합니다!
     */
    public AssigneesResponseDTO getAssignees() {
        List<AssigneeDTO> assignees = memberRepository.findAll().stream()
                .map(AssigneeDTO::of)
                .collect(Collectors.toList());

        return AssigneesResponseDTO.builder()
                .assignees(assignees)
                .build();
    }
}
