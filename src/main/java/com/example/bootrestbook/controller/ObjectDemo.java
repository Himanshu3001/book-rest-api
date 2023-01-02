package com.example.bootrestbook.controller;

class Cal {
	int m;
	int n;
	int res;

	public void perform() {
		res = m + n;
	}
}
public class ObjectDemo{

		public static void main(String[] args) {
			Cal obj = new Cal();
			obj.m = 5;
			obj.n = 10;
			obj.perform();
			System.out.println(obj.res);

		}
}
