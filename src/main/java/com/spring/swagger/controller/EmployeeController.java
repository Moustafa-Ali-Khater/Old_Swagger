package com.spring.swagger.controller;

import com.spring.swagger.dao.EmployeeRepository;
import com.spring.swagger.model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@Api(value = "Employee Controller", description = "Employee Controller Layer")
//@Tag(name = "Employee Controller", description = "Employee Controller Layer")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getEmployees")
//    @Operation(description = "Display Employee", summary = "Display Employee",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "OK")
//            })
//    @Tag(name = "Employee Controller")
    @ApiOperation(value = "Display Employee",notes = "You must enter id of employee")
    public ResponseEntity<Employee> getEmployees(@RequestParam int id){
        return ResponseEntity.status(HttpStatus.OK).body(
                employeeRepository.findById((long) id).get()
        );
    }

    @PostMapping("/save")
//    @Operation(description = "Save Employee", summary = "Save Employee",
//                responses = {
//                    @ApiResponse(responseCode = "201", description = "Created")
//                })
//    @ApiOperation(value = "Save Employee",notes = "You must pass object of employee")
//    @Tag(name = "Employee Controller")
    @ApiOperation(value = "Save Employee",notes = "You must enter object of employee")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                employeeRepository.save(employee)
        );
    }

    @PutMapping("/update")
//    @Operation(description = "Update Employee", summary = "Update Employee",
//            responses = {
//                    @ApiResponse(responseCode = "201", description = "Updated")
//            })
//    @Tag(name = "Employee Controller")
    @ApiOperation(value = "Update Employee",notes = "You must enter object of employee")
    public void edit(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

    @DeleteMapping("/delete")
//    @Operation(description = "Delete Employee", summary = "Delete Employee",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "Deleted")
//            })
//    @Tag(name = "Employee Controller")
    @ApiOperation(value = "Delete Employee",notes = "You must enter id object of employee")
    public void delete(@RequestParam int id){
        employeeRepository.deleteById((long) id);
    }
}
