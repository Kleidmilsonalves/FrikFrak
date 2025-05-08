/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.frikfrak;

/**
 *
 * @author Kleidmilson Alves
 */
import javax.swing.JOptionPane;

import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.reflect.Array.get;
import static java.nio.file.Paths.get;
import static javax.swing.UIManager.get;


public class FF extends javax.swing.JFrame {

 
    static boolean colocando = true;
    
    int volta= 2;
    int botaoUsado [] = {0,0,0,0,0,0,0,0,0};
    int pXganho[] = {0,0,0,0,0,0,0,0,0};
    int pOganho[] = {0,0,0,0,0,0,0,0,0};
     int origem = -1; 
    int posicao = 0;
    
     int contadorX = 0;
     int contadorO = 0;
    
int origemSelecionada = -1;
public javax.swing.JButton getButton(int pos) {
    switch(pos) {
        case 0: return b0;
        case 1: return b1;
        case 2: return b2;
        case 3: return b3;
        case 4: return b4;
        case 5: return b5;
        case 6: return b6;
        case 7: return b7;
        case 8: return b8;
        default: return null;
    }
}

int pXganho(){
   
   if(pXganho[0]==1 && pXganho[1]==1 && pXganho[2]==1){
   
   return 1;
   }
   
   if(pXganho[3]==1 && pXganho[4]==1 && pXganho[5]==1){
   
   return 1;
   }
   
   if(pXganho[6]==1 && pXganho[7]==1 && pXganho[8]==1){
   
   return 1;
   }
   
  if(pXganho[0]==1 && pXganho[3]==1 && pXganho[6]==1){
   
   return 1;
   }
  
  if(pXganho[1]==1 && pXganho[4]==1 && pXganho[7]==1){
   
   return 1;
   }
  
  if(pXganho[2]==1 && pXganho[5]==1 && pXganho[8]==1){
   
   return 1;
   }
  
  if(pXganho[2]==1 && pXganho[5]==1 && pXganho[8]==1){
   
   return 1;
   }
  if(pXganho[2]==1 && pXganho[4]==1 && pXganho[6]==1){
   
   return 1;
   }
  if(pXganho[0]==1 && pXganho[4]==1 && pXganho[8]==1){
   
   return 1;
   }
        return 0;
   }
   
   
   
   int pOganho(){
   
   if(pOganho[0]==1 && pOganho[1]==1 && pOganho[2]==1){
   
   return 1;
   }
   
   if(pOganho[3]==1 && pOganho[4]==1 && pOganho[5]==1){
   
   return 1;
   }
   
   if(pOganho[6]==1 && pOganho[7]==1 && pOganho[8]==1){
   
   return 1;
   }
   
  if(pOganho[0]==1 && pOganho[3]==1 && pOganho[6]==1){
   
   return 1;
   }
  
  if(pOganho[1]==1 && pOganho[4]==1 && pOganho[7]==1){
   
   return 1;
   }
  
  if(pOganho[2]==1 && pOganho[5]==1 && pOganho[8]==1){
   
   return 1;
   }
  
  if(pOganho[2]==1 && pOganho[5]==1 && pOganho[8]==1){
   
   return 1;
   }
  if(pOganho[2]==1 && pOganho[4]==1 && pOganho[6]==1){
   
   return 1;
   }
  if(pOganho[0]==1 && pOganho[4]==1 && pOganho[8]==1){
   
   return 1;
   }
        return 0;
   }
   
   
   int[][] vizinhos = {
    {1, 3},       // 0
    {0, 2, 4},    // 1
    {1, 5},       // 2
    {0, 4, 6},    // 3
    {1, 3, 5, 7}, // 4
    {2, 4, 8},    // 5
    {3, 7},       // 6
    {4, 6, 8},    // 7
    {5, 7}        // 8
};

   
   
