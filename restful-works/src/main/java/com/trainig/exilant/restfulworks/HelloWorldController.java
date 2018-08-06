package com.trainig.exilant.restfulworks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	// @RequestMapping(method=RequestMethod.GET,path="hello")
	@GetMapping(path = "/hello")
	public String hellloWorld() {
		return "hello world";
	}

	@GetMapping(value = "/hello-world-bean")
	public HelloWorld hello() {
		return new HelloWorld("hello world");
	}

	// we have to get it from end user
	// http://localhost:8080/hello-world/pooja

	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorld helloworldPathVeriable(@PathVariable String name) {
		return new HelloWorld("hi" + name);
	}
}
