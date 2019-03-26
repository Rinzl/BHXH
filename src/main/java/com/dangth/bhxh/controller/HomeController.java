package com.dangth.bhxh.controller;

import com.dangth.bhxh.dto.WorkerDTO;
import com.dangth.bhxh.model.Worker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private static Logger logger = LogManager.getLogger(HomeController.class);

    @GetMapping({"/", "index"})
    public String index() {
        return "home";
    }

    @GetMapping("/info")
    public String info() {
        return "info";
    }

    @GetMapping({"/qlinfo"})
    public String qlInfo(Model model) {
        model.addAttribute("worker", new WorkerDTO());
        return "qlinfo";
    }

    @GetMapping({"/bhxhfee"})
    public String calculateFee() {
        return "bhxhfee";
    }

    @GetMapping({"/403"})
    public String accessDenied() {
        return "403";
    }

}
