/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemacadstro2.telas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sistemacadstro2.entities.Aluno;
import sistemacadstro2.services.Servico;

/**
 *
 * @author lucas
 */
public class AdcionarPorExcel extends javax.swing.JFrame {

    File file = null;
    Servico service;
    ArrayList<Aluno> lista;
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Creates new form AdcionarPorExcel
     */
    public AdcionarPorExcel(Servico service) {
        initComponents();
        this.service = service;
    }

    public AdcionarPorExcel() {
        initComponents();
    }

    public boolean verificaAutorizacao(String stg) {
        if (stg.equalsIgnoreCase("sim")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFile = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Buscar Arquivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Adicionar Alunos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Adcione um arquivo no formato .csv com o padrão aceito:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textFile, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "csv");

        jf.setFileFilter(filter);
        int retorno = jf.showOpenDialog(this);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            file = jf.getSelectedFile();
            textFile.setText(file.getPath());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (file == null) {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo Selecionado");
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                lista = service.read();
                String primeiralinha = br.readLine();
                if (primeiralinha.equalsIgnoreCase("Nome;Data de Nascimento;Idade;Nome dp Responsavel;Telefone;Email;Endereço;Bairro;Cep;Escola;Tamanho Roupa;Tamanho Calçado;Categoria;Faixa;Grau;Peso;Medicamento Continuo;Observação;Autorização Treino;Autorização Competição;Autorização de Imagem")) {
                    String[] aluno_novo = br.readLine().split(";");
                    while (aluno_novo != null) {
                        Aluno novo = new Aluno(aluno_novo[0], lista.getLast().getId() + 1, aluno_novo[4], Double.parseDouble(aluno_novo[15]), LocalDate.parse(aluno_novo[1], fmt), aluno_novo[3], aluno_novo[5], aluno_novo[6], aluno_novo[7], aluno_novo[8], aluno_novo[9], aluno_novo[10], aluno_novo[11], aluno_novo[12], aluno_novo[13], Integer.parseInt(aluno_novo[14]), aluno_novo[16], aluno_novo[17], verificaAutorizacao(aluno_novo[18]), verificaAutorizacao(aluno_novo[19]), verificaAutorizacao(aluno_novo[20]));
                        lista.add(novo);
                        aluno_novo = br.readLine().split(";");
                    }
                    service.atualizarLista(lista);
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na leitura \n Verifique o arquivo");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AdcionarPorExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdcionarPorExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdcionarPorExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdcionarPorExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdcionarPorExcel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField textFile;
    // End of variables declaration//GEN-END:variables
}
