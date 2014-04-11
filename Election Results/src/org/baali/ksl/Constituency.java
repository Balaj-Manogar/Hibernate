package org.baali.ksl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Constituency
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int consId;
	private String cName;
	private int resultStatus;
	
	@ManyToOne
	@JoinColumn(name="sid")
	private States state;
	
	@ManyToOne
	@JoinColumn(name="did")
	private District district;
	
	public District getDistrict()
	{
		return district;
	}
	public void setDistrict(District district)
	{
		this.district = district;
	}
	public States getState()
	{
		return state;
	}
	public void setState(States state)
	{
		this.state = state;
	}
	public int getConsId()
	{
		return consId;
	}
	public void setConsId(int consId)
	{
		this.consId = consId;
	}
	public String getcName()
	{
		return cName;
	}
	public void setcName(String cName)
	{
		this.cName = cName;
	}
	
	public int getResultStatus()
	{
		return resultStatus;
	}
	public void setResultStatus(int resultStatus)
	{
		this.resultStatus = resultStatus;
	}
	
	

}
