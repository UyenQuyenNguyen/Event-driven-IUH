package nguyenUyenQuyen_211124421_Week1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InSoNguyenTo  extends JFrame {
	private JTextField inputBox = new JTextField(10);
	private JButton generate = new JButton("Generate");
	private JTextArea result = new JTextArea();
	
	public InSoNguyenTo(){
		setTitle("Primes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		createUI();
	}
	
	private void createUI(){
		setLayout(null);
		add(inputBox);
		inputBox.setBounds(50, 30, 200, 30);
		inputBox.setToolTipText("Nhập số nguyên tố cần hiển thị: ");
		
		add(generate);
		generate.setBounds(250, 30, 100, 30);
		
		JScrollPane scroll;
		add(scroll = new JScrollPane(result));
		scroll.setBounds(50, 70, 300, 170);
		result.setToolTipText("Danh sách các số nguyên tố.");
		result.setEditable(false);
		
		generate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText("");
				try{
					int n = Integer.parseInt(inputBox.getText());
					if(n > 0){
						for(int i = 2; i < Integer.MAX_VALUE; i++){
							if(isPrime(i)){
								n--;
								result.append(i + "\n");
							}
							if(n == 0)
								break;
						}
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Nhập số nguyên dương");
					}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Lỗi nhập liệu !");
				}
				focus();
				
			}
			
		});
	}
	private void focus(){
		inputBox.selectAll();
		inputBox.requestFocus();
		return;
	}
	
	private boolean isPrime(int num){
		if(num < 2)
			return false;
		else{
			for(int i = 2; i <= Math.sqrt(num); i++){
				if(num % i == 0)
					return false;
			}
			return true;
		}
	}
	
	
	public static void main(String[] args) {
		new InSoNguyenTo().setVisible(true);
	}


	

}

