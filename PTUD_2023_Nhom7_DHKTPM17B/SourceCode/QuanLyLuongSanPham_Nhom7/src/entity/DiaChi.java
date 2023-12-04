package entity;

import java.util.Objects;
/**
 * @author Nguyễn Hồng Quân
 */
public class DiaChi {
	private float id;
	private String tenDC;
	private float cap;
	private float parentID;	
	
	public DiaChi() {
		
	}
	
	public DiaChi(float id) {
		this.id = id;
	}

	public DiaChi(float id, String tenDC, float cap, float parentID) {
		super();
		this.id = id;
		this.tenDC = tenDC;
		this.cap = cap;
		this.parentID = parentID;
	}
	
	
	public float getId() {
		return id;
	}
	public void setId(float id) {
		this.id = id;
	}
	public String getTenDC() {
		return tenDC;
	}
	public void setTenDC(String tenDC) {
		this.tenDC = tenDC;
	}
	public float getCap() {
		return cap;
	}
	public void setCap(float cap) {
		this.cap = cap;
	}
	public float getParentID() {
		return parentID;
	}
	public void setParentID(float parentID) {
		this.parentID = parentID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiaChi other = (DiaChi) obj;
		return Float.floatToIntBits(id) == Float.floatToIntBits(other.id);
	}
	@Override
	public String toString() {
		return tenDC;
	}
	
	
}
