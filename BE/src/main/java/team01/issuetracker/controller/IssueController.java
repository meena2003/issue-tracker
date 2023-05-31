package team01.issuetracker.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team01.issuetracker.service.IssueService;
import team01.issuetracker.service.dto.request.FilterRequestDTO;
import team01.issuetracker.service.dto.request.IssueRequestDTO;

@RequiredArgsConstructor
@RequestMapping("/api/issues")
@RestController
public class IssueController {

    private final IssueService issueService;
    private final Logger logger = LoggerFactory.getLogger(IssueController.class);

    @GetMapping
    public ResponseEntity<?> view(FilterRequestDTO requestDTO) {
        logger.info("이슈 필터 호출");
        return ResponseEntity.ok(issueService.getIssues(requestDTO));
    }

    @PostMapping
    public void create(@RequestBody IssueRequestDTO issueDTO) {
        logger.debug("이슈 생성");
        issueService.create(issueDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailView(@PathVariable Long id) {
        logger.debug("이슈 상세보기");
        return ResponseEntity.ok(issueService.getIssue(id));
    }
}
