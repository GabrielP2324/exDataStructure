import javax.swing.JOptionPane;

public class Menu {
	List<Account> accounts = new List<Account>();
	int choice;
	int count = 0;
	public void menu() {

		do {
			choice = Integer.parseInt(JOptionPane.showInputDialog(
					"1. Abrir conta \n 2. Realizar saque \n 3. Realizar dep�sito \n 4. Relat�rio de contas \n 5. Encerrar conta \n 6. Encerrar aplica��o"));

			switch (choice) {
			case 1:
				Register();
				break;
			case 2:
				Withdraw();
				break;
			case 3:
				Deposit();
				break;
			case 4:
				ShowAll();
				break;
			case 5:
				Remove();
				break;
			}
		} while (choice != 6);

	}

	public void Deposit() {
		Account Contacpf = new Account(Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF: ")));
		if (accounts.search(Contacpf) != null) {
			double depositar = Double.parseDouble(JOptionPane.showInputDialog("Quanto gostaria de depositar?"));
			if (depositar > 0) {
				accounts.search(Contacpf).info.money += depositar;
				JOptionPane.showMessageDialog(null, "Valor depositado");
			} else {
				JOptionPane.showMessageDialog(null, "N�o � poss�vel depositar esse valor");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Uma conta com este cpf n�o existe");
		}

	}

	public void Withdraw() {
		Account Contacpf = new Account(Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF: ")));
		if (accounts.search(Contacpf) != null) {
			double retirar = Double.parseDouble(JOptionPane.showInputDialog(
					"Quanto gostaria de retirar? \n Saldo dispon�vel: " + accounts.search(Contacpf).info.money));
			if (retirar <= 0) {
				JOptionPane.showMessageDialog(null, "Valor inv�lido");
			} else if (retirar < accounts.search(Contacpf).info.money) {
				accounts.search(Contacpf).info.money -= retirar;
				JOptionPane.showMessageDialog(null, "Valor retirado com sucesso");
			} else {
				JOptionPane.showMessageDialog(null, "N�o � poss�vel retirar esse valor");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Uma conta com este cpf n�o existe");
		}
	}

	public void Remove() {
		Account Contacpf = new Account(Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF para apagar: ")));
		if (accounts.search(Contacpf) != null) {
			accounts.deleteFromStart2(Contacpf);
			JOptionPane.showMessageDialog(null, "Conta apagada com sucesso");
			count--;
		} else {
			JOptionPane.showMessageDialog(null, "Uma conta com este cpf n�o existe");
		}
	}

	public void ShowAll() {
		String aux = "";
		int cont = 0;
		
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if (accounts.search(new Account(i)) != null) {
				aux += accounts.search(new Account(i)).info.toString() + "\n";
				cont++;
			}
			if(cont == count) {
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Existem as seguintes contas: \n" + aux);
	}

	public void Register() {
		Account Contacpf = new Account(Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF: ")));

		if (accounts.search(Contacpf) != null) {
			JOptionPane.showMessageDialog(null, "Uma conta com este cpf j� existe");
		} else if (Contacpf.cpf <= 0) {
			JOptionPane.showMessageDialog(null, "CPF inv�lido");
		} else {
			accounts.insertEnd(new Account(Contacpf.cpf, JOptionPane.showInputDialog("Digite o nome do correntista:")));
			count++;
		}
	}
}
