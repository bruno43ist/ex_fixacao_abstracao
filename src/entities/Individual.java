package entities;

public class Individual extends TaxPayer{
	
	private Double healthExpenditures;
	
	public Individual() {
		
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	@Override
	public Double tax() {
		Double tax = 0.0;
		if(anualIncome < 20000.00) {
			tax = 0.15 * getAnualIncome();
			if(healthExpenditures > 0) {
				tax -= (healthExpenditures * 0.5);
			}
		} else {
			tax = 0.25 * getAnualIncome();
			if(healthExpenditures > 0) {
				tax -= (healthExpenditures * 0.5);
			}
		}
		return tax;
	}
}
