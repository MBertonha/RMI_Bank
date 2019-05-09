package rmiMM;

import java.awt.Frame;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Cliente extends javax.swing.JDialog {

    Servico servico = null;

    public Cliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.2.106", 12345);
            servico = (Servico) registry.lookup("Tanaescuta");

        } catch (NotBoundException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro " + ex.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeConta = new javax.swing.JTextField();
        valorDeposito = new javax.swing.JTextField();
        valorSaque = new javax.swing.JTextField();
        botaoSaldo = new javax.swing.JButton();
        botaoDeposito = new javax.swing.JButton();
        botaoSaque = new javax.swing.JButton();
        botaoLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        valorBanco = new javax.swing.JTextField();
        transferirconta = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        transferirdinheiro = new javax.swing.JButton();
        nomeconta1 = new javax.swing.JTextField();
        valorbanco1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        setTitle("Cliente 1");

        jLabel1.setText("Insira sua conta");

        jLabel2.setText("Valor deposito");

        jLabel3.setText("Valor Saque");

        nomeConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeContaActionPerformed(evt);
            }
        });

        valorDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorDepositoActionPerformed(evt);
            }
        });

        botaoSaldo.setText("Saldo");
        botaoSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSaldoActionPerformed(evt);
            }
        });

        botaoDeposito.setText("Deposito");
        botaoDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDepositoActionPerformed(evt);
            }
        });

        botaoSaque.setText("Saque");
        botaoSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSaqueActionPerformed(evt);
            }
        });

        botaoLogin.setText("Logar");
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });

        jLabel4.setText("Insira o Banco");

        valorBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorBancoActionPerformed(evt);
            }
        });

        transferirconta.setText("Transferir Conta p/ outro banco");
        transferirconta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferircontaActionPerformed(evt);
            }
        });

        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        transferirdinheiro.setText("Transferir Dinheiro");
        transferirdinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferirdinheiroActionPerformed(evt);
            }
        });

        nomeconta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeconta1ActionPerformed(evt);
            }
        });

        valorbanco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorbanco1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome p/ depósito");

        jLabel9.setText("Nº do banco p/ depósito");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(transferirconta, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botaoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nomeConta, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(valorDeposito, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addGap(55, 55, 55))))
                                        .addComponent(nomeconta1))
                                    .addComponent(botaoDeposito))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorSaque, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(valorBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(valorbanco1)
                            .addComponent(botaoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transferirdinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registrar))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSaldo)
                    .addComponent(botaoLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSaque)
                    .addComponent(botaoDeposito))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeconta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorbanco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(transferirdinheiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(transferirconta)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSaldoActionPerformed
        double teste = 0;
        try {
            teste = servico.Saldo(this.nomeConta.getText());
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Saldo: R$ " + Double.toString(teste));
    }//GEN-LAST:event_botaoSaldoActionPerformed

    private void botaoDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDepositoActionPerformed
        double valorDeposito = Double.parseDouble(this.valorDeposito.getText());
        double deposito = 0;
        try {
            deposito = servico.atualizarSaldo(this.nomeConta.getText(), servico.Saldo(this.nomeConta.getText()), valorDeposito);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (deposito >= 0) {
            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
        }
    }//GEN-LAST:event_botaoDepositoActionPerformed

    private void botaoSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSaqueActionPerformed
      double valorSaque = Double.parseDouble(this.valorSaque.getText());
        double saque = 0;
            try {
                saque = servico.sacar(this.nomeConta.getText(), servico.Saldo(this.nomeConta.getText()), valorSaque);
                JOptionPane.showConfirmDialog(null, "Operação finalizada");
            } catch (RemoteException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_botaoSaqueActionPerformed

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        boolean teste = false;
        try {
            teste = servico.ConectaBanco(this.nomeConta.getText(), Integer.parseInt(this.valorBanco.getText()));
            if (teste){
                JOptionPane.showMessageDialog(null, "Logado com Sucesso");
            }
            else {
                JOptionPane.showMessageDialog(null, "Erro no Login");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoLoginActionPerformed

    private void transferircontaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferircontaActionPerformed
        int qualBanco = 0;
        double saldoTransf = 0;
        try{
            qualBanco = Integer.parseInt(this.valorBanco.getText());
            String nomeTransf = this.nomeConta.getText();
            saldoTransf = servico.Saldo(this.nomeConta.getText());
            servico.TransferirConta(nomeTransf, qualBanco, saldoTransf);
        } catch (RemoteException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_transferircontaActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        int qualBanco = 0;
        double saldo = Double.parseDouble(this.valorDeposito.getText());
        try{
            qualBanco = Integer.parseInt(this.valorBanco.getText());
            String nome = this.nomeConta.getText();
            servico.RegistrarConta(nome, qualBanco, saldo);
        }catch (RemoteException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);    
        }

    }//GEN-LAST:event_registrarActionPerformed

    private void transferirdinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferirdinheiroActionPerformed
        double transferir = 0;
        int banco2 = Integer.parseInt(this.valorbanco1.getText());
        double deposito = Double.parseDouble(this.valorDeposito.getText());
        try{
            String nome = this.nomeConta.getText();
            String nome1 = this.nomeconta1.getText();
        transferir = servico.transferirDinheiro(nome, nome1, servico.Saldo(this.nomeConta.getText()), deposito, banco2);
        } catch(RemoteException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);    
        }
    }//GEN-LAST:event_transferirdinheiroActionPerformed

    private void valorDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorDepositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorDepositoActionPerformed

    private void nomeconta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeconta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeconta1ActionPerformed

    private void nomeContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeContaActionPerformed

    private void valorBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorBancoActionPerformed

    private void valorbanco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorbanco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorbanco1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {/*
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cliente dialog = new Cliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoDeposito;
    private javax.swing.JButton botaoLogin;
    private javax.swing.JButton botaoSaldo;
    private javax.swing.JButton botaoSaque;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nomeConta;
    private javax.swing.JTextField nomeconta1;
    private javax.swing.JButton registrar;
    private javax.swing.JButton transferirconta;
    private javax.swing.JButton transferirdinheiro;
    private javax.swing.JTextField valorBanco;
    private javax.swing.JTextField valorDeposito;
    private javax.swing.JTextField valorSaque;
    private javax.swing.JTextField valorbanco1;
    // End of variables declaration//GEN-END:variables
}
