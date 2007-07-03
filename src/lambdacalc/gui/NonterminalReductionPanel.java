/*
 * NonterminalReductionPanel.java
 *
 * Created on June 21, 2007, 11:58 AM
 */

package lambdacalc.gui;

import lambdacalc.exercises.AnswerStatus;
import lambdacalc.exercises.Exercise;
import lambdacalc.exercises.LambdaConversionExercise;
import lambdacalc.lf.MeaningEvaluationException;
import lambdacalc.logic.Expr;
import lambdacalc.logic.SyntaxException;
import lambdacalc.logic.TypeEvaluationException;

/**
 *
 * @author  champoll
 */
public class NonterminalReductionPanel extends javax.swing.JPanel {

    private LambdaConversionExercise exercise;
    private TreeExerciseWidget teWidget;
    
    /** Creates new form NonterminalReductionPanel */
    public NonterminalReductionPanel() {
        initComponents();
    }
    

    public Exercise getExercise() {
        return exercise;
    }

    public void initialize(LambdaConversionExercise exercise, TreeExerciseWidget widget) {
        this.teWidget = widget;
        this.exercise = exercise;
        tellGUIProblemChanged();
        if (exercise.isNotReducible())
            noSimplificationNeeded();
    }
    

    //TODO this is copied from TrainingWindow -- make static in Util?
    private void switchOn(javax.swing.JTextField j) {
        j.setEnabled(true);
        j.setEditable(true);
        //j.setBackground(javax.swing.UIManager.getColor("TextField.activeBackground"));
    }
    
    private void switchOff(javax.swing.JTextField j) {
        j.setEnabled(false);
        j.setEditable(false);
        //if (j.getText().equals("")) {
        //    j.setBackground(javax.swing.UIManager.getColor("TextField.inactiveBackground"));
        //}
    }    

    private void tellGUIProblemChanged() {
        //TODO check to what extent this corresponds with ScratchPadWindow
        //method tellGUIProblemEntered
        txtFeedback.setText("");
        txtQuestion.setText(exercise.toString());
        jButtonCheckAnswer.setEnabled(true);
        btnTransfer.setEnabled(true);
        txtUserAnswer.setTemporaryText("enter an expression");
        switchOn(txtUserAnswer);
        txtUserAnswer.requestFocusInWindow();
    }

    private void tellGUIProblemSolved() {
        switchOff(txtUserAnswer);
        jButtonCheckAnswer.setEnabled(false);
        btnTransfer.setEnabled(true);
    }    
    
    private void noSimplificationNeeded() {
        tellGUIProblemSolved();
        txtFeedback.setText("This node is fully simplified. " +
                "You do not need to work on it. Click on another node.");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPaneFeedback = new javax.swing.JScrollPane();
        txtFeedback = new javax.swing.JTextArea();
        jPanelQuestion = new javax.swing.JPanel();
        txtQuestion = new lambdacalc.gui.LambdaEnabledTextField();
        btnTransfer = new javax.swing.JButton();
        txtUserAnswer = new lambdacalc.gui.LambdaEnabledTextField();
        jButtonCheckAnswer = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jScrollPaneFeedback.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jScrollPaneFeedback.setBorder(javax.swing.BorderFactory.createTitledBorder("Feedback"));
        jScrollPaneFeedback.setMinimumSize(new java.awt.Dimension(247, 228));
        jScrollPaneFeedback.setPreferredSize(new java.awt.Dimension(247, 228));
        txtFeedback.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        txtFeedback.setColumns(20);
        txtFeedback.setEditable(false);
        txtFeedback.setFont(new java.awt.Font("SansSerif", 0, 12));
        txtFeedback.setLineWrap(true);
        txtFeedback.setRows(5);
        txtFeedback.setWrapStyleWord(true);
        txtFeedback.setBorder(null);
        txtFeedback.setPreferredSize(new java.awt.Dimension(220, 180));
        jScrollPaneFeedback.setViewportView(txtFeedback);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        add(jScrollPaneFeedback, gridBagConstraints);

        jPanelQuestion.setLayout(new java.awt.GridBagLayout());

        txtQuestion.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        txtQuestion.setBorder(null);
        txtQuestion.setEditable(false);
        txtQuestion.setFont(new java.awt.Font("Serif", 0, 18));
        txtQuestion.setPreferredSize(new java.awt.Dimension(460, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanelQuestion.add(txtQuestion, gridBagConstraints);

        btnTransfer.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        btnTransfer.setText("Paste");
        btnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 5);
        jPanelQuestion.add(btnTransfer, gridBagConstraints);

        txtUserAnswer.setFont(new java.awt.Font("Serif", 0, 18));
        txtUserAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserAnswerActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanelQuestion.add(txtUserAnswer, gridBagConstraints);

        jButtonCheckAnswer.setText("Check Answer");
        jButtonCheckAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckAnsweronCheckAnswer(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanelQuestion.add(jButtonCheckAnswer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(jPanelQuestion, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void txtUserAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserAnswerActionPerformed
        jButtonCheckAnswer.doClick();
    }//GEN-LAST:event_txtUserAnswerActionPerformed

    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferActionPerformed
        txtUserAnswer.setText(txtQuestion.getText());
        txtUserAnswer.requestFocusInWindow();
    }//GEN-LAST:event_btnTransferActionPerformed

    private void menuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCloseActionPerformed

    }//GEN-LAST:event_menuItemCloseActionPerformed

    private void jRadioButtonLambdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLambdaActionPerformed
       
    }//GEN-LAST:event_jRadioButtonLambdaActionPerformed

    private void jRadioButtonTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTypeActionPerformed
        
    }//GEN-LAST:event_jRadioButtonTypeActionPerformed

