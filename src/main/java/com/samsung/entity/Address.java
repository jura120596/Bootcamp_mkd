package com.samsung.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
@Transactional
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Column(name = "country")
    private String country;
	@Column(name = "region")
    private String region;
	@Column(name = "locality")
    private String locality;
	@Column(name = "street")
    private String street;
	@Column(name = "created_at")
    private Date created_at;
	@OneToMany(mappedBy="address")
	private List<ObjectMkd> object;
}
