package com.EazyPay.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.EazyPay.demo.Exception.UserNotFoundException;
import com.EazyPay.demo.controller.WalletController;
import com.EazyPay.demo.entity.Wallet;
import com.EazyPay.demo.repo.WalletRepositoty;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class testJPA {
	
	@Autowired
	private  WalletRepositoty Wrepo;
	
	@Test
	public void create() throws UserNotFoundException {
		Wallet w1 = new Wallet();
		w1.setAdhar_Number("123456789124");
		w1.setEmail_id("test@gmail.com");
		w1.setMobile_Number("9237894560");
		w1.setName("testUser");
		w1.setTransaction(null);
		w1.setWallet_Ammount(0);
		w1.setWallet_Pin("0584");
		Wrepo.save(w1);
		Optional<Wallet> wl = Wrepo.findById("9237894560");
		Wallet w = wl.get();
		assertEquals(w1.getAdhar_Number(), w.getAdhar_Number());
		assertEquals(w1.getMobile_Number(), w.getMobile_Number());
		
		}
		
	@Test
	public void update() throws UserNotFoundException {
		Wallet w1 = new Wallet();
		w1.setAdhar_Number("123456789124");
		w1.setEmail_id("test@gmail.com");
		w1.setMobile_Number("9237894560");
		w1.setName("testUser");
		w1.setTransaction(null);
		w1.setWallet_Ammount(0);
		w1.setWallet_Pin("0584");
		Wrepo.save(w1);
		Optional<Wallet> wl = Wrepo.findById("9237894560");
		Wallet w = wl.get();
		w.setWallet_Pin("1234");
		w.setMobile_Number("9545808008");
		Wrepo.save(w);;
		assertEquals(w1.getWallet_Pin(), w.getWallet_Pin());
		assertEquals(w1.getMobile_Number(), w.getMobile_Number());
		
	}
	
	@Test
	public void getAll() throws UserNotFoundException {
		Wallet w1 = new Wallet();
		w1.setAdhar_Number("123456789124");
		w1.setEmail_id("test@gmail.com");
		w1.setMobile_Number("9237894560");
		w1.setName("testUser");
		w1.setTransaction(null);
		w1.setWallet_Ammount(0);
		w1.setWallet_Pin("0584");
		Wrepo.save(w1);
		
		assertNotNull(Wrepo.findAll());
		
	}

}
