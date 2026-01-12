package com.insurance.user.service;

import org.springframework.stereotype.Service;

import com.insurance.user.DTO.ProfileDto;
import com.insurance.user.entity.Profile;
import com.insurance.user.exception.UserNotFoundException;
import com.insurance.user.repository.UserRepository;

@Service

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public ProfileDto saveUser(ProfileDto profileDto) {

        if (userRepository.existsByEmail(profileDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Profile profile = mapToProfile(profileDto);
        Profile savedProfile = userRepository.save(profile);

        return mapToProfileDto(savedProfile);
    }

    public ProfileDto getProfileById(Long id) {
        Profile profile = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id " + id));

        return mapToProfileDto(profile);
    }

    public ProfileDto updateProfile(Long id, ProfileDto profileDto) {

        Profile profile = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id " + id));

        profile.setName(profileDto.getName());
        profile.setEmail(profileDto.getEmail());

        return mapToProfileDto(userRepository.save(profile));
    }

    public String deleteUser(Long id) {

        Profile profile = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id " + id));

        userRepository.delete(profile);
        return "User deleted successfully";
    }

    // Mapper methods
    public Profile mapToProfile(ProfileDto profileDto) {
		Profile profile=new Profile();
		profile.setName(profileDto.getName());
		profile.setEmail(profileDto.getEmail());
		return profile;
	}

    public ProfileDto mapToProfileDto(Profile profile) {
		ProfileDto dto=new ProfileDto();
		dto.setName(profile.getName());
		dto.setEmail(profile.getEmail());
		return dto;
	}
}