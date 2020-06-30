package com.company.springproject.controller;

import com.company.springproject.dto.RequestDTO;
import com.company.springproject.dto.RetrieveDTO;
import com.company.springproject.dto.RoleDTO;
import com.company.springproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/rolesData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return new ResponseEntity<List<RoleDTO>>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @RequestMapping(value = "/roleData/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable("id") Integer id) {
        return new ResponseEntity<RoleDTO> (roleService.getRoleById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/getRoleByNIC/{nic}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDTO> getRoleByNIC(@PathVariable("nic") String nic) {
        return new ResponseEntity<RoleDTO> (roleService.getRoleByNIC(nic), HttpStatus.OK);
    }

    @RequestMapping(value = "/addRole",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addRole(@RequestBody RoleDTO roleDTO){
        int statusCode = roleService.addRole(roleDTO);
        if(statusCode == 0){
            return new ResponseEntity<String>("error in adding role",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("successfully added role",HttpStatus.OK);
    }

    @RequestMapping(value = "/updateRole",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateRole(@RequestBody RoleDTO roleDTO){
        int statusCode = roleService.updateRole(roleDTO);
        if(statusCode == 0){
            return new ResponseEntity<String>("error in updating role",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("successfully updated role",HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteRole",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteRole(@RequestBody RoleDTO roleDTO) {
        int statusCode = roleService.deleteRole(roleDTO);
        if(statusCode == 0) {
            return new ResponseEntity<String>("error in deleting role",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("successfully delete role",HttpStatus.OK);
    }

    @RequestMapping(value = "/getRolesByOrgAndRoleType",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RetrieveDTO>> getRolesByOrgAndRoleType(@RequestBody RequestDTO requestDTO){
        return new ResponseEntity<List<RetrieveDTO>>(roleService.getAllByOrganizationAndRoleType(requestDTO.getOrganization(),requestDTO.getRole()),HttpStatus.OK);
    }
}
