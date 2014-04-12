package org.baali.ksl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Party
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String name;
	@ManyToOne
	@JoinColumn(name="gid")
	private Group group;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="party")
	private Collection<Candidate> candidate = new ArrayList<Candidate>();
	
	public Collection<Candidate> getCandidate()
	{
		return candidate;
	}
	public void setCandidate(Collection<Candidate> candidate)
	{
		this.candidate = candidate;
	}
	public int getPid()
	{
		return pid;
	}
	public void setPid(int pid)
	{
		this.pid = pid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Group getGroup()
	{
		return group;
	}
	public void setGroup(Group group)
	{
		this.group = group;
	}

}
