
public class Account {

	public Account(int cpf, String name) {
		this.cpf = cpf;
		this.name = name;
		this.money = 0;
		this.contador = contador++;
	}

	public Account(int cpf) {
		this.cpf = cpf;
	}

	int cpf;
	double money;
	String name;
	public static int contador = 0;

	@Override
	public String toString() {
		return "Account [cpf=" + cpf + ", Nome=" + name + ", saldo=" + money + "]";
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public boolean equals(Object obj) {
		Account other = (Account) obj;
		return cpf == other.cpf;
	}

}
