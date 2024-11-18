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

@Api(value = "Player Controller", description = "Player Controller Layer")
//@Tag(name = "Player Controller", description = "Player Controller Layer")
@RestController
@RequestMapping("/api")
public class PlayerController {

    @GetMapping("/players")
    @ApiOperation(value = "Display Players", notes = "Empty Object", tags = "employee-controller")
//    @Tag(name = "Player Controller")
    public String getPlayers(){
        return "Welcome Players ...!";
    }

    @GetMapping("/cotchs")
//    @Tag(name = "Employee Controller")
    public String getCoachs() {
        return "Welcome Coachs ...!";
    }
}