    boolean movimentoValido(int origem, int destino) {
    for (int i = 0; i < vizinhos[origem].length; i++) {
        if (vizinhos[origem][i] == destino) {
            return true;
        }
    }
    return false;
}
// Variável de classe para armazenar a posição da peça selecionada

    
    
   void processarJogada(int pos, javax.swing.JButton botao) {
    if (contadorX < 3 || contadorO < 3) {
        // Fase de colocação das peças
        if (botaoUsado[pos] == 0) {
            if (volta % 2 == 0 && contadorX < 3) {
                botao.setText("X");
                pXganho[pos] = 1;
                contadorX++;
            } else if (volta % 2 != 0 && contadorO < 3) {
                botao.setText("O");
                pOganho[pos] = 1;
                contadorO++;
            } else {
                return;
            }
            botaoUsado[pos] = 1;
            volta++;
        }
    } else {
        // Fase de movimentação
        if (origemSelecionada == -1) {
            // Selecionar peça do jogador atual
            if ((volta % 2 == 0 && pXganho[pos] == 1) || (volta % 2 != 0 && pOganho[pos] == 1)) {
                origemSelecionada = pos;
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma de suas peças.");
            }
        } else {
            // Mover peça selecionada
            if (botaoUsado[pos] == 0 && movimentoValido(origemSelecionada, pos)) {
                // Atualiza visualmente
                String simbolo = volta % 2 == 0 ? "X" : "O";
                botao.setText(simbolo);
                getButton(origemSelecionada).setText("");

                // Atualiza controle de jogo
                botaoUsado[pos] = 1;
                botaoUsado[origemSelecionada] = 0;

                if (volta % 2 == 0) {
                    pXganho[pos] = 1;
                    pXganho[origemSelecionada] = 0;
                } else {
                    pOganho[pos] = 1;
                    pOganho[origemSelecionada] = 0;
                }

                // Verifica vitória
                if (pXganho() == 1) {
                    JOptionPane.showMessageDialog(this, "Jogador 1 venceu!");
                } else if (pOganho() == 1) {
                    JOptionPane.showMessageDialog(this, "Jogador 2 venceu!");
                }

                volta++;
                origemSelecionada = -1;
            } else {
                JOptionPane.showMessageDialog(this, "Movimento inválido! Só pode mover para casa vizinha vazia.");
                origemSelecionada = -1;
            }
        }
    }
}

    

    public FF() {
        initComponents();
         setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reset = new javax.swing.JButton();
        b0 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        reset.setBackground(new java.awt.Color(51, 153, 255));
        reset.setFont(new java.awt.Font("Segoe Print", 3, 18)); // NOI18N
        reset.setText("Reiniciar");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        b0.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0ActionPerformed(evt);
            }
        });

        b1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b0, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b0, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
 /**
        b0.setText(" ");
        b1.setText(" ");
        b2.setText(" ");
        b3.setText(" ");
        b4.setText(" ");
        b5.setText(" ");
        b6.setText(" ");
        b7.setText(" ");
        b8.setText(" ");
*/
          volta = 2;
    contadorX = 0;
    contadorO = 0;
    origemSelecionada = -1;

    for (int i = 0; i < 9; i++) {
        botaoUsado[i] = 0;
        pXganho[i] = 0;
        pOganho[i] = 0;
        getButton(i).setText("");
    }

    }//GEN-LAST:event_resetActionPerformed

    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed

        processarJogada(0, b0);
        
       
    }//GEN-LAST:event_b0ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed

     processarJogada(1, b1);
     
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed

        processarJogada(2, b2);
     
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed

       processarJogada(3, b3);

    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed

      processarJogada(4, b4);
        
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed

      processarJogada(5, b5);
        
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed

        processarJogada(6, b6);
      
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed

        processarJogada(7, b7);
        
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed

       processarJogada(8, b8);
        
    }//GEN-LAST:event_b8ActionPerformed

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
            java.util.logging.Logger.getLogger(FF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b0;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
