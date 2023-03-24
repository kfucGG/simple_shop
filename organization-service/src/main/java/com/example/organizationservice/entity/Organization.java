package com.example.organizationservice.entity;


import com.example.organizationservice.dto.OrganizationDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(generator = "organization_seq")
    @SequenceGenerator(name = "organization_seq", sequenceName = "organization_seq")
    private Long id;
    private Long ownerId;
    private String name;
    private String description;
    private boolean isWork;
    @ElementCollection
    private List<Long> products;

    public Organization(OrganizationDTO organizationDTO, Long ownerId) {
        this.name = organizationDTO.getName();
        this.description = organizationDTO.getDescription();
        this.ownerId = ownerId;
    }
}
