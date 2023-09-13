package in.mitrabhanu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("user", new UserAccount());
		return "index";
	}
	
	@GetMapping("/users")
	public String viewUsers(Model model) {
		List<UserAccount> allUserAcc = service.getAllUserAcc();
		model.addAttribute("list", allUserAcc);
		return "UserAccountData";
	}
	
	@GetMapping("/edit")
	public String editUser(@RequestParam("userId") Integer userId, Model model) {
		
		UserAccount userAcc = service.getUserAcc(userId);
		
		model.addAttribute("user", userAcc);
		
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") Integer userId, Model model) {
		
		service.delete(userId);
		
		String message = "User '"+userId+"' is Deleted Successfully.";
		
		model.addAttribute("message", message);
		
		return "forward:/users";
	}
	
	@GetMapping("/update")
	public String changeAccStatus(@RequestParam("userId") Integer userId,
			                      @RequestParam("status") String status, Model model
			                      ) {
		
		service.updateUserAccStatus(userId, status);
		
		if("Y".equals(status)) {
		    model.addAttribute("message", "Status is Activated");	
		}
		else {
			model.addAttribute("message", "Status is De-Activated");
		}
		
		return "forward:/users";
	}
}
