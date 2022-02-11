package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//automatically maps hello before every single method
//@RequestMapping(value = "hello")
public class HelloController {
    //response to requests to the root path: /
    @GetMapping("")
    @ResponseBody
        public String hello() {
        return "Hello, Spring!";
        }

        //response to requests at /bonjour
        @GetMapping("bonjour")
    @ResponseBody
    public String bonjour() {
        return "Bonjour, Spring!";
        }
        // responds to GET requests like /hello?name=Michelle
        @GetMapping("hello")
    @ResponseBody
    public String helloQuery(@RequestParam String name) {
        return "Hello, "+name + "!";
        }
        //responds to GET request like /hi/Michelle
        @GetMapping("hi/{name}")
    @ResponseBody
    public String hiQuery(@PathVariable String name) {
        return "Hello, "+name+"!";
        }

        @GetMapping("hello-forms")
    @ResponseBody
    public String helloForms() {
        return "<form method = 'POST'><input name = 'name' type = 'text'><select name = 'language' id = language-select'><option value = ''>Choose a language<option value='English'><option value='French'><option value='Korean'><option value='Spanish'><option value='Japanese'><button type = 'submit'>Greet Me</form>";
        }

        @PostMapping("hello-forms")
    @ResponseBody
    public String helloForms(@RequestParam String name) {
        return "Hello, "+name+"!";
        }
}
