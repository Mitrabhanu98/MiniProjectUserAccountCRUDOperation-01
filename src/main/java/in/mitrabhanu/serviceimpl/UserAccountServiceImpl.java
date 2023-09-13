package in.mitrabhanu.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mitrabhanu.model.UserAccount;
import in.mitrabhanu.repo.UserAccountRepo;
import in.mitrabhanu.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	UserAccountRepo repo;

	public String saveOrUpdateUserAcc(UserAccount userAcc) {

		Integer userId = userAcc.getUserId();
		
		if(userId==null) {
			userAcc.setActiveSw("Y");
		}

		repo.save(userAcc);
		
		if(userId == null) {
			return "UserAccount Created Successfully";
		}
		else {
		return "UserAccount Updated Successfully";
		}
	}	

	public List<UserAccount> getAllUserAcc() {
		return repo.findAll();
	}

	public UserAccount getUserAcc(Integer userId) {

		Optional<UserAccount> findById = repo.findById(userId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	public Boolean delete(Integer userId) {

		boolean existsById = repo.existsById(userId);
		
		if(existsById) {
    	repo.deleteById(userId);
		return true;
		}
		return false;
	}

	public Boolean updateUserAccStatus(Integer userId, String status) {

		try {
			repo.updateUserAccStatus(userId, status);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