    private void jButtonDoAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoAgainActionPerformed
        
    }//GEN-LAST:event_jButtonDoAgainActionPerformed

    private void jButtonDoAnotherProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoAnotherProblemActionPerformed
        
    }//GEN-LAST:event_jButtonDoAnotherProblemActionPerformed

    private void jButtonCloseWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseWindowActionPerformed
        
    }//GEN-LAST:event_jButtonCloseWindowActionPerformed

    private void jButtonEnterProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnterProblemActionPerformed
        
    }//GEN-LAST:event_jButtonEnterProblemActionPerformed

    private void jButtonCheckAnsweronCheckAnswer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckAnsweronCheckAnswer
        txtUserAnswer.deleteAnyTemporaryText();
        String string = txtUserAnswer.getText().trim();
        if (!string.equals(txtUserAnswer.getText()))
            txtUserAnswer.setText(string);
        
        Expr answer;
        try {
            answer = exercise.parse(txtUserAnswer.getText());
        } catch (SyntaxException s) {
            displayFeedback(s.getMessage());
            if (s.getPosition() >= 0 && s.getPosition() <= txtUserAnswer.getText().length())
                txtUserAnswer.setCaretPosition(s.getPosition());
            txtUserAnswer.requestFocusInWindow();
            return;
        }
        
        AnswerStatus status = exercise.checkAnswer(answer);
        String lastAnswer = exercise.getLastAnswer();        
        
        if (status.isCorrect()) {
            teWidget.advanceSimplification(answer);
            if (status.endsExercise()) {
                tellGUIProblemSolved();
                
                String response = status.getMessage() + " ";
                if (!teWidget.isTreeFullyEvaluated()) {
                    response += "Now click on another node to continue.";
                } else {
                    response += "You have completed this tree.";
                }
                displayFeedback(response);
            } else { // "Correct! Now simplify..."
                //TODO if I replace the following line by
                //txtQuestion.setText(exercise.getLastAnswer());
                //then "exercise.getLastAnswer()" returns null, even though
                //it doesn't return null ten lines above. The workaround for now
                //is to have the lastAnswer determined above. But I really don't
                //understand at all how getLastAnswer() can be affecte by the 
                //calls in the ten lines above. -Lucas
                txtQuestion.setText(lastAnswer);
                displayFeedback(status.getMessage());
            }
        } else {
            displayFeedback(status.getMessage());
        }
        
        txtUserAnswer.requestFocusInWindow();
    }//GEN-LAST:event_jButtonCheckAnsweronCheckAnswer

    private void displayFeedback(String msg) {
        txtFeedback.setText(msg);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTransfer;
    private javax.swing.JButton jButtonCheckAnswer;
    private javax.swing.JPanel jPanelQuestion;
    private javax.swing.JScrollPane jScrollPaneFeedback;
    private javax.swing.JTextArea txtFeedback;
    private lambdacalc.gui.LambdaEnabledTextField txtQuestion;
    private lambdacalc.gui.LambdaEnabledTextField txtUserAnswer;
    // End of variables declaration//GEN-END:variables
    
}
