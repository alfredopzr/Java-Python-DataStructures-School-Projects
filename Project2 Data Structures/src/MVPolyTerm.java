//Each multivariate polynomial is composed of many multivariate polynomial terms. You are to create
//a MVPolyTerm class that only holds the information for a polynomial term. This class should have
//necessary private fields for a polynomial term (1 coefficient and 3 exponents), proper constructors,
//getters, and setters. In addition, the class should also override the method toString(). It returns
//a String, which shows a polynomial term in proper format.
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class MVPolyTerm {
	private String coeff;
	private String xExp;
	private String yExp;
	private String zExp;
	
	public MVPolyTerm(String coeff, String xExp, String yExp, String zExp) {
		this.coeff = coeff;
		this.xExp = xExp;
		this.yExp = yExp;
		this.zExp = zExp;
	}
	
	String getCoeff() {
		return this.coeff;
	}

	void setCoeff(String c) {
		this.coeff = c;
	}

	String getxExp() {
		return this.xExp;
	}
	
	void setxExp(String x) {
		this.xExp = x;
	}
	
	String getyExp() {
		return this.yExp;
	}
	
	void setyExp(String y) {
		this.yExp = y;
	}
	
	String getzExp() {
		return this.zExp;
	}
	
	void setzExp(String z) {
		this.zExp = z;
	}
	
	private String varToStr(char var,int exp) {
		if (exp==0) {
			return "";
		}
		if(exp==1) {
			return "("+String.valueOf(var)+")";
		}
		return "("+String.valueOf(var)+"^"+String.valueOf(exp)+")";
	}
	
	
}
