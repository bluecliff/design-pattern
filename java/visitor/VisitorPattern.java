interface ISale{
	public double getDiscount(ICar car);
}

interface ICar{
	public double getDiscount(Sale sale);
	public double getDiscount(SaleManager manager);
}

class Benz implements ICar {
	public double getDiscount(Sale sale){
		return 0.03;
	}
	public double getDiscount(SaleManager manager){
		return 0.06;
	}
}

class Bmw implements ICar{
	public double getDiscount(Sale sale){
		return 0.03;
	}
	public double getDiscount(SaleManager manager){
		return 0.04;
	}
}

class Sale implements ISale{
	public double getDiscount(ICar car){
		return car.getDiscount(this);
	}
}

class SaleManager implements ISale{
	public double getDiscount(ICar car){
		return car.getDiscount(this);
	}
}

public class VisitorPattern
{
	public static void main(String[] args){
		ICar benz = new Benz();
		ICar bmw = new Bmw();
		ISale sale = new Sale();
		ISale manager = new SaleManager();
		System.out.println("sale's benz discount:"+sale.getDiscount(benz));
		System.out.println("sale manager's benz discount:"+manager.getDiscount(benz));
		System.out.println("sale's bmw discount:"+sale.getDiscount(bmw));
		System.out.println("sale manager's bmw discount:"+manager.getDiscount(bmw));
	}	
}
