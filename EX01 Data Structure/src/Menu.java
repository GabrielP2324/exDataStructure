import javax.swing.JOptionPane;

public class Menu {
	List<Account> accounts = new List<Account>();
	int choice;
	int count = 0;
	public void menu() {

		do {
			choice = Integer.parseInt(JOptionPane.showInputDialog(
					"1. Abrir conta \n 2. Realizar saque \n 3. Realizar depósito \n 4. Relatório de contas \n 5. Encerrar conta \n 6. Encerrar aplicação"));

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
				JOptionPane.showMessageDialog(null, "Não é possível depositar esse valor");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Uma conta com este cpf não existe");
		}

	}

	public void Withdraw() {
		Account Contacpf = new Account(Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF: ")));
		if (accounts.search(Contacpf) != null) {
			double retirar = Double.parseDouble(JOptionPane.showInputDialog(
					"Quanto gostaria de retirar? \n Saldo disponível: " + accounts.search(Contacpf).info.money));
			if (retirar <= 0) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
			} else if (retirar < accounts.search(Contacpf).info.money) {
				accounts.search(Contacpf).info.money -= retirar;
				JOptionPane.showMessageDialog(null, "Valor retirado com sucesso");
			} else {
				JOptionPane.showMessageDialog(null, "Não é possível retirar esse valor");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Uma conta com este cpf não existe");
		}
	}

	public void Remove() {
		Account Contacpf = new Account(Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF para apagar: ")));
		if (accounts.search(Contacpf) != null) {
			accounts.deleteFromStart2(Contacpf);
			JOptionPane.showMessageDialog(null, "Conta apagada com sucesso");
			count--;
		} else {
			JOptionPane.showMessageDialog(null, "Uma conta com este cpf não existe");
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
			JOptionPane.showMessageDialog(null, "Uma conta com este cpf já existe");
		} else if (Contacpf.cpf <= 0) {
			JOptionPane.showMessageDialog(null, "CPF inválido");
		} else {
			accounts.insertEnd(new Account(Contacpf.cpf, JOptionPane.showInputDialog("Digite o nome do correntista:")));
			count++;
		}
	}
}
