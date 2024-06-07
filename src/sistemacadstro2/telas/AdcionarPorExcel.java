/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemacadstro2.telas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
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
        if (stg.equalsIgnoreCase("sim") || stg.equalsIgnoreCase("ok")) {
            return true;
        } else {
            return false;
        }
    }

    public String verificarTextoVazio(String string) {
        if (string == null || string.isEmpty()) {
            return ""; // Retorna uma string vazia se o campo estiver vazio ou nulo
        } else {
            return string.trim(); // Retorna o valor do campo, removendo espaços em branco extras no início e no final
        }
    }

    public double verificarTextoVazioNum(String string) {
        if (string == null || string.isEmpty()) {
            return 0.0; // Retorna 0 se a string estiver vazia ou nula
        } else {
            try {
                return Double.parseDouble(string); // Tenta converter a string em um número
            } catch (NumberFormatException e) {
                System.err.println("Erro ao converter para número: " + e.getMessage());
                return 0.0; // Retorna 0 em caso de erro de conversão
            }
        }
    }

    public LocalDate verificarTextoVazioData(String string) {
        if (string == null || string.isEmpty()) {
            return LocalDate.of(2000, 1, 1); // Retorna uma data padrão se a string estiver vazia ou nula
        } else {
            try {
                return LocalDate.parse(string, fmt); // Tenta converter a string em uma data
            } catch (DateTimeParseException e) {
                System.err.println("Erro ao analisar a data: " + e.getMessage());
                return LocalDate.of(2000, 1, 1); // Retorna uma data padrão em caso de erro de análise
            }
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
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        jButton3.setText("Gerar Template CSV");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Para adicionar alunos por um arquivo, preencha o template gerado pelo botão \"Gerar Template CSV\"");

        jLabel3.setText("Atenção: Todos os campos devem estar preenchidos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(textFile, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
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
                if (primeiralinha.equalsIgnoreCase("Nome,Data de Nascimento,Idade,Nome dp Responsavel,Telefone,Email,Endereço,Bairro,Cep,Escola,Tamanho Roupa,Tamanho Calçado,Categoria,Faixa,Grau,Peso,Medicamento Continuo,Observação,Autorização Treino,Autorização Competição,Autorização de Imagem")) {
                    String alno = br.readLine();
                    while (alno != null) {
                        String[] aluno_novo = alno.split(",");
                        Integer id;
                        if (lista == null || lista.size() == 0) {
                            id = 1;
                        } else {
                            id = lista.getLast().getId() + 1;
                        }
                        Aluno novo = new Aluno(verificarTextoVazio(aluno_novo[0]), id, verificarTextoVazio(aluno_novo[4]), verificarTextoVazioNum(aluno_novo[15]), verificarTextoVazioData(aluno_novo[1]), verificarTextoVazio(aluno_novo[3]), verificarTextoVazio(aluno_novo[5]), verificarTextoVazio(aluno_novo[6]), verificarTextoVazio(aluno_novo[7]), verificarTextoVazio(aluno_novo[8]), verificarTextoVazio(aluno_novo[9]), verificarTextoVazio(aluno_novo[10]), verificarTextoVazio(aluno_novo[11]), verificarTextoVazio(aluno_novo[12]), verificarTextoVazio(aluno_novo[13]), (int) verificarTextoVazioNum(aluno_novo[14]), verificarTextoVazio(aluno_novo[16]), verificarTextoVazio(aluno_novo[17]), verificaAutorizacao(aluno_novo[18]), verificaAutorizacao(aluno_novo[19]), verificaAutorizacao(aluno_novo[20]));
                        lista.add(novo);
                        alno = br.readLine();

                    }
                    service.atualizarLista(lista);
                } else {
                    throw new RuntimeException("Primeira linha errada");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro na leitura \n Verifique o arquivo");
                System.out.println("Erro:" + e.getMessage());
                e.printStackTrace();

            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        File path = new File("Template.csv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write("Nome,Data de Nascimento,Idade,Nome dp Responsavel,Telefone,Email,Endereço,Bairro,Cep,Escola,Tamanho Roupa,Tamanho Calçado,Categoria,Faixa,Grau,Peso,Medicamento Continuo,Observação,Autorização Treino,Autorização Competição,Autorização de Imagem");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textFile;
    // End of variables declaration//GEN-END:variables
}
