package team01.issuetracker.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team01.issuetracker.service.IssueService;

@RequiredArgsConstructor
@RequestMapping("/api/issues")
@RestController
public class IssueController {

    private final IssueService issueService;
    private final Logger logger = LoggerFactory.getLogger(IssueController.class);

    @GetMapping
    public ResponseEntity<?> view(@RequestParam("status") String status) {
        if (status.equals("open")) {
            logger.info("오픈 이슈 페이지");
            return ResponseEntity.ok(issueService.openIssues());
        } else {
            logger.info("클로즈 이슈 페이지");
            return ResponseEntity.ok(issueService.closeIssues());
        }
    }
}
