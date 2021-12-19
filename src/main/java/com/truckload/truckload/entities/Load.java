package com.truckload.truckload.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "load")
@Entity
public class Load {
	
	@Id
	private long loadId;
	private String loadingPoint;
	private String unloadingPoint;
	private String truckType;
	private Integer noOfTrucks;
	private double truckWeight;
	private String comment;
	private long shipperId;
	private String date;
	
	public Load(long loadId, String loadingPoint, String unloadingPoint, String truckType, Integer noOfTrucks,
			double truckWeight, String comment, long shipperId, String date) {
		super();
		this.loadId = loadId;
		this.loadingPoint = loadingPoint;
		this.unloadingPoint = unloadingPoint;
		this.truckType = truckType;
		this.noOfTrucks = noOfTrucks;
		this.truckWeight = truckWeight;
		this.comment = comment;
		this.shipperId = shipperId;
		this.date = date;
	}
	public Load() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getLoadId() {
		return loadId;
	}
	public void setLoadId(long loadId) {
		this.loadId = loadId;
	}
	public String getLoadingPoint() {
		return loadingPoint;
	}
	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}
	public String getUnloadingPoint() {
		return unloadingPoint;
	}
	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}
	public String getTruckType() {
		return truckType;
	}
	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	public Integer getNoOfTrucks() {
		return noOfTrucks;
	}
	public void setNoOfTrucks(Integer noOfTrucks) {
		this.noOfTrucks = noOfTrucks;
	}
	public double getTruckWeight() {
		return truckWeight;
	}
	public void setTruckWeight(double truckWeight) {
		this.truckWeight = truckWeight;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public long getShipperId() {
		return shipperId;
	}
	public void setShipperId(long shipperId) {
		this.shipperId = shipperId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Load [loadId=" + loadId + ", loadingPoint=" + loadingPoint + ", unloadingPoint=" + unloadingPoint
				+ ", truckType=" + truckType + ", noOfTrucks=" + noOfTrucks + ", truckWeight=" + truckWeight
				+ ", comment=" + comment + ", shipperId=" + shipperId + ", date=" + date + "]";
	}
	
	
}
