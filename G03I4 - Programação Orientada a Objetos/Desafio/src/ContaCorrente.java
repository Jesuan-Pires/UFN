
public class ContaCorrente extends Conta {

	public ContaCorrente(double saldo, double limite) {
		super(saldo, limite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void depositar(double valor) throws SaldoInsuficienteException{
		if(valor <= 0)
			throw new SaldoInsuficienteException("Impossivel depositar zero ou valor negativo!");
		saldo+=valor;
	}

	@Override
	public void sacar(double valor)throws SaldoInsuficienteException {
		if(valor > saldo+limite)
			throw new SaldoInsuficienteException("Saldo insuficiente");
		else if(valor <=0)
			throw new SaldoInsuficienteException("Impossivel sacar zero ou valor negativo");
		saldo-=valor;
	}

}
