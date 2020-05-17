package entities;

public class Company extends TaxPayer {

	private Integer numberOfEmployees;
	
	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getnumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setnumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double tax() {
		if (numberOfEmployees > 10) {
			return anualIncome * 0.14;
		} else {
			return anualIncome * 0.16;			
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + String.format(": $ %.2f", tax()));
		return sb.toString();
	}
}
