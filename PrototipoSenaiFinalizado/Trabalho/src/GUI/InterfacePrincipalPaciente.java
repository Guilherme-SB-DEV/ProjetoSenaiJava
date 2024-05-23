
package GUI;

import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sql.DAOS.DAO_Cuidado;
import static sql.DAOS.DAO_Cuidado.insertCuida;
import static sql.DAOS.DAO_Cuidado.pesquisaAgendamentoPaciente;
import static sql.DAOS.DAO_Cuidador.consultaCuidador;
import static sql.DAOS.DAO_Cuidador.pesquisaCuidador;
import static sql.DAOS.DAO_Cuidador.buscaCuidadorPeriodo;
import users.UsrCuidador;



public class InterfacePrincipalPaciente extends javax.swing.JFrame {

    public InterfacePrincipalPaciente(String id, String nome, String idade, String necessidades, String contato, String cidade, String bairro) throws Exception {
        initComponents(); //inicia componentes
        setaDados(id, nome, idade, necessidades, contato, cidade, bairro); //seta os dados
        lerTabela(); //lê tabelas de cuidadores
        lerTabelaAgendamentos(id); //Lê os agendamentos do paciente
    }
    
    private void lerTabela() throws Exception{
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel(); //inicia tabela
        modelo.setNumRows(0);
        HashMap<String, UsrCuidador> map = consultaCuidador(); //atribui o resultado de "consulta" a uma lista
        if(map!=null){
            Collection<UsrCuidador> cuidadores = map.values(); //atribui todos os valores de map à pista cuidadores
            for(UsrCuidador cuidador: cuidadores){  //loop enquanto houver itens(cuidador) dentro da lista(cuidadores)
                //insere o objeto cuidador em cada linha da tebela
                modelo.addRow(new Object[]{
                    cuidador.getId(),
                    cuidador.getNome(),
                    cuidador.getPeriodo(),
                    cuidador.getTipoContrato(),
                    cuidador.getDescricaoEspecialidade()

                });
            }
        }
    }
    //O mesmo codigo de "lerTabela" com um parâmetro de busca
    private void lerTabelaBusca(String Busca) throws Exception{
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        HashMap<String, UsrCuidador> map = pesquisaCuidador(Busca);
        if(map!=null){
            Collection<UsrCuidador> cuidadores = map.values();
            for(UsrCuidador cuidador:cuidadores){
                modelo.addRow(new Object[]{
                    cuidador.getId(),
                    cuidador.getNome(),
                    cuidador.getPeriodo(),
                    cuidador.getTipoContrato(),
                    cuidador.getDescricaoEspecialidade()

                });
            }
        }
    }
    
