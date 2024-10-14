package com.example.customer_example.model;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

  @Id
  @Column(nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "first_name", length = 100, nullable = false)
  private String firstName;

  @Column(name = "last_name", length = 100, nullable = false)
  private String lastName;

  @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
  private Boolean isActive;

  @Column(nullable = true, length = 100)
  private Integer age;

  @Column(nullable = true, length = 255)
  private String address;

  @Column(nullable = true, length = 150)
  private String city;

  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "updated_at")
  private Instant updatedAt;

  public Customer() {
  }

  public Customer(final String firstName, final String lastName, final Integer age, final String address,
      final String city) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.isActive = true;
    this.age = age;
    this.city = city;
    this.createdAt = Instant.now();
    this.updatedAt = Instant.now();
  }

  public UUID getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public Boolean getIsActive() {
    return this.isActive;
  }

  public Integer getAge() {
    return this.age;
  }

  public String getAddress() {
    return this.address;
  }

  public String getCity() {
    return this.city;
  }

  public Instant getCreatedAt() {
    return this.createdAt;
  }

  public Instant getUpdatedAt() {
    return this.updatedAt;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }
}
