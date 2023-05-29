package team01.issuetracker.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team01.issuetracker.service.MilestoneService;
import team01.issuetracker.service.dto.response.MilestoneDTO;

@RequiredArgsConstructor
@RequestMapping("/api/milestones")
@RestController
public class MilestoneController {

    private final MilestoneService milestoneService;
    private final Logger logger = LoggerFactory.getLogger(MilestoneController.class);

    @GetMapping
    public ResponseEntity<?> milestoneView(@RequestParam("status") String status) {
        logger.info(status + " 마일스톤 조회");
        return ResponseEntity.ok(milestoneService.getMilestone(status));
    }

    @PostMapping
    public void create(@RequestBody MilestoneDTO milestoneDTO) {
        logger.debug("마일스톤 생성");
        milestoneService.create(milestoneDTO);
    }

    @PatchMapping("/{milestoneId}")
    public void update(@RequestBody MilestoneDTO milestoneDTO, @PathVariable Long milestoneId) {
        logger.debug("마일스톤 편집");
        milestoneService.update(milestoneDTO, milestoneId);
    }

    @PatchMapping("/{milestoneId}/status")
    public void stateChanges(@PathVariable Long milestoneId) {
        logger.debug("마일스톤 상태 반전");
        milestoneService.stateChanges(milestoneId);
    }

    @DeleteMapping("/{milestoneId}")
    public void delete(@PathVariable Long milestoneId) {
        logger.debug("마일스톤 삭제");
        milestoneService.delete(milestoneId);
    }

}
