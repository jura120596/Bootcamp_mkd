package com.samsung.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "communications")
@Transactional
public class Communication{
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="data")
    private String data;
	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name="object_id")
	private ObjectMkd object;
}