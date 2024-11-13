// TestController.groovy
package com.raumobil.balotelli.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TestController {

    @GetMapping("/test")
    String testPage() {
        return "test.html"
    }
}
