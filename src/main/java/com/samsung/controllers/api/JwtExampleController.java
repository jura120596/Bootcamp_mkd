package com.samsung.controllers.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.entity.User;

@RestController
public class JwtExampleController {

	    @GetMapping("/dfg")
	    public String hello() {
	        return "hello";
	    }

	    @GetMapping("/hello/admin")
	    @PreAuthorize("hasRole('ADMIN')")
	    public String helloAdmin() {
	        return "hello admin";
	    }

	    @GetMapping("/hello/user")
	    public String helloUser() {
	        User userPrincipal =
	                (User) SecurityContextHolder
	                        .getContext()
	                        .getAuthentication()
	                        .getPrincipal();

	        return "hello " + userPrincipal.getUsername();
	    }
}
