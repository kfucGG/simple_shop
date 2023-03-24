package com.example.organizationservice.repositories;

import com.example.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query("from Organization o where o.isWork = false")
    List<Organization> findAllByWorkIsFalse();

    List<Organization> findOrganizationByOwnerId(Long ownerId);
}
