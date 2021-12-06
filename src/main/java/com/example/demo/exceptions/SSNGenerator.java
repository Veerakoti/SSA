package com.example.demo.exceptions;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SSNGenerator implements IdentifierGenerator {
	private static final Random random = new Random();
	
	

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		Integer ssnRaw=null;
		String ssn=null;
		
		int first=random.nextInt(1000);
		int middle=random.nextInt(1000);
		int last=random.nextInt(1000);
		try {
			Connection connection = session.connection();
			Statement createStatement = connection.createStatement();
			String sql="select order_id_seq.nextval from dual";
			ResultSet executeQuery = createStatement.executeQuery(sql);
			if (executeQuery.next()) {
				int seqvak = executeQuery.getInt(1);
				if(seqvak<10) {
					ssn=String.valueOf(seqvak);
					ssn="00"+ssn;
				}
				else if(seqvak<100) {
					ssn=String.valueOf(seqvak);
					ssn="0"+ssn;
				}
				//ssn=String.valueOf(seqvak);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return first+" "+middle+" "+ssn;
	}

}
