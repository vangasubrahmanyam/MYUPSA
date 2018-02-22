package com.epam.profile.config;

import org.springframework.batch.item.ItemProcessor;

import com.epam.profile.model.Employee;

public class UserItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(final Employee user) throws Exception {
		/*DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("mm-dd-yyyy");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate date = LocalDate.parse(user.getDateOfBirth(),formatter2);
		user.setDateOfBirth(date.format(formatter1));*/
		return user;
	}

}