    private boolean verificaTurno(String idPaciente, String idNovoCuidador) throws Exception {
        Collection<UsrCuidador> cuidadoresAgendados = lerTabelaAgendamentos(idPaciente);
        if (cuidadoresAgendados != null) {
            String novoPeriodo = buscaCuidadorPeriodo(idNovoCuidador);

            for (UsrCuidador cuidador : cuidadoresAgendados) {
                String periodoAgendado = cuidador.getPeriodo().toString();
                if (periodoAgendado.equals(novoPeriodo)) {
                    return true; // Conflito encontrado
                }
            }
        }
        return false; // Sem conflitos
    }
    private Collection lerTabelaAgendamentos(String id) throws Exception{
        DefaultTableModel Agendamentos = (DefaultTableModel) tabelaAgendamentos.getModel(); //inicia tabela 
        Agendamentos.setNumRows(0);
        
        HashMap<String, UsrCuidador> map = pesquisaAgendamentoPaciente(id); //retorna os cuidadores que tem horario agendado com o paciente logado
        
        if(map!=null){
            Collection<UsrCuidador> cuidadores = map.values();
            //insere os cuidadores com horario marcado na tabela
            for(UsrCuidador cuidador: cuidadores){
                Agendamentos.addRow(new Object[]{
                    cuidador.getId(),
                    cuidador.getNome(),
                    cuidador.getPeriodo(),
                    cuidador.getTipoContrato(),
                    cuidador.getDescricaoEspecialidade()
                        

                });
            }
            return cuidadores;
        }
        return null;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        idade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        barradeBusca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        necessidades = new javax.swing.JTextField();
        contato = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        idcampo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAgendamentos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        idcuidado = new javax.swing.JSpinner();
        atualizar = new javax.swing.JButton();
        cidadecampo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bairrocampo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario: ");

        jLabel2.setText("Idade: ");

        nome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nome.setText("jTextField2");
        nome.setEnabled(false);
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        idade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        idade.setText("jTextField3");
        idade.setEnabled(false);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Usuario", "Turno", "Tipo", "Especialidades"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tabela);

        jLabel3.setText("Necessidades:");

        necessidades.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        necessidades.setText("jTextField1");
        necessidades.setEnabled(false);

        contato.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contato.setText("jTextField2");
        contato.setEnabled(false);

        jLabel4.setText("Contato:");

        jLabel5.setText("Pesquisar por especialidades");

        jLabel6.setText("Id do Cuidador");

        jButton2.setText("Agendar cuidado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Id:");

        idcampo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        idcampo.setText("jTextField1");
        idcampo.setEnabled(false);

        tabelaAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Usuario", "Turno", "Tipo", "Especialidades"
            }
        ));
        tabelaAgendamentos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabelaAgendamentos.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                tabelaAgendamentosMouseWheelMoved(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaAgendamentos);

        jLabel8.setText("Cuidados Agendados");

        atualizar.setText("Atualizar");
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        cidadecampo.setEnabled(false);

        jLabel9.setText("Cidade:");

        bairrocampo.setEnabled(false);

        jLabel10.setText("Bairro:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(necessidades, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(contato, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(idcampo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cidadecampo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(bairrocampo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(barradeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(idcuidado, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jButton2)))))
                        .addGap(94, 94, 94))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(atualizar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(barradeBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idcampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cidadecampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bairrocampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addComponent(idade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(necessidades, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idcuidado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(atualizar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void setaDados(String idPerfil, String nomePerfil, String idadePerfil, String necessidadesPerfil, String contatoPerfil, String cidade, String bairro){
        //insere dados do paciente nos campos de texto
        idcampo.setText(idPerfil);
        nome.setText(nomePerfil);
        idade.setText(idadePerfil);
        necessidades.setText(necessidadesPerfil);
        contato.setText(contatoPerfil);
        cidadecampo.setText(cidade);
        bairrocampo.setText(bairro);
        
    }
    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
    }//GEN-LAST:event_nomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            lerTabelaBusca(barradeBusca.getText());
        } catch (Exception ex) {
            Logger.getLogger(InterfacePrincipalPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        //se a funcao "verificaTurno" retornar false 
        if (!verificaTurno(idcampo.getText(), idcuidado.getValue().toString())) {
            //Agenda o cuidado
            insertCuida(idcampo.getText(), idcuidado.getValue().toString());
            JOptionPane.showMessageDialog(null, "Cuidado agendado com sucesso");
        } else {
            //retorna que os horários estão conflitantes e não agenda o cuidado
            JOptionPane.showMessageDialog(null, "Turnos conflitantes");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erro: " + ex);
    }
        
    
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabelaAgendamentosMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_tabelaAgendamentosMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaAgendamentosMouseWheelMoved

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        try {
            // TODO add your handling code here:
            lerTabelaAgendamentos(idcampo.getText());
        } catch (Exception ex) {
            Logger.getLogger(InterfacePrincipalPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_atualizarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipalPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipalPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipalPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacePrincipalPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String nome = null;
                    String idade = null;
                    String necessidades = null;
                    String contato = null;
                    String id= null;
                    String cidade=null;
                    String bairro=null;
                    
                    new InterfacePrincipalPaciente(id, nome, idade, necessidades, contato, cidade, bairro).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(InterfacePrincipalPaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JTextField bairrocampo;
    private javax.swing.JTextField barradeBusca;
    private javax.swing.JTextField cidadecampo;
    private javax.swing.JTextField contato;
    private javax.swing.JTextField idade;
    private javax.swing.JTextField idcampo;
    private javax.swing.JSpinner idcuidado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField necessidades;
    private javax.swing.JTextField nome;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabelaAgendamentos;
    // End of variables declaration//GEN-END:variables


}
