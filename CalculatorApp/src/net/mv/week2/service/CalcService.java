package net.mv.week2.service;

import net.mv.week2.domain.Calc;

public class CalcService {
	
	public Calc handleCalculation(Calc calc) {
		if (calc.getOp().equals("add")) {
			calc.setResult(add(calc));
		} else if (calc.getOp().equals("subtract")) {
			calc.setResult(subtract(calc));
		} else if (calc.getOp().equals("divide")) {
			calc.setResult(divide(calc));
		} else
			calc.setResult(multiply(calc));
		
		return calc;
	}
	
	public double add(Calc calc) {
		return  calc.getNum1() + calc.getNum2();
	}
	
	public double subtract(Calc calc) {
		return calc.getNum1() - calc.getNum2();
	}
	
	public double divide(Calc calc) {
		return calc.getNum1() / calc.getNum2();
	}
	
	public double multiply(Calc calc) {
		return calc.getNum1() * calc.getNum2();
	}
}
