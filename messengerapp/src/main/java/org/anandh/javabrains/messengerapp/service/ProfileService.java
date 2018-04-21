package org.anandh.javabrains.messengerapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.anandh.javabrains.messengerapp.database.DataBaseClass;
import org.anandh.javabrains.messengerapp.model.Profile;

public class ProfileService {
	private Map<String,Profile>profiles=DataBaseClass.getAllProfiles();
	
	public ProfileService()
	{
		profiles.put("Anandh", new Profile(1L, "Anandh", "Thenu", "Priya", new Date()));
	}
	
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
		
	}
	public Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size()+1);
		profile.setCreated(new Date());
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	public Profile remove( String profileName)
	{
		return profiles.remove(profileName);
	}
	
	public Profile updateProfile(Profile profile)
	{
		if(profiles.get(profile.getProfileName())==null)
		{
			return null;
		}
		profile.setCreated(new Date());
		
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}

}
