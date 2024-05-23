
package GUI;

import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import static sql.DAOS.DAO_Cuidado.pesquisaAgendamentoCuidador;
import users.UsrPaciente;


public class InterfacePrincipalCuidador extends javax.swing.JFrame {


    public InterfacePrincipalCuidador(String id, String nome, String tipoContrato, String turno, String especialidades) throws Exception {
        initComponents(); //inicia componentes da interface gráfica
        setarDados(id, nome, tipoContrato, turno, especialidades); //seta os dados
        lerTabelaAgendamentos(id); //lê a tabela de agendamentos
    }
    public void lerTabelaAgendamentos(String id) throws Exception{
        DefaultTableModel Agendamentos = (DefaultTableModel) tabelacuidado.getModel(); //inicia tabela
        Agendamentos.setNumRows(0);
        HashMap<String, UsrPaciente> map = pesquisaAgendamentoCuidador(id); //atribui o resultado de "pesquisaAgendamentoCuidador" a uma lista
        if(map!=null){
            Collection<UsrPaciente> pacientes = map.values(); //atribui todos os valores de map à pista pacientes 
            for(UsrPaciente paciente: pacientes){ //loop enquanto houver itens(paciente) dentro da lista(pacientes)
                //adiciona objetos "paciente" a cada linha da tabela
                Agendamentos.addRow(new Object[]{
                    paciente.getId(),
                    paciente.getNome(),
                    paciente.getIdade(),
                    paciente.getDdd()+" "+paciente.getNumero(),
                    paciente.getDescricaoNecessidades(),
                    paciente.getCidade(),
                    paciente.getBairro()

                });
            }
        }
        
    }

 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idcampo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nomecampo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        contratocampo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        turnocampo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        especialidadecampo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelacuidado = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id:");

        idcampo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        idcampo.setEnabled(false);

        jLabel2.setText("Nome: ");

        nomecampo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nomecampo.setEnabled(false);
        nomecampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomecampoActionPerformed(evt);
            }
        });

        jLabel3.setText("Contrato: ");

        contratocampo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contratocampo.setEnabled(false);

        jLabel4.setText("Turno: ");

        turnocampo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        turnocampo.setEnabled(false);

        jLabel5.setText("Especialidades: ");

        especialidadecampo.setColumns(20);
        especialidadecampo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        especialidadecampo.setRows(5);
        especialidadecampo.setEnabled(false);
        jScrollPane1.setViewportView(especialidadecampo);

        tabelacuidado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Idade", "Contato", "Necessidades", "Cidade", "Bairro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelacuidado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tabelacuidado);

        jLabel6.setText("Solicitacoes de Cuidado: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 558, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(turnocampo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(contratocampo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nomecampo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idcampo, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idcampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomecampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contratocampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turnocampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomecampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomecampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomecampoActionPerformed

    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipalCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipalCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipalCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipalCuidador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String id=null;
                String nome = null;
                String turno = null;
                String contrato = null;
                String especialidade = null;
                try {
                    new InterfacePrincipalCuidador(id, nome, contrato, turno, especialidade).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(InterfacePrincipalCuidador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void setarDados(String id, String nome, String tipoContrato, String turno, String especialidades){
        //insere os dados passados como parâmetro dentro dos campos de texto
        idcampo.setText(id);
        nomecampo.setText(nome);
        contratocampo.setText(tipoContrato);
        turnocampo.setText(turno);
        especialidadecampo.setText(especialidades);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contratocampo;
    private javax.swing.JTextArea especialidadecampo;
    private javax.swing.JTextField idcampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomecampo;
    private javax.swing.JTable tabelacuidado;
    private javax.swing.JTextField turnocampo;
    // End of variables declaration//GEN-END:variables
}
