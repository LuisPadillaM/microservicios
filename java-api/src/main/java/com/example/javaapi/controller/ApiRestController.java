package com.example.javaapi.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.javaapi.model.TRMBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.example.javaapi.util.CandidatesUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class ApiRestController {
	@Autowired
	private Environment environment;
	@PostMapping(value = "/trm")
	public Map<String, Object> transformTRM(@RequestBody TRMBody body) {

		Double TRM = Double.parseDouble(Objects.requireNonNull(environment.getProperty("TRM")));
		log.info("Response received."+TRM);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pesos", body.pesos);
		map.put("dolares", body.pesos / TRM);

		return  map;
	}
	@GetMapping(value = "/candidates")
	public ResponseEntity<?> fetchCandidates(@RequestParam(value = "skill", required = false) String skill) {
		log.info("Response received. Params: skill {}", skill);

		// Simple util to help us get some dummy data
		var candidateList = CandidatesUtil.getCandidates();
		if (!StringUtils.isEmpty(skill)) {
			// Filter by skill
			return ResponseEntity.ok(candidateList.stream()
							.filter(candidate -> candidate.getSkillsSet().contains(skill.toLowerCase()))
							.collect(Collectors.toList()));
		}

		return ResponseEntity.ok(candidateList);
	}

}