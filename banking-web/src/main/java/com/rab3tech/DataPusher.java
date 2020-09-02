package com.rab3tech;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rab3tech.admin.dao.repository.AccountStatusRepository;
import com.rab3tech.admin.dao.repository.AccountTypeRepository;
import com.rab3tech.admin.dao.repository.MagicCustomerRepository;
import com.rab3tech.customer.dao.repository.LoginRepository;
import com.rab3tech.customer.dao.repository.RoleRepository;
import com.rab3tech.customer.dao.repository.SecurityQuestionsRepository;
import com.rab3tech.dao.entity.AccountStatus;
import com.rab3tech.dao.entity.AccountType;
import com.rab3tech.dao.entity.Customer;
import com.rab3tech.dao.entity.Login;
import com.rab3tech.dao.entity.Role;
import com.rab3tech.dao.entity.SecurityQuestions;

@Component
public class DataPusher implements CommandLineRunner {
	
	@Value("${spring.mail.username:javatech1000@gmail.com}")
	private String empUsername;
	
	@Autowired
	private AccountStatusRepository accountStatusRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AccountTypeRepository accountTypeRepository;
	
	
	@Autowired
	private 	SecurityQuestionsRepository securityQuestionsRepository;

	
	@Autowired
	private MagicCustomerRepository customerRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Optional<AccountStatus> optional1=accountStatusRepository.findById(1);
		if(!optional1.isPresent()) {
			AccountStatus accountStatus1=new AccountStatus(1,"AS01","PENDING","PENDING");
			AccountStatus accountStatus2=new AccountStatus(2,"AS02","PROCESSING","PROCESSING");
			AccountStatus accountStatus3=new AccountStatus(3,"AS03","DORMANT","DORMANT");
			AccountStatus accountStatus4=new AccountStatus(4,"AS04","APPROVED","APPROVED");
			AccountStatus accountStatus5=new AccountStatus(5,"AS05","ACTIVE","ACTIVE");
			AccountStatus accountStatus6=new AccountStatus(6,"AS06","REGISTERED","REGISTERED");
			accountStatusRepository.save(accountStatus1);
			accountStatusRepository.save(accountStatus2);
			accountStatusRepository.save(accountStatus3);
			accountStatusRepository.save(accountStatus4);
			accountStatusRepository.save(accountStatus5);
			accountStatusRepository.save(accountStatus6);
		}
		
		Optional<AccountType> optional2=accountTypeRepository.findById(1);
		if(!optional2.isPresent()) {
			AccountType accountType1=new AccountType(1,"AC001","SAVING","SAVING");
			AccountType accountType2=new AccountType(2,"AC002","CURRENT","SAVING");
			AccountType accountType3=new AccountType(3,"AC003","CORPORATE","SAVING");
			AccountType accountType4=new AccountType(4,"AC004","CHECKING","SAVING");
			
			List<AccountType> accountTypes=new ArrayList<>();
			accountTypes.add(accountType1);
			accountTypes.add(accountType2);
			accountTypes.add(accountType3);
			accountTypes.add(accountType4);
			
			accountTypeRepository.saveAll(accountTypes);
			
		}
		
		Optional<Role> optional3=roleRepository.findById(1);
		if(!optional3.isPresent()) {
			Role role1=new Role(1,"ADMIN","ADMIN");
			Role role2=new Role(2,"EMPLOYEE","EMPLOYEE");
			Role role3=new Role(3,"CUSTOMER","CUSTOMER");
			Role role4=new Role(4,"MANAGER","MANAGER");
			
			List<Role> roles=new ArrayList<>();
			roles.add(role1);
			roles.add(role2);
			roles.add(role3);
			roles.add(role4);
			
			roleRepository.saveAll(roles);
		}
		Optional<Login> optional=loginRepository.findByLoginid(empUsername);
		if(!optional.isPresent()) {
			Customer pcustomer = new Customer();
			pcustomer.setAddress("Fremont");
			pcustomer.setName("James Robert");
			pcustomer.setMobile("320432043");
			pcustomer.setGender("Male");
			pcustomer.setJobTitle("Bank Employee");
			pcustomer.setSsn("23432");
			pcustomer.setFather("Mr. Jack");
			pcustomer.setQualification("NA");
			pcustomer.setDom(new Timestamp(new Date().getTime()));
			pcustomer.setDob("12-03-2020");
			pcustomer.setDoe(new Timestamp(new Date().getTime()));
			pcustomer.setEmail(empUsername);
			Login login = new Login();
			login.setNoOfAttempt(3);
			login.setLoginid(pcustomer.getEmail());
			login.setName(pcustomer.getName());
			login.setPassword(bCryptPasswordEncoder.encode("cool@123$"));
			login.setToken("2230303");
			login.setLocked("no");
			
			Role entity=roleRepository.findById(2).get();
			Set<Role> roles=new HashSet<>();
			roles.add(entity);
			//setting roles inside login
			login.setRoles(roles);
			//setting login inside
			pcustomer.setLogin(login);
			customerRepository.save(pcustomer);
		}
		
		Optional<SecurityQuestions> seOptional=securityQuestionsRepository.findById(1);
		if(!seOptional.isPresent()) {
			SecurityQuestions securityQuestions1=new SecurityQuestions (1,"What is your birth place?","yes","admin100",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));
			SecurityQuestions securityQuestions2=new SecurityQuestions (2,"What is your mother's maiden name?","yes","admin100",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));
			SecurityQuestions securityQuestions3=new SecurityQuestions (3,"What is your favourite author's name?","yes","admin100",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));;
			SecurityQuestions securityQuestions4=new SecurityQuestions (4,"What is your pet name?","yes","admin100",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));;
			SecurityQuestions securityQuestions5=new SecurityQuestions (5,"What is your favourite soccer team?","yes","admin100",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));
			SecurityQuestions securityQuestions6=new SecurityQuestions (6,"What is the name of your childhood hero?","yes","admin100",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));
			SecurityQuestions securityQuestions7=new SecurityQuestions (7,"What is your father's middle name?","yes","admin100",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));
			SecurityQuestions securityQuestions8=new SecurityQuestions (8,"What is the name of your first crush?","yes","admin100",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));
			SecurityQuestions securityQuestions9=new SecurityQuestions (9,"What was the name of your first school?","yes","admin100",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));
			SecurityQuestions securityQuestions10=new SecurityQuestions (10,"What is your favourite vacation spot?","yes","admin100",new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()));
			
			List<SecurityQuestions> securityQuestions=new ArrayList<>();
			securityQuestions.add(securityQuestions1);
			securityQuestions.add(securityQuestions2);
			securityQuestions.add(securityQuestions3);
			securityQuestions.add(securityQuestions4);
			securityQuestions.add(securityQuestions5);
			securityQuestions.add(securityQuestions6);
			securityQuestions.add(securityQuestions7);
			securityQuestions.add(securityQuestions8);
			securityQuestions.add(securityQuestions9);
			securityQuestions.add(securityQuestions10);
			securityQuestionsRepository.saveAll(securityQuestions);
		}
		
	}
}
