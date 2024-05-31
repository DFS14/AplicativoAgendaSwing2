package agendaSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class AgendaSwing1 extends JFrame {


	private static final long serialVersionUID = 7862957428712574106L;
	private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JButton btnAdicionar;
    private JButton btnLimpar;
    private JTextArea txtAreaContatos;
    private ArrayList<String> contatos;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            AgendaSwing1 window = new AgendaSwing1();
            window.setVisible(true);
        });
    }

    public AgendaSwing1() {
    	setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        setTitle("AGENDA");
        setSize(428, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setBackground(new Color(0, 0, 128));
        contatos = new ArrayList<>();

        GridLayout gl_painelFormulario = new GridLayout(5, 4);
        gl_painelFormulario.setHgap(2);
        gl_painelFormulario.setVgap(8);
        JPanel painelFormulario = new JPanel(gl_painelFormulario);
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setHorizontalAlignment(SwingConstants.CENTER);
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
        painelFormulario.add(lblNome);
        txtNome = new JTextField();
        txtNome.setHorizontalAlignment(SwingConstants.CENTER);
        painelFormulario.add(txtNome);
        JLabel lblTelefone = new JLabel("    Telefone:");
        lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
        lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
        painelFormulario.add(lblTelefone);
        txtTelefone = new JTextField();
        txtTelefone.setHorizontalAlignment(SwingConstants.CENTER);
        painelFormulario.add(txtTelefone);
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
        painelFormulario.add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        painelFormulario.add(txtEmail);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(192, 192, 192));
        btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAdicionar.setBounds(104, 23, 100, 25);
        btnAdicionar.addActionListener(e -> {
            String nome = txtNome.getText();
            String telefone = txtTelefone.getText();
            String email = txtEmail.getText();
            contatos.add(nome + " - " + telefone + " - " + email);
            atualizarListaContatos();
        });
        btnLimpar = new JButton("Limpar");
        btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnLimpar.setBounds(214, 23, 100, 25);
        btnLimpar.addActionListener(e -> {
            txtNome.setText("");
            txtTelefone.setText("");
            txtEmail.setText("");
        });
        painelBotoes.setLayout(null);
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnLimpar);

        txtAreaContatos = new JTextArea();
        txtAreaContatos.setEditable(false);

        getContentPane().add(painelFormulario, BorderLayout.NORTH);
        getContentPane().add(painelBotoes, BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(txtAreaContatos);
        setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane(), painelFormulario, lblNome, txtNome, lblTelefone, txtTelefone, lblEmail, txtEmail, painelBotoes, btnAdicionar, btnLimpar, scrollPane, txtAreaContatos}));
        getContentPane().add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void atualizarListaContatos() {
        txtAreaContatos.setText("");
        for (String contato : contatos) {
            txtAreaContatos.append(contato + "\n");
        }
    }
}
