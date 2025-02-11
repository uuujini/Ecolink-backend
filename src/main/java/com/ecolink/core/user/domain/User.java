package com.ecolink.core.user.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ecolink.core.common.domain.BaseTimeEntity;
import com.ecolink.core.user.constant.Password;
import com.ecolink.core.user.constant.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// TODO MySQL 전환시 테이블명 `user`로 원복해야함
@Entity(name = "users")
public class User extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotNull
	private String email;

	@NotNull
	private String name;

	@NotNull
	@Enumerated(EnumType.STRING)
	private UserType userType;

	@Embedded
	private Password password;

	private LocalDateTime lastPwChangedDate;

	@NotNull
	private boolean activated;

	@NotNull
	private boolean locked;

	@NotNull
	private boolean expired;

	@NotNull
	private boolean withdrawn;

	private LocalDateTime withdrawnDate;

	@NotNull
	private boolean adAgreed;

	@NotNull
	private boolean analysisAgreed;

	private LocalDate lastLoginDate;

	private String fcmToken;

	@NotNull
	@JoinColumn(name = "role_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Role role;
}
