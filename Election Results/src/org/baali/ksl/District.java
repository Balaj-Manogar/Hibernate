package org.baali.ksl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class District
{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int did;
	private String name;
	@ManyToOne
	@JoinColumn(name="sid")	
	private States state;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="district")
	private Collection<Constituency> constituency = new ArrayList<Constituency>();
	
	
	
	public Collection<Constituency> getConstituency()
	{
		return constituency;
	}
	public void setConstituency(Collection<Constituency> constituency)
	{
		this.constituency = constituency;
	}
	public States getState()
	{
		return state;
	}
	public void setState(States state)
	{
		this.state = state;
	}
	public int getDid()
	{
		return did;
	}
	public void setDid(int did)
	{
		this.did = did;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
}
