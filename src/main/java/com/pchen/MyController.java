package com.pchen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MyController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(
            value = "/",
            params = { "title", "text" },
            method = GET)
    @ResponseBody
    public String getWithExplicitRequestParams(@RequestParam("title") String title, @RequestParam("text") String text) {
        return title +"\n"+text;
    }

}
