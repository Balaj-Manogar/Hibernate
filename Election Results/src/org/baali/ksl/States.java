package org.baali.ksl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class States
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	private String name;
	private int isUnionTerritory;
	@ElementCollection
	@JoinTable( name="constituency",
			joinColumns=@JoinColumn(name="sid")
	)
	private Set<Constituency> constituency = new HashSet<>();
	

	public Set<Constituency> getConstituency()
	{
		return constituency;
	}
	public void setConstituency(Set<Constituency> constituency)
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