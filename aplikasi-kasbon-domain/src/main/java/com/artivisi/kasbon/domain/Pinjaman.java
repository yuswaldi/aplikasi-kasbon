package com.artivisi.kasbon.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_pinjaman")
public class Pinjaman {
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="id_peminjam", nullable=false)
	private Karyawan peminjam;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private StatusPinjaman status = StatusPinjaman.DISETUJUI;
	
	@Column(nullable=false)
	private BigDecimal nilai;
	
	@Column(nullable=false)
	private BigDecimal saldo;
	
	@OneToMany(mappedBy="pinjaman", 
			cascade=CascadeType.ALL, 
			orphanRemoval=true)
	private List<Pencairan> daftarPencairan = new ArrayList<Pencairan>();
	
	@OneToMany(mappedBy="pinjaman", 
			cascade=CascadeType.ALL, 
			orphanRemoval=true)
	private List<Pembayaran> daftarPembayaran = new ArrayList<Pembayaran>();
}