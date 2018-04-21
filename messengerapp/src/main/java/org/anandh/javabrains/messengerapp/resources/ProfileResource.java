package org.anandh.javabrains.messengerapp.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.anandh.javabrains.messengerapp.model.Profile;
import org.anandh.javabrains.messengerapp.service.ProfileService;
import javax.ws.rs.core.MediaType;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService=new ProfileService();
	
//	@GET
//	@Path("{test}")
//	public String test(@PathParam("test")String test)
//	{
//		return test;
//	}
	@GET
	public List<Profile> getProfiles()
	{
		List<Profile>profileList=profileService.getAllProfiles();
		System.out.println(profileList);
		return profileList;
	}
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName")String profileName)
	{
		return profileService.getProfile(profileName);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName")String profileName,Profile profile)
	{
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	@POST
	public Profile addProfile(Profile profile)
	{
		Profile addedprofile= profileService.addProfile(profile);;
		System.out.println(addedprofile);
		return  addedprofile;
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName")String profileName)
	{
		profileService.remove(profileName);
	}

}
