package in.mitrabhanu.service;

import java.util.List;

import in.mitrabhanu.model.UserAccount;

public interface UserAccountService {

	public String saveOrUpdateUserAcc(UserAccount userAcc);
	public List<UserAccount> getAllUserAcc(); 
	public UserAccount getUserAcc(Integer userId);
	public Boolean delete(Integer userId);
	public Boolean updateUserAccStatus(Integer userId, String status);
}
