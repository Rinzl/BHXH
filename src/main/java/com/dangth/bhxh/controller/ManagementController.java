package com.dangth.bhxh.controller;

import com.dangth.bhxh.model.Worker;
import com.dangth.bhxh.repository.WorkerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/worker")
public class ManagementController {

    private final WorkerRepository workerRepository;

    public ManagementController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping("/info/{number}")
    public Worker getInfo(@PathVariable String number) {
        return workerRepository.findByIdentityCard_Number(number);
    }
    @GetMapping("/info")
    public Worker getInfoByMSBH(@RequestParam("msbh") String msbh) {
        return workerRepository.findByMsbh(msbh);
    }
}
