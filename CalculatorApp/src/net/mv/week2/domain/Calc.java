package net.mv.week2.domain;

public class Calc {
	
	private long resultId;
	private double num1;
	private double num2;
	private double result;
	private String op;
	
	
	
	@Override
	public String toString() {
		return "Calc [resultId=" + resultId + ", num1=" + num1 + ", num2="
				+ num2 + ", result=" + result + ", op=" + op + "]";
	}
	public long getResultId() {
		return resultId;
	}
	public void setResultId(long resultId) {
		this.resultId = resultId;
	}
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}
	
	
}
