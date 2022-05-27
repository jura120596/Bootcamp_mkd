package com.samsung.controllers.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.samsung.entity.User;
import com.samsung.models.AddressDTO;
import com.samsung.models.UserDTO;
import com.samsung.requests.LoginBody;
import com.samsung.responses.TokenResponse;
import com.samsung.service.AddressService;
import com.samsung.service.TokenService;
import com.samsung.service.UserService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
	private final AddressService ar;
	
	@ResponseBody
	@GetMapping("/")
	public List<AddressDTO> getAll() {
		return ar.getAll().stream().map(AddressDTO::toDto).collect(Collectors.toList());
	}
}
