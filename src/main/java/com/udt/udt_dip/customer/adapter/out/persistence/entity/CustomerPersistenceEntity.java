package com.udt.udt_dip.customer.adapter.out.persistence.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter
public class CustomerPersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String residentNumber;
}
