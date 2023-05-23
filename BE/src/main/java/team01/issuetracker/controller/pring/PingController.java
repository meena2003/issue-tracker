package team01.issuetracker.controller.pring;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PingController {
//    @GetMapping("/ping")
//    public ResultVO ping(@RequestParam("name") String name) {
//        ResultVO result = new ResultVO(0, name);
//        return result;
//    }

    @GetMapping("/ping")
    public ResponseEntity<ResultVO> ping(@RequestParam("name") String name) {
        ResultVO result = new ResultVO(0, name);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/ping2")
    public ResultVO ping2(@RequestParam("name") String name) {
        ResultVO result = new ResultVO(0, name);
        return result;
    }


}
