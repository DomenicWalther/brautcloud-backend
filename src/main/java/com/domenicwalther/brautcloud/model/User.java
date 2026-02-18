package com.domenicwalther.brautcloud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String lastName;

	private String firstNameCoupleOne;

	private String firstNameCoupleTwo;

	@Column(insertable = false, updatable = false)
	private LocalDateTime createdAt;

	private String email;

	private boolean emailVerified;

	private String password;

	@OneToMany(mappedBy = "user")
	private List<Event> events;

}
