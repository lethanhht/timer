package com.example.timer.playground;

import com.example.timer.info.TimeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timer")
public class PlaygroundController {

    private final PlaygroundService service;

    @Autowired
    public PlaygroundController(PlaygroundService service) {
        this.service = service;
    }

    @PostMapping("/runhelloworld")
    public void runHelloWorldJob() {
        service.runHelloWorldJob();
    }

    @GetMapping
    public List<TimeInfo> getAllRunningTimer() {
        return service.getAllRunningTimer();
    }

    @GetMapping("/{timerId}")
    public TimeInfo getRunningTimer(@PathVariable String timerId){
        return service.getRunningTimer(timerId);
    }
}
