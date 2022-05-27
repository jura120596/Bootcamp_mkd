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

import com.samsung.*;
import com.samsung.entity.*;
import com.samsung.service.*;
import com.samsung.models.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/object")
@RequiredArgsConstructor
public class ObjectController {
	
	private final AddressService as;
	private final ObjectService os;
	private final RepairService rs;
	private final CommService cs;

	@ResponseBody
	@GetMapping("/")
	public List<ObjectDTO> getAll() {
		return os.getAll().stream().map(ObjectDTO::toDto).collect(Collectors.toList());
	}
	@ResponseBody
	@PostMapping("/")
	public ObjectDTO create(@RequestBody() ObjectDTO dto) {
		ObjectMkd  o = ObjectDTO.fromDto(dto);
		os.save(o);
		return ObjectDTO.toDto(o);
	}
	@ResponseBody
	@PutMapping("/update")
	public ObjectDTO update(@RequestBody() ObjectDTO dto, HttpServletResponse r) {
		ObjectMkd  o = os.getById(dto.getId());
		System.out.println(dto);
		if (o == null) {
			r.setStatus(401);
			return null;
		}
		dto.getAddress().setId(
				o.getAddress().getId()
				);
		o = ObjectDTO.fromDto(dto);
		o.setId(dto.getId());
		os.save(o);
		return ObjectDTO.toDto(o);
	}
	@ResponseBody
	@GetMapping("/{id}/repair")
	public RepairDataDTO getRepair(@PathVariable("id") int id, HttpServletResponse r) {
		ObjectMkd  o = os.getById(id);
		if (o == null) {
			r.setStatus(404);
			return null;
		}
		RepairData rd = rs.getByObject(o);
		return rd == null ? null :RepairDataDTO.toDto(rd);
	}
	@ResponseBody
	@PutMapping("/{id}/repair")
	public RepairDataDTO updatetRepair(@RequestBody RepairDataDTO dto, @PathVariable("id") int id,HttpServletResponse r) {
		ObjectMkd  o = os.getById(id);
		if (o == null) {
			r.setStatus(404);
			return null;
		}
		RepairData rd = rs.getByObject(o);
		if (rd != null) {
			rs.deleteById(rd.getId());
		}
		rd = RepairDataDTO.fromDto(dto);
		rd.setObject(o);
		rs.save(rd);
		return RepairDataDTO.toDto(rd);
	}
	@ResponseBody
	@GetMapping("/{id}/comm")
	public CommunicationDTO getComm(@PathVariable("id") int id, HttpServletResponse r) {
		ObjectMkd  o = os.getById(id);
		if (o == null) {
			r.setStatus(404);
			return null;
		}
		Communication rd = cs.getByObject(o);
		return rd == null ? null :CommunicationDTO.toDto(rd);
	}
	@ResponseBody
	@PutMapping("/{id}/comm")
	public CommunicationDTO updatetComm(@RequestBody CommunicationDTO dto, @PathVariable("id") int id,HttpServletResponse r) {
		ObjectMkd  o = os.getById(id);
		if (o == null) {
			r.setStatus(404);
			return null;
		}
		Communication c = cs.getByObject(o);
		if (c != null) {
			cs.deleteById(c.getId());
		}
		c = CommunicationDTO.fromDto(dto);
		c.setObject(o);
		cs.save(c);
		return CommunicationDTO.toDto(c);
	}
	

}
