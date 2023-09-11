package in.mitrabhanu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.mitrabhanu.model.UserAccount;
import in.mitrabhanu.service.UserAccountService;

@Controller
public class UserAccountController {

	@Autowired
	private UserAccountService service;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new UserAccount());
		return "index";
	}

	@PostMapping("/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount userAcc, Model model) {

		String saveOrUpdateUserAcc = service.saveOrUpdateUserAcc(userAcc);
		System.out.println(saveOrUpdateUserAcc);
		
		model.addAttribute("message", saveOrUpdateUserAcc);
		return "index";
	}
	
	@GetMapping("/users")
	public String viewUsers(Model model) {
		List<UserAccount> allUserAcc = service.getAllUserAcc();
		model.addAttribute("list", allUserAcc);
		return "UserAccountData";
	}
	
	public String editUser(Integer userId, Model model) {
		return null;
	}
	
	@GetMapping("/delete")
	public String deleteUser(Integer userId, Model model) {
		
		service.delete(userId);
		
		List<UserAccount> allUserAcc = service.getAllUserAcc();
		
		model.addAttribute("allUserAcc", allUserAcc);

		return "UserAccountData";
	}
	
	public String changeAccStatus(Integer userId, String status) {
		return null;
	}
}
