package com.company.springproject.controller;

import com.company.springproject.dto.RequestDTO;
import com.company.springproject.dto.RetrieveDTO;
import com.company.springproject.dto.RoleDTO;
import com.company.springproject.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/role")
@Api(value = "rolesCrudOperations")
public class RoleController {

    @Autowired
    RoleService roleService;

    @ApiOperation(value = "View a list of available roles", response = ArrayList.class, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/rolesData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        return new ResponseEntity<List<RoleDTO>>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @ApiOperation(value = "View a role using id", response = RoleDTO.class, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/roleData/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable("id") Integer id) {
        return new ResponseEntity<RoleDTO>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "View a role using nic", response = RoleDTO.class, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getRoleByNIC/{nic}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleDTO> getRoleByNIC(@PathVariable("nic") String nic) {
        return new ResponseEntity<RoleDTO>(roleService.getRoleByNIC(nic), HttpStatus.OK);
    }

    @ApiOperation(value = "Add role data", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created role"),
            @ApiResponse(code = 400, message = "No content to delete")})
    @RequestMapping(value = "/addRole",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addRole(@RequestBody RoleDTO roleDTO) {
        int statusValue = roleService.addRole(roleDTO);
        // only considering not having an object that not a Assistant or Driver
        if (statusValue == 0) {
            return new ResponseEntity<String>("error in adding role", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("successfully added role", HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update role data", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateRole",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateRole(@RequestBody RoleDTO roleDTO) {
        int statusValue = roleService.updateRole(roleDTO);
        // only consider not found exception
        if (statusValue == 0) {
            return new ResponseEntity<String>("error in updating role", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("successfully updated role", HttpStatus.OK);
    }

    @ApiOperation(value = "delete role data", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted role"),
            @ApiResponse(code = 204, message = "No content to delete")})
    @RequestMapping(value = "/deleteRole",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteRole(@RequestBody RoleDTO roleDTO) {
        int statusValue = roleService.deleteRole(roleDTO);
        // only considered not found exception
        if (statusValue == 0) {
            return new ResponseEntity<String>("error in deleting role", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("successfully delete role", HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of available roles using organization and role type", response = ArrayList.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/getRolesByOrgAndRoleType",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RetrieveDTO>> getRolesByOrgAndRoleType(@RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<List<RetrieveDTO>>(roleService.getAllByOrganizationAndRoleType(requestDTO.getOrganization(), requestDTO.getRole()), HttpStatus.OK);
    }
}
