package com.ojas.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ojas.entity.User;

import com.ojas.repo.UserRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

//	@Autowired
	// private JavaMailSender mailSender;
	@Override
	public User registerUser(User user) {
		//String randomeCode = RandomString.make(64);
	//	user.setVerificationCode(randomeCode);
		return userRepo.save(user);

	}
//	public void sendVerificationEmail(User user, String siteURL) throws UnsupportedEncodingException, MessagingException {
//		String subject="please verify your registation";
//		String senderName="Tourism management Team";
//		String mailContent="<p>Dear "+ user.getName()+"</p>";
//		mailContent +="<p>Please click the link below to verify to your registation :</p>";
//		String verifyURL=siteURL + "/verify?code=" +user.getVerificationCode();
//		mailContent +="<h3><a href=\"" +verifyURL+ "\">VERIFY</a></h3>";
//		mailContent +="<p>Thank You<br>Tourism management Team</p>";

//		MimeMessage message=mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message);
//		helper.setFrom("nagaraju.madikanti31@gmail.com", senderName);
//		helper.setTo(user.getEmail());
//		helper.setSubject(subject);
//		
//		helper.setText(mailContent, true);
//		mailSender.send(message);
//	}
//	public boolean verify(String verificationCode) {
//		User user=userRepo.findByVerificationCode(verificationCode);
////		if(user==null||user.isEnabled()) {
////			return false;
////		}else {
////			userRepo.enable(user.getId());
////		}
//		return false;
//		
//	}
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUserId(int id) {

		return userRepo.findById(id);
	}

	@Override
	public void delete(int id) {
		userRepo.deleteById(id);

	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User saveOrUpdate(User user) {

		return userRepo.save(user);
	}

	@Override
	public User login(String username, String password) {
		User user = userRepo.findByUsernameAndPassword(username, password);
		return user;
	}

}
