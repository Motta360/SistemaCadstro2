/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemacadstro2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import sistemacadstro2.services.Servico;
import sistemacadstro2.entities.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import sistemacadstro2.telas.AdcionarPorExcel;
import sistemacadstro2.telas.Chamada;
import sistemacadstro2.telas.DetalhesAluno;
import sistemacadstro2.telas.DiaEspecífico;
import sistemacadstro2.telas.TelaCadastro;

/**
 *
 * @author lucas
 */
public class TelaPrincipal extends javax.swing.JFrame {

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Servico service = new Servico();
    ArrayList<Aluno> lista = service.read();
    boolean ordemAlfabetica = false;

    public String verificarPermissao(boolean x) {
        if (x) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public class MyTask extends TimerTask {

        @Override
        public void run() {
            if (ordemAlfabetica) {
                List<Aluno> ordenada = lista.stream().sorted().collect(Collectors.toList());
                String msg = "";
                for (int i = 0; i < ordenada.size(); i++) {
                    msg += ordenada.get(i).toString() + "\n";
                }
                areaDeTexto.setText(msg);
            } else {
                lista = service.read();
                String msg = "";
                for (int i = 0; i < lista.size(); i++) {
                    msg += lista.get(i).toString() + "\n";
                }
                areaDeTexto.setText(msg);
            }
        }

    }

    /**
     * Creates new form Tela
     */
    public TelaPrincipal() {
        initComponents();
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 0, 100);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaDeTexto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        textId = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        idDelete = new javax.swing.JTextField();
        ordem = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema");

        areaDeTexto.setEditable(false);
        areaDeTexto.setColumns(20);
        areaDeTexto.setRows(5);
        jScrollPane1.setViewportView(areaDeTexto);

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Detalhes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ordem.setText("Ordem Alfabetica");
        ordem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordemActionPerformed(evt);
            }
        });

        jButton4.setText("Chamada");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Registro Chamada");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Trasformar Em Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Adcionar por Excel");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(idDelete, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(jButton6)
                                .addGap(44, 44, 44)
                                .addComponent(ordem))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(jButton4)
                                    .addComponent(jButton5)
                                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(27, 27, 27))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(ordem)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(94, 94, 94)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaCadastro tc = new TelaCadastro(service);
        tc.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        lista = service.read();
        Aluno a2 = null;
        for (Aluno aluno : lista) {
            if (aluno.getId() == Integer.parseInt(textId.getText())) {
                a2 = aluno;
            }
        }
        if (a2 != null) {
            DetalhesAluno da1 = new DetalhesAluno(a2, service);
            da1.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Código do aluno incorreto");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Certeza que gostaria de deletar esse cadastro?", "Deletar", JOptionPane.OK_CANCEL_OPTION);
        if (x <= 0) {
            lista = service.read();
            Aluno a3 = null;
            for (Aluno aluno : lista) {
                if (aluno.getId() == Integer.parseInt(idDelete.getText())) {
                    a3 = aluno;
                }
            }
            lista.remove(a3);
            idDelete.setText("");
            service.atualizarLista(lista);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ordemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordemActionPerformed
        if (!ordemAlfabetica) {
            ordemAlfabetica = true;
            ordem.setText("Ordem de Registro");
        } else {
            ordemAlfabetica = false;
            ordem.setText("Ordem Alfabetica");
        }
    }//GEN-LAST:event_ordemActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Chamada ch = new Chamada(lista, service);
        ch.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DiaEspecífico de = new DiaEspecífico(lista, service);
        de.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        File path = new File("Formatado.csv");
        lista = service.read();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Nome;Data de Nascimento;Idade;Nome dp Responsavel;Telefone;Email;Endereço;Bairro;Cep;Escola;Tamanho Roupa;Tamanho Calçado;Categoria;Faixa;Grau;Peso;Medicamento Continuo;Observação;Autorização Treino;Autorização Competição;Autorização de Imagem");
            bw.newLine();
            for (Aluno aluno : lista) {
                bw.write(aluno.getName() + ";" + aluno.getAniversario().format(fmt) + ";" + aluno.getIdade() + ";" + aluno.getNome_responsavel() + ";" + aluno.getNum_contato() + ";" + aluno.getEmail() + ";" + aluno.getEndereco() + ";" + aluno.getBairro() + ";" + aluno.getCep() + ";" + aluno.getEscola() + ";" + aluno.getTamanho_roupa() + ";" + aluno.getTamanho_calcado() + ";" + aluno.getCategoria() + ";" + aluno.getFaixa() + ";" + aluno.getGrau() + ";" + aluno.getPeso() + ";" + aluno.getMedicamento_cotinuo()+";"+aluno.getObservacao()+";"+verificarPermissao(aluno.getAutorizacao_treino())+";"+verificarPermissao(aluno.getAutorizacao_competicao())+";"+verificarPermissao(aluno.getAutorizacao_imagem()));
                bw.newLine();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        AdcionarPorExcel ape = new AdcionarPorExcel(service);
        ape.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDeTexto;
    private javax.swing.JTextField idDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ordem;
    private javax.swing.JTextField textId;
    // End of variables declaration//GEN-END:variables
}
