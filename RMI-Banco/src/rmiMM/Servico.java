package rmiMM;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface Servico extends Remote{

    public boolean ConectaBanco(String nome, int banco) throws RemoteException;
    public boolean TransferirConta(String nome, int banco, double saldo) throws RemoteException;    
    public boolean RegistrarConta(String nome, int banco, double saldo) throws RemoteException;
    public double Saldo(String nome) throws RemoteException;
    public double atualizarSaldo(String nome, double Saldo, Double saldoAtualizado) throws RemoteException;
    public double depositar(String nome, double Saldo, Double saldoAtualizado) throws RemoteException;
    public double transferirDinheiro(String nome, String nome1, double Saldo, double saldoNovo, int bancotransferir) throws RemoteException;
    public double sacar(String nome, double Saldo, double saldoAtualizado) throws RemoteException;
    
}