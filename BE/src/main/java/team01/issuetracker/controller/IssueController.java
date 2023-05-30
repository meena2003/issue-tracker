package team01.issuetracker.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team01.issuetracker.service.IssueService;
import team01.issuetracker.service.dto.request.FilterRequestDTO;

@RequiredArgsConstructor
@RequestMapping("/api/issues")
@RestController
public class IssueController {

    private final IssueService issueService;
    private final Logger logger = LoggerFactory.getLogger(IssueController.class);

    @GetMapping
    public ResponseEntity<?> view(FilterRequestDTO requestDTO) {
        logger.info("그 리퀘파람 테스트 임돠");

        return ResponseEntity.ok(issueService.getIssues(requestDTO));
    }
}
