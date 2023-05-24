package team01.issuetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team01.issuetracker.service.dto.response.AssigneeResponseDTO;
import team01.issuetracker.service.dto.response.AssigneesResponseDTO;
import team01.issuetracker.service.vo.Assignee;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssigneeService {
    
    public AssigneesResponseDTO getAssignees() {
        List<AssigneeResponseDTO> assignees = new ArrayList<>();
        assignees.add(AssigneeResponseDTO.of(new Assignee(1L,"다온","https://avatars.githubusercontent.com/u/115215178?s=40&v=4")));
        assignees.add(AssigneeResponseDTO.of(new Assignee(2L,"포코","https://avatars.githubusercontent.com/u/101160636?s=40&v=4")));
        assignees.add(AssigneeResponseDTO.of(new Assignee(3L,"듀이","https://avatars.githubusercontent.com/u/115435482?s=40&v=4")));
        assignees.add(AssigneeResponseDTO.of(new Assignee(4L,"만쥬","https://avatars.githubusercontent.com/u/20828490?s=40&v=4")));
        assignees.add(AssigneeResponseDTO.of(new Assignee(5L,"코어","https://avatars.githubusercontent.com/u/85631282?s=40&v=4")));
        assignees.add(AssigneeResponseDTO.of(new Assignee(6L,"해나","https://avatars.githubusercontent.com/u/97685264?s=40&v=4")));
        assignees.add(AssigneeResponseDTO.of(new Assignee(7L,"하림","https://avatars.githubusercontent.com/u/90844696?s=40&v=4")));
        
        return AssigneesResponseDTO.of(assignees);
    }
}
