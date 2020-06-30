package com.company.springproject.repository;

import com.company.springproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query(value = "SELECT * FROM roles Where organization=:org AND role=:roleType", nativeQuery = true)
    List<Role> findByOrganizationAndRoleType(String org, String roleType);

    @Query(value = "SELECT * FROM roles Where nic_no=:nicNo", nativeQuery = true)
    Role findByNicNo(String nicNo);
}
