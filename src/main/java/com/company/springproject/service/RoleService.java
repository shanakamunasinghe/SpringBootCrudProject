package com.company.springproject.service;

import com.company.springproject.dto.RetrieveDTO;
import com.company.springproject.dto.RoleDTO;
import com.company.springproject.model.Role;
import com.company.springproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public RoleDTO roleToRoleDTOMapper(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setFirstName(role.getFirstName());
        roleDTO.setLastName(role.getLastName());
        roleDTO.setNicNo(role.getNicNo());
        roleDTO.setOrganization(role.getOrganization());
        roleDTO.setRole(role.getRole());
        return roleDTO;
    }

    public Role roleDTOToRoleMapper(RoleDTO roleDTO) {
        Role role = new Role();
        role.setFirstName(roleDTO.getFirstName());
        role.setLastName(roleDTO.getLastName());
        role.setNicNo(roleDTO.getNicNo());
        role.setOrganization(roleDTO.getOrganization());
        role.setRole(roleDTO.getRole());
        return role;
    }

    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDTO> rolesDTOS = new ArrayList<>();
        if (roles != null) {
            for (Role role : roles) {
                rolesDTOS.add(roleToRoleDTOMapper(role));
            }
        }
        return rolesDTOS;
    }

    public RoleDTO getRoleById(int id) {
        Role role = roleRepository.getOne(id);
        if(role != null){
            return roleToRoleDTOMapper(role);
        }
        // in here as the notfound it return null object
        return new RoleDTO();
    }

    public int addRole(RoleDTO roleDTO) {
        if(roleDTO == null){
            return 0;
        }
        Role role = roleDTOToRoleMapper(roleDTO);
        role.setCreatedDate(new Date());
        // if duplicate entry add then exception pop up
        roleRepository.save(role);
        return 1;
    }

    public int updateRole(RoleDTO roleDTO){
        Role role = roleRepository.getOne(roleDTO.getId());
        if(role == null){
            return 0;
        }
        role.setFirstName(roleDTO.getFirstName());
        role.setLastName(roleDTO.getLastName());
        role.setNicNo(roleDTO.getNicNo());
        role.setOrganization(roleDTO.getOrganization());
        role.setRole(roleDTO.getRole());
        role.setUpdatedDate(new Date());
        roleRepository.save(role);
        return 1;
    }

    public int deleteRole(RoleDTO roleDTO){
        Role role = roleRepository.getOne(roleDTO.getId());
        if(role == null){
            return 0;
        }
        roleRepository.delete(role);
        return 1;
    }

    public List<RetrieveDTO> getAllByOrganizationAndRoleType(String org, String roleType){
        List<Role> roles = roleRepository.findByOrganizationAndRoleType(org,roleType);
        List<RetrieveDTO> retrieveDTOS = new ArrayList<>();
        if(roles != null){
            for(Role role : roles){
                RetrieveDTO retrieveDTO = new RetrieveDTO();
                retrieveDTO.setFirstName(role.getFirstName());
                retrieveDTO.setLastName(role.getLastName());
                retrieveDTO.setNicNo(role.getNicNo());
                retrieveDTOS.add(retrieveDTO);
            }
        }
        return retrieveDTOS;
    }

    public RoleDTO getRoleByNIC(String nicNo){
        Role role = roleRepository.findByNicNo(nicNo);
        if(role != null){
            return roleToRoleDTOMapper(role);
        }
        // sending null object if not found
        return new RoleDTO();
    }
}
