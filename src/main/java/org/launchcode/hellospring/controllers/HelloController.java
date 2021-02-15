package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // Handles request at path /hello
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of form /hello?name=LaunchCode
   @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
   }

    // Handles requests of form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }


    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Test 1");
        names.add("Test 2");
        names.add("Test 3");
        model.addAttribute("names", names);
        return "hello-list";
    }

    // Handles requests of form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
//        String properGreeting = createMessage(name, language);
//        return properGreeting;
//    }
//    public static String createMessage(String name, String language) {
//        if (language.equals("Japanese")) {
//            return "Kon'nichiwa, " + name + "!";
//        } else if (language.equals("Spanish")) {
//            return "Hola, " + name + "!";
//        } else if (language.equals("German")) {
//            return "Hallo, " + name + "!";
//        } else if (language.equals("French")) {
//            return "Bonjour, " + name + "!";
//        } else {
//            return "Hello, " + name + "!";
//        }
//    }
}
