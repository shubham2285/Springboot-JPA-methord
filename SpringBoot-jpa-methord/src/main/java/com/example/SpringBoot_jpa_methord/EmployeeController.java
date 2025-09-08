package com.example.SpringBoot_jpa_methord;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository merepo;

    @GetMapping("/test")
    public String test() {
        return "this is test only";
    }

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        return merepo.save(employee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> alldata() {
        return new ResponseEntity<>(merepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/byid/{id}")
    public Optional<Employee> byid(@PathVariable int id) {
        return merepo.findById(id);
    }

    @GetMapping("/byname/{name}")
    public List<Employee> findByName(@PathVariable String name) {
        return merepo.findByName(name);
    }

    @GetMapping("/by/{city}")
    public List<Employee> findByCity(@PathVariable String city) {
        return merepo.findByCity(city);
    }

    @GetMapping("/byor/{name}/{city}")//byor- means dodo mai se kch v dal sakte h name or city dono
    public List<Employee> findByNameOrCity(@PathVariable String name, @PathVariable String city) {
        return merepo.findByNameOrCity(name, city);
    }

    @GetMapping("/by/age")
    public List<Employee> byageall(@RequestParam List<Integer> age) {
        return merepo.findByAgeIn(age);
    }
}
