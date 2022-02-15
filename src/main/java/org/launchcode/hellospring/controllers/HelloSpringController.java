package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//automatically maps hello before every single method
//@RequestMapping(value = "hello")
public class HelloSpringController {
//    //response to requests to the root path: /
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
        //responds to GET request like /hello/Michelle
        @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name) {
        return "Hello, "+name+"!";
        }

        @GetMapping("form")
    @ResponseBody
    public String helloForms() {
        return "<form method = 'POST'><input name = 'userName' type = 'text'><select name = 'lang' " +
                "id = 'language-select'><option value = ''>Choose a language</option><option value='English'>" +
                "English</option><option value='French'>French</option><option value='Korean'>Korean" +
                "<option value='Spanish'>Spanish</option><option value='Japanese'>Japanese</option></select>" +
                "<button type = 'submit'>Greet Me</form>";
        }

//        @PostMapping("hello-forms")
//    @ResponseBody
//    public String helloForms(@RequestParam String name) {
//        return "Hello, "+name+"!";
//        }

    @PostMapping("hello-forms")
    @ResponseBody
    public String helloForms(@RequestParam String userName, @RequestParam String lang) {
        return createMessage(userName, lang);
    }

//        @PostMapping("hello-forms")
//    @ResponseBody
//    public static String createMessage(@RequestParam String userName,@RequestParam String lang) {
//        String msg = null;
//        if (lang == "English") {
//            msg = "Hello, "+userName+"!";
//        } else if (lang == "French") {
//            msg = "Bonjour, "+userName+"!";
//        } else if (lang == "Korean") {
//            msg = "Annyoung, "+userName+"!";
//        } else if (lang == "Spanish") {
//            msg = "Hola, "+userName+"!";
//        } else if (lang == "Japanese") {
//            msg = "Konnichiwa, "+userName+"!";
//        }
//        return msg;
//        }
        //return createMessage(userName, lang);

        public static String createMessage(String userName, String lang) {
        String greeting = "";

        if (lang.equals("English")) {
            greeting += "Hello, ";
        } else if (lang.equals("Spanish")) {
            greeting +="Hola, ";
        } else if (lang.equals("French")) {
            greeting += "Bonjour, ";
        } else if (lang.equals("Korean")) {
            greeting += "Annyoung, ";
        } else if (lang.equals("Japanese")) {
            greeting += "Konnichiwa, ";
        }
        return greeting += userName + "!";
        }

//    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public String hello(@RequestParam String name) {
//        return "Hello, "+name+"!";
//    }
//
//    @GetMapping("Hello/{name}")
//    @ResponseBody
//    public String helloAgain(@PathVariable String name) {
//        return "Hello, "+name+"!";
//    }
//
//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {
//        String html = "<html>" +
//                "<body>" +
//                "<form method='post action='hello>" +
//                "<input type='text' name='name />" +
//                "<input type='submit' value=''Greet Me!' />" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//        return html;
//    }
}
