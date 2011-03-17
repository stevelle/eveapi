package com.beimin.eveapi.shared.assetlist;

import java.util.Collection;
import java.util.HashSet;

public class ApiAsset<A extends ApiAsset<?>> {
	private final Collection<A> assets = new HashSet<A>();
	private long itemID;
	private Long locationID;
	private int typeID;
	private int quantity;
	private int flag;
	private boolean singleton;

	public Collection<A> getAssets() {
		return assets;
	}

	public void addAsset(A asset) {
		assets.add(asset);
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public Long getLocationID() {
		return locationID;
	}

	public void setLocationID(Long locationID) {
		this.locationID = locationID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public boolean getSingleton() {
		return singleton;
	}

	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}
}