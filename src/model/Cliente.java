package model;

import java.util.Objects;

public class Cliente 
{
	private int numConta;
	private String nomeCliente;
	private float saldo;
	
	public Cliente(int numConta, String nomeCliente, float saldo) {
		super();
		this.numConta = numConta;
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
	}
	
	public int getNumConta() {
		return numConta;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public float getSaldo() {
		return saldo;
	}
	@Override
	public String toString() {
		return "Cliente " + nomeCliente + "#" + numConta + "\nSaldo: " + saldo;
	}
	@Override
	public int hashCode() 
	{	
		int posit = (int) (10 * ((((Math.sqrt(7) - 1) * numConta)) % 1));
		return posit;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nomeCliente, other.nomeCliente) && numConta == other.numConta
				&& Float.floatToIntBits(saldo) == Float.floatToIntBits(other.saldo);
	}
	
	
	
	
	
}
