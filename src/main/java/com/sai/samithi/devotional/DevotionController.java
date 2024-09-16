package com.sai.samithi.devotional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DevotionController {

    @GetMapping("/devotion")
    public String contactPage() {
        return "devotion/index";
    }

}
