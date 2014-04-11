package org.baali.ksl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class States
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	private String name;
	private int isUnionTerritory;
	@OneToMany(mappedBy="state")
	private Collection<Constituency> constituency = new ArrayList<Constituency>();
	
	@OneToMany(mappedBy="state")
	private Collection<District> district = new ArrayList<District>();
	
	
	
	public Collection<District> getDistrict()
	{
		return district;
	}
	public void setDistrict(Collection<District> district)
	{
		this.district = district;
	}
	public Collection<Constituency> getConstituency()
	{
		return constituency;
	}
	public void setConstituency(Collection<Constituency> constituency)
	{
		this.constituency = constituency;
	}
	public int getSid()
	{
		return sid;
	}
	public void setSid(int sid)
	{
		this.sid = sid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getIsUnionTerritory()
	{
		return isUnionTerritory;
	}
	public void setIsUnionTerritory(int isUnionTerritory)
	{
		this.isUnionTerritory = isUnionTerritory;
	}
	



}