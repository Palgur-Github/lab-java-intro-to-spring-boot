package ironhack.schl.Lab4_02.controller.impl;

import ironhack.schl.Lab4_02.model.Doctor;
import ironhack.schl.Lab4_02.model.Status;
import ironhack.schl.Lab4_02.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;
    private Status status;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{employeeId}")
    public Doctor getDoctorsById(@PathVariable Integer employeeId) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(employeeId);
        if (doctorOptional.isEmpty()) return null;
        return doctorOptional.get();
    }

    @GetMapping("/doctors/status/{status}")
    public List<Doctor> getDoctorsByStatus(
            @RequestParam(defaultValue = "ON_CALL") Status status
    ) {
        this.status = status;
        return doctorRepository.findAllByStatus(status);
    }


    @GetMapping("/employee/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public String getDoctorsByStatus() {
        return "This is a response from a RESTful web service";
    }


    @GetMapping("/doctors/department/{department}")
    public List<Doctor> getDoctorsByDepartment(
            @RequestParam(defaultValue = "cardiology") String department
    ) {
        return doctorRepository.findAllByDepartment(department);
    }

}