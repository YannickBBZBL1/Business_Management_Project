package com.business.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private double pprice;
    private String pdescription;
    private double pweight;

    public Product(int pid, String pname, String pdescription, double pweight) {
        this.pid = pid;
        this.pname = pname;
        this.pdescription = pdescription;
        this.pweight = pweight;
    }

    public Product(){

    }

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
    public double getPweight(){return this.pweight;}
    public void setPweight(double weight){ this.pweight = weight; }

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pdescription=" + pdescription
				+ "]";
	}



}
