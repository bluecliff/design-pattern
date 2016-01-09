interface ISale{
	public double accept(ICar car);
}

interface ICar{
	public double visit(Sale sale);
	public double visit(SaleManager manager);
}

class Benz implements ICar {
	public double visit(Sale sale){
		return 0.03;
	}
	public double visit(SaleManager manager){
		return 0.06;
	}
}

class Bmw implements ICar{
	public double visit(Sale sale){
		return 0.03;
	}
	public double visit(SaleManager manager){
		return 0.04;
	}
}

class Sale implements ISale{
	public double accept(ICar car){
		return car.visit(this);
	}
}

class SaleManager implements ISale{
	public double accept(ICar car){
		return car.visit(this);
	}
}

public class VisitorPatternV2
{
	public static void main(String[] args){
		ICar benz = new Benz();
		ICar bmw = new Bmw();
		ISale sale = new Sale();
		ISale manager = new SaleManager();
		System.out.println("sale's benz discount:"+sale.accept(benz));
		System.out.println("sale manager's benz discount:"+manager.accept(benz));
		System.out.println("sale's bmw discount:"+sale.accept(bmw));
		System.out.println("sale manager's bmw discount:"+manager.accept(bmw));
	}	
}
