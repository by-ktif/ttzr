package pl.ktif.ttlz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ktif.ttlz.dao.UserDAO;
import pl.ktif.ttlz.model.User;
import pl.ktif.ttlz.model.dto.UserDTO;

@Service
@Transactional
public class UserService {
	@Autowired
	UserDAO userDao;
	
	@Autowired
	TournamentService tournamentService;
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	private List<UserDTO> toDTOs(List<User> users) {
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for (User user : users) {
			dtos.add(toDTO(user));
		}
		return dtos;
	}
	
	private UserDTO toDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		return dto;
	}

	public List<UserDTO> getTournamentUserDTOs(int tournamentId) {
		return toDTOs(tournamentService.getTournament(tournamentId).getUsers());
	}

}
