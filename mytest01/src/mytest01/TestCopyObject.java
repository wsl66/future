package mytest01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class TestCopyObject {

	@Test
	public void test1() {
		User user1 = new User();
		user1.setName("张三");
		user1.setAge(18);
		System.out.println(user1);
		System.out.println("user1:name=" + user1.getName() + ",age=" + user1.getAge());
		User copyUser = TestCopyObject.copyUser(user1);
		System.out.println(copyUser);
		System.out.println("copyUser:name=" + copyUser.getName() + ",age=" + copyUser.getAge());
	}

	// 用beaUtils的封装方法
	@Test
	public void test2() {
		User user1 = new User();
		user1.setName("张三");
		user1.setAge(18);
		System.out.println(user1);
		System.out.println("user1:name=" + user1.getName() + ",age=" + user1.getAge());
		User copyUser = new User();
		try {
			BeanUtils.copyProperties(copyUser, user1);
			System.out.println(copyUser);
			System.out.println("copyUser:name=" + copyUser.getName() + ",age=" + copyUser.getAge());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static User copyUser(User realUser) {
		User copyUser = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(realUser);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			System.out.println(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			copyUser = (User) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return copyUser;
	}

}

class User implements Serializable {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	private int age;
}