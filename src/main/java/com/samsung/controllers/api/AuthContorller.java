package com.samsung.controllers.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.samsung.entity.User;
import com.samsung.models.UserDTO;
import com.samsung.requests.LoginBody;
import com.samsung.responses.TokenResponse;
import com.samsung.service.TokenService;
import com.samsung.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthContorller {
	
	private final UserService us;
	private final TokenService ts;
	private final BCryptPasswordEncoder encoder;
	@RequestMapping("/")
	public String temp(HttpServletRequest req, HttpServletResponse res) {
		return "HeeloWorld";
	}
	
	@PostMapping("/profile")
	@ResponseBody
	public UserDTO profile(HttpServletRequest request, HttpServletResponse res) {
		UserDTO user =
                (UserDTO) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();
		return user;
	}
	
	@ResponseBody
	@PostMapping("/auth/login")
	public TokenResponse login(@RequestBody LoginBody request,
			HttpServletResponse response) 
	{
		try {
			User user = us.loadUserByUsername(request.getLogin());
			if (user != null && encoder.matches(request.getPassword(), user.getPassword())) {
				return new TokenResponse(ts.generateToken(user), 1, new UserDTO(user.getId(), user.getUsername(), false));
			}
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
		}
		response.setStatus(401);
		return new TokenResponse("null", 0, null);
	}

}
