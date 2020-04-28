package org.sid.springmvc.web;

import org.sid.springmvc.dao.PatientRepository;
import org.sid.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PatientRestController {

	@Autowired
	PatientRepository patientRepository;

	@GetMapping(path="/listPatients")
	public List<Patient> listPatients() {
		return patientRepository.findAll();
	}

    @GetMapping(path="/patients/{id}")
    public Patient getOne(@PathVariable Long id) {
	    return patientRepository.findById(id).get();
    }
}
