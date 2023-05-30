package team01.issuetracker.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team01.issuetracker.service.AssigneeService;

@RequiredArgsConstructor
@RequestMapping("/api/writers")
@RestController
public class WriterController {

    private final AssigneeService assigneeService;
    private final Logger logger = LoggerFactory.getLogger(WriterController.class);

    @GetMapping
    public ResponseEntity<?> assigneesView() {
        logger.info("작성자 조회");
        return ResponseEntity.ok(assigneeService.getWriters());
    }
}
