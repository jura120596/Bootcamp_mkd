package com.samsung.entity;


import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "repairs")
@Transactional
public class RepairData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Column(name = "substructure")
    private int substructure;
	@Column(name = "facade")
    private int facade;
	@Column(name = "roof")
    private int roof;
	@Column(name = "elevator")
    private int elevator;
	@Column(name = "energy")
    private int energy;
	@Column(name = "heating")
    private int heating;
	@Column(name = "watter")
    private int watter;
	@Column(name = "hot_watter")
    private int hotWatter;
	@Column(name = "watter_out")
    private int watterOut;
	@Column(name = "other")
    private int other;
	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name="object_id")
	private ObjectMkd object;
}
