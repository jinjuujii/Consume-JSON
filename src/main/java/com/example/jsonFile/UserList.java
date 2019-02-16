package com.example.jsonFile;

import java.util.ArrayList;

import antlr.collections.List;

public class UserList {
	private ArrayList<User> users;

	public UserList() {

		users = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserList [users=" + users + "]";
	}

}
