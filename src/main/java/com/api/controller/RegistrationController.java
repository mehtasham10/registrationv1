package com.api.controller;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.service.RegistratonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
private RegistratonService registratonService;

    public RegistrationController(RegistratonService registratonService) {
        this.registratonService = registratonService;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistrations(){
    List<RegistrationDto> dto=registratonService.getRegistration();
    return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createRegistration(
            @Valid @RequestBody RegistrationDto registrationdto ,BindingResult result
    ){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.CREATED);

        }
        RegistrationDto regdto = registratonService.createregistration(registrationdto);
        return new ResponseEntity<>(regdto,HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(
          @RequestParam long id
    ){
        registratonService.deleteRegistration(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(
            @PathVariable long id,@RequestBody Registration registration)
    {
        Registration updateReg=registratonService.updateRegistration(id,registration);
        return new ResponseEntity<>(updateReg,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegById(@PathVariable long id){
        RegistrationDto dto=registratonService.getRegistrationById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

}
