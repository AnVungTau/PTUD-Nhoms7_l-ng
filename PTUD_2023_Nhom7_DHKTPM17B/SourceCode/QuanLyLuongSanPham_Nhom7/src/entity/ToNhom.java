package entity;

import java.util.Objects;

import dao.ToNhom_DAO;

/**
 * @author Nguyễn Thanh An
 */

public class ToNhom {
	private int maTo;
	private String tenTo;
	
	public ToNhom(int maTo, String tenTo) {
		super();
		this.maTo = maTo;
		this.tenTo = tenTo;
	}


	public ToNhom() {
		
	}


	public int getMaTo() {
		return maTo;
	}


	public void setMaTo(int maTo) {
		this.maTo = maTo;
	}


	public String getTenTo() {
		return tenTo;
	}


	public void setTenTo(String tenTo) {
		this.tenTo = tenTo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToNhom other = (ToNhom) obj;
		return Objects.equals(maTo, other.maTo);
	}

	@Override
	public String toString() {
		return tenTo;
	}
	
	public int demSoLuongCongNhan() {
		ToNhom_DAO to_dao = new ToNhom_DAO();
		return to_dao.demSoLuongCongNhan(maTo);
	}
	
	
	
}
