package rmiMM;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Servidor extends UnicastRemoteObject implements Servico{

    int bancoAux;
    public Servidor() throws RemoteException {
        super();
        bancoAux =0;
    }
        
    public static void main(String[] args) throws SQLException
    {
        try {
            Servidor servidor = new Servidor();
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.bind("Tanaescuta",  servidor);
            System.out.println("Servidor iniciado...");        
        } catch (AlreadyBoundException | RemoteException ex) {
            System.out.println("Erro: " + ex.getMessage() );
        }
    }
        


    @Override
    public boolean ConectaBanco(String nome, int banco) throws RemoteException
    {
        Banco b = new Banco();
        bancoAux = banco;
        int count = 0;  //Contador para verificar se houve resposta do banco
        if (banco == 1){
        try {
            Connection con = b.Conexao();
            Statement stmt = null;     //Interface para executar SQL.
            String sql = "select * from cliente where nome = " + "'" + nome + "'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //Interface utilizada pra guardar dados vindos de um banco de dados
            while(rs.next())
            {
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        if(banco == 2){
            try {
            Banco2 b2 = new Banco2();
            Connection con = b2.Conexao();
            Statement stmt = null;
            String sql = "select * from cliente2 where nome = " + "'" + nome + "'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        if (count > 0){
            return true;
        }
        else{
            return false;
        }
 
    }

    @Override
    public double Saldo(String nome) throws RemoteException {
        double valor = 0;
        if (bancoAux == 1){
                Banco b = new Banco();
                String texto;
                try {
                    Connection con = b.Conexao();
                    Statement stmt = null;
                    String sql = "SELECT saldo FROM cliente WHERE nome = " + "'" + nome + "'";
                    stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while(rs.next()){  //verifica o conteúdo da resposta
                        texto = rs.getString("saldo");
                        valor = Double.parseDouble(texto);
                        valor = rs.getDouble("saldo");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else {
                Banco2 b2 = new Banco2();
                String texto;
                try {
                    Connection con = b2.Conexao();
                    Statement stmt = null;
                    String sql = "SELECT saldo FROM cliente2 WHERE nome = " + "'" + nome + "'";
                    stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                            while(rs.next()){
                                texto = rs.getString("saldo");
                                valor = Double.parseDouble(texto);
                                valor = rs.getDouble("saldo");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
        }
        return valor;
    }
    
    public boolean RegistrarConta(String nome, int banco, double saldo) throws RemoteException{
        int count = 0;
        if(banco == 1){
        try{    
            Banco b = new Banco();
            Connection con = b.Conexao();
            Statement stmt = null;
            String sql = "Insert into cliente values(" + "'" + nome + "'," + String.valueOf(saldo) + ")";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                count++;
            }
        } catch (SQLException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }    
            JOptionPane.showMessageDialog(null, "Conta registrada no banco 1");
        }
        if (banco == 2){
        try {
            Banco2 b2 = new Banco2();
            Connection con = b2.Conexao();
            Statement stmt = null;
            String sql = "INSERT INTO cliente2 values (" + "'" + nome + "'," + String.valueOf(saldo) + ")";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                count++;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(null, "Conta registrada no banco 2");
        }
        if (count>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean TransferirConta(String nome, int banco, double saldo) throws RemoteException{     
        bancoAux = banco;
        int count = 0;
        if (banco == 1){
        try {
            Banco2 b2 = new Banco2();
            Connection con = b2.Conexao();
            Statement stmt = null;
            String sql = "INSERT INTO cliente2 values (" + "'" + nome + "'," + String.valueOf(saldo) + ")";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);            
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Banco banquinho2 = new Banco();
            Connection con1 = banquinho2.Conexao();
            Statement stmt1 = null;
            String sql1 = "delete from cliente where nome = " + "'" + nome + "'";
            stmt1 = con1.createStatement();
            ResultSet rs1 = stmt1.executeQuery(sql1);
        } catch (SQLException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        if(banco == 2){
            try {
            Banco b = new Banco();
            Connection con = b.Conexao();
            Statement stmt = null;
            
            String sql = "INSERT INTO cliente values (" + "'" + nome + "'," + String.valueOf(saldo) + ")";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                saldo = rs.getDouble("saldo");
            }
            JOptionPane.showMessageDialog(null, "Conta transferida para o banco 1");
            } catch (SQLException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
            Banco2 banquinho = new Banco2();
            Connection con1 = banquinho.Conexao();
            Statement issoAqui = null;
            String sql2 = "DELETE FROM cliente2 WHERE nome = " + "'" + nome + "'";
            issoAqui = con1.createStatement();
            ResultSet rs3 = issoAqui.executeQuery(sql2);
            } catch (SQLException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if (count > 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public double atualizarSaldo(String nome, double Saldo, Double saldoNovo) throws RemoteException {
        double saldo = 0;
        if (bancoAux == 1){
                Banco b = new Banco();
                try {
                    Connection con = b.Conexao();
                    Statement stmt = null;
                    String sql = "SELECT saldo FROM cliente WHERE nome = " + "'" + nome + "'";
                    stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);
                    while(rs.next())
                    { 
                        saldo = rs.getDouble("saldo");
                    }
                    saldo = saldo + saldoNovo;
                    Statement stmt2 = null;
                    String sql2 = "UPDATE cliente SET saldo ='" + String.valueOf(saldo) + "' WHERE nome = " + "'" + nome +"'";
                    stmt2 = con.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(sql2);
                    while (rs2.next())
                    {
                        saldoNovo = rs.getDouble(sql2);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else {
                Banco2 b2 = new Banco2();
            try {
                Connection con = b2.Conexao();
                Statement stmt = null;
                String sql = "SELECT saldo FROM cliente2 WHERE nome = " + "'" + nome + "'";
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next())
                {
                    saldo = rs.getDouble("saldo");
                }
                saldo = saldo + saldoNovo;
                Statement stmt2 = null;
                String sql2 = "UPDATE cliente2 SET saldo ='" + String.valueOf(saldo) + "' WHERE nome = " + "'" + nome + "'";
                stmt2 = con.createStatement();
                ResultSet rs2 = stmt2.executeQuery(sql2);
                while (rs2.next())
                {
                    saldoNovo = rs.getDouble(sql2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        return saldoNovo; 
    }

    @Override
    public double depositar(String nome, double Saldo, Double saldoAtualizado) throws RemoteException {
        double valor = 0, valorAux = 0;
        Banco b = new Banco();
        String texto;
        try {
            Connection con = b.Conexao();
            Statement stmt = null;
            String sql = "UPDATE cliente SET saldo = '" + Double.toString(valorAux) + "' WHERE nome = " + "'" + nome +"'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                texto = rs.getString("saldo");
                valor = Double.parseDouble(texto);
                valor = rs.getDouble("saldo");   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
    
    
    @Override
    public double transferirDinheiro(String nome, String nome1, double Saldo, double saldoNovo, int bancoTransferir) throws RemoteException{
        double saldo = 0;
        double saldoaux = saldoNovo;
        if (bancoAux == 1) {
            Banco b = new Banco();
            try {
                Connection con = b.Conexao();
                Statement stmt = null;
                String sql = "SELECT saldo FROM cliente WHERE nome = '" + nome + "'";
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    saldo = rs.getDouble("saldo");
                }
                
                
                if (saldo> saldoNovo){
                     try{
                         saldo = saldo - saldoNovo;
                    Statement stmt2 = null;
                    String sql2 = "UPDATE cliente SET saldo ='" + String.valueOf(saldo) + "' WHERE nome = '"+ nome +"'";
                    stmt2 = con.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(sql2);
                    while(rs2.next()){
                        saldoNovo = rs.getDouble(sql2);
                    }
                     }catch(SQLException ex){
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    if(bancoTransferir == 1){
                        Banco b1 = new Banco();
                        try{
                            Connection con1 = b1.Conexao();
                            Statement stmt1 = null;
                            String sql1 = "SELECT saldo FROM cliente WHERE nome = '" + nome1 + "'";
                            stmt1 = con1.createStatement();
                            ResultSet rs1 = stmt1.executeQuery(sql1);
                            while(rs1.next()){
                            saldo = rs1.getDouble("saldo");
                            }
                            saldo = saldo + saldoaux;
                            Statement stmt3 = null;
                            String sql3 = "UPDATE cliente SET saldo ='" + String.valueOf(saldo) + "' WHERE nome = '"+ nome1 +"'";
                            stmt3 = con1.createStatement();
                            ResultSet rs3 = stmt3.executeQuery(sql3);
                            while (rs3.next())
                                {
                                 saldoNovo = rs3.getDouble(sql3);
                                }
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                    JOptionPane.showMessageDialog(null, "Deposito com sucesso");
                    }
                    if(bancoTransferir == 2){
                       Banco2 b4 = new Banco2();
                        try {
                            Connection con4 = b4.Conexao();
                            Statement stmt4 = null;
                            String sql4 = "SELECT saldo FROM cliente2 WHERE nome = '" + nome1 + "'";
                            stmt4 = con4.createStatement();
                            ResultSet rs4 = stmt4.executeQuery(sql4);
                                while(rs4.next())
                                {
                                    saldo = rs4.getDouble("saldo");
                                }
                            saldo = saldo + saldoaux;
                            Statement stmt5 = null;
                            String sql5 = "UPDATE cliente2 SET saldo ='" + String.valueOf(saldo) + "' WHERE nome = '"+ nome1 +"'";
                            stmt5 = con4.createStatement();
                            ResultSet rs5 = stmt5.executeQuery(sql5);
                            while (rs5.next())
                            {
                                saldoNovo = rs5.getDouble(sql5);
                            }
                            } catch (SQLException ex) {
                                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showMessageDialog(null, "Deposito com sucesso");
                    }
                    
                    
                    
                    
                }
                else {
                    JOptionPane.showMessageDialog(null, "Valor a ser transferido maior que o saldo !!");
                }
           
            } catch (SQLException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            Banco2 b2 = new Banco2();
        try {
            Connection con = b2.Conexao();
            Statement stmt = null;
            String sql = "SELECT saldo FROM cliente2 WHERE nome = '" + nome + "'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                saldo = rs.getDouble("saldo");
            }
            if (saldo> saldoNovo){
                try{
                 saldo = saldo - saldoNovo;
                Statement stmt2 = null;
                String sql2 = "UPDATE cliente2 SET saldo ='" + String.valueOf(saldo) + "' WHERE nome = '"+ nome +"'";
                stmt2 = con.createStatement();
                ResultSet rs2 = stmt2.executeQuery(sql2);
                while (rs2.next())
                {
                saldoNovo = rs.getDouble(sql2);
                }
                }catch(SQLException ex){
                      Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(bancoTransferir == 1){
                        Banco b1 = new Banco();
                        try{
                            Connection con1 = b1.Conexao();
                            Statement stmt1 = null;
                            String sql1 = "SELECT saldo FROM cliente WHERE nome = '" + nome1 + "'";
                            stmt1 = con1.createStatement();
                            ResultSet rs1 = stmt1.executeQuery(sql1);
                            while(rs1.next()){
                            saldo = rs1.getDouble("saldo");
                            }
                                saldo = saldo + saldoaux;
                            Statement stmt3 = null;
                            String sql3 = "UPDATE cliente SET saldo ='" + String.valueOf(saldo) + "' WHERE nome = '"+ nome1 +"'";
                            stmt3 = con1.createStatement();
                            ResultSet rs3 = stmt3.executeQuery(sql3);
                            while (rs3.next())
                                {
                                 saldoNovo = rs3.getDouble(sql3);
                                }
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(null, "Deposito com sucesso");
                    }
                    if(bancoTransferir == 2){
                       Banco2 b4 = new Banco2();
                        try {
                            Connection con4 = b4.Conexao();
                            Statement stmt4 = null;
                            String sql4 = "SELECT saldo FROM cliente2 WHERE nome = '" + nome1 + "'";
                            stmt4 = con4.createStatement();
                            ResultSet rs4 = stmt4.executeQuery(sql4);
                                while(rs4.next())
                                {
                                    saldo = rs4.getDouble("saldo");
                                }
                            saldo = saldo + saldoaux;
                            Statement stmt5 = null;
                            String sql5 = "UPDATE cliente2 SET saldo ='" + String.valueOf(saldo) + "' WHERE nome = '"+ nome1 +"'";
                            stmt5 = con4.createStatement();
                            ResultSet rs5 = stmt5.executeQuery(sql5);
                            while (rs5.next())
                            {
                                saldoNovo = rs5.getDouble(sql5);
                            }
                            } catch (SQLException ex) {
                                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        JOptionPane.showMessageDialog(null, "Deposito com sucesso");
                    }
                    
                    
                    
            }
            else {
                JOptionPane.showMessageDialog(null, "Valor a ser sacado maior que o saldo !!");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        return saldoNovo;
    }
    
    @Override
    public double sacar(String nome, double Saldo, double saldoNovo) throws RemoteException {
        double saldo = 0;
        if (bancoAux == 1) {
            Banco b = new Banco();
            try {
                Connection con = b.Conexao();
                Statement stmt = null;
                String sql = "SELECT saldo FROM cliente WHERE nome = '" + nome + "'";
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    saldo = rs.getDouble("saldo");
                }
                if (saldo> saldoNovo){
                     saldo = saldo - saldoNovo;
                    Statement stmt2 = null;
                    String sql2 = "UPDATE cliente SET saldo ='" + String.valueOf(saldo) + "' WHERE nome = '"+ nome +"'";
                    stmt2 = con.createStatement();
                    ResultSet rs2 = stmt2.executeQuery(sql2);
                    while (rs2.next())
                    {
                    saldoNovo = rs.getDouble(sql2);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Valor a ser sacado maior que o saldo !!");
                }
           
            } catch (SQLException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            Banco2 b2 = new Banco2();
        try {
            Connection con = b2.Conexao();
            Statement stmt = null;
            String sql = "SELECT saldo FROM cliente2 WHERE nome = '" + nome + "'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                saldo = rs.getDouble("saldo");
            }
            if (saldo> saldoNovo){
                 saldo = saldo - saldoNovo;
                Statement stmt2 = null;
                String sql2 = "UPDATE cliente2 SET saldo ='" + String.valueOf(saldo) + "' WHERE nome = '"+ nome +"'";
                stmt2 = con.createStatement();
                ResultSet rs2 = stmt2.executeQuery(sql2);
                while (rs2.next())
                {
                saldoNovo = rs.getDouble(sql2);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Valor a ser sacado maior que o saldo !!");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        return saldoNovo;
    }

    }


