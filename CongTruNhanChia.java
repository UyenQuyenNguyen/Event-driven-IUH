package nguyenUyenQuyen_211124421_Week1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;




public class CongTruNhanChia extends JPanel implements ActionListener{
	private JButton 
		Giai = new JButton("Giải"),
		Xoa = new JButton("Xóa"),
		Thoat = new JButton("Thoát"),
		changeBlue = new JButton(),
		changeRed = new JButton(),
		changeYellow = new JButton(); 
	private JLabel
		title = new JLabel("Cộng Trừ Nhân Chia"),
		firstNum = new JLabel("Nhập a: "),
		secondNum = new JLabel("Nhập b: "),
		result  = new JLabel("Kết quả: ");
	private JTextField 
		txtFirst = new JTextField(20),
		txtSecond = new JTextField(20),
		txtResult = new JTextField(20);
	private JRadioButton 
		add = new JRadioButton("Cộng"),
		sub = new JRadioButton("Trừ"),
		mul = new JRadioButton("Nhân"),
		div = new JRadioButton("Chia");
	private JPanel shapeColor = new JPanel(),
			 squarePan = new JPanel();
	
	
	public CongTruNhanChia() {
		
		ButtonGroup g = new ButtonGroup();
		g.add(add);
		g.add(sub);
		g.add(mul);
		g.add(div);
		setLayout(new BorderLayout());
		JPanel titlePan;
		add(titlePan = new JPanel(), BorderLayout.NORTH);
		titlePan.add(title);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Arial", Font.BOLD, 24));
		
		JPanel leftPan;
		add(leftPan = new JPanel(), BorderLayout.WEST);
		leftPan.setPreferredSize(new Dimension(120, 75));
		leftPan.setLayout(null);
		leftPan.setBorder(BorderFactory.createTitledBorder("Ch�?n tác vụ"));
		leftPan.setBackground(Color.GRAY);
		
		int x = 20, y = 30, width = 80, height= 30;
		leftPan.add(Giai);
		Giai.setBounds(x, y, width, height);
		y+= 40;
		leftPan.add(Xoa);
		Xoa.setBounds(x, y, width, height);
		y+= 40;
		leftPan.add(Thoat);
		Thoat.setBounds(x, y, width, height);
		
		JPanel rightPan;
		add(rightPan = new JPanel(), BorderLayout.CENTER);
		rightPan.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		
		Box rightBox = Box.createVerticalBox();
		rightBox.setPreferredSize(new Dimension(300, 250));
		
		JPanel inputFirst;
		rightBox.add(inputFirst = new JPanel());
		inputFirst.setLayout(new FlowLayout());
		inputFirst.add(firstNum);
		inputFirst.add(txtFirst);
		
		JPanel inputSecond;
		rightBox.add(inputSecond = new JPanel());
		inputSecond.add(secondNum);
		inputSecond.add(txtSecond);
		
		rightPan.add(rightBox);
		
		JPanel checkRadio;
		rightBox.add(checkRadio = new JPanel());
		checkRadio.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		checkRadio.setLayout(new GridLayout(2,2));
		checkRadio.add(add);
		checkRadio.add(sub);
		checkRadio.add(mul);
		checkRadio.add(div);
		
		JPanel outputPan;
		rightBox.add(outputPan = new JPanel());
		outputPan.add(result);
		outputPan.add(txtResult);
		txtResult.setEditable(false);
		
		
		add(shapeColor, BorderLayout.SOUTH);
		shapeColor.setBackground(Color.decode("#d88f8f"));
	
		shapeColor.add(squarePan = new JPanel());
		squarePan.setBackground(Color.decode("#d88f8f"));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		changeBlue.setBorder(null);
		changeBlue.setPreferredSize(new Dimension(20,20));
		changeBlue.setBorder(emptyBorder);
		changeRed.setPreferredSize(new Dimension(20,20));
		changeRed.setBorder(emptyBorder);
		changeYellow.setPreferredSize(new Dimension(20,20));
		changeYellow.setBorder(emptyBorder);
		
		changeBlue.setBackground(Color.BLUE);
		squarePan.add(changeBlue);
		changeRed.setBackground(Color.RED);
		squarePan.add(changeRed);
		changeYellow.setBackground(Color.YELLOW);
		squarePan.add(changeYellow);
		
		Giai.addActionListener(this);
		Xoa.addActionListener(this);
		Thoat.addActionListener(this);
		changeBlue.addActionListener(this);
		changeYellow.addActionListener(this);
		changeRed.addActionListener(this);
		

	}
		
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		f.setTitle("Cộng - Trừ - Nhân - Chia");
		f.setSize(600, 400);
		f.setLocationRelativeTo(null);
		f.setContentPane(new CongTruNhanChia());
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(Thoat))
			System.exit(0);
		else if(o.equals(Xoa)){
			txtFirst.setText("");
			txtSecond.setText("");
			txtResult.setText("");
		}else if(o.equals(Giai)){
			if(!isInt(txtFirst))
				focus(txtFirst);
			else if(!isInt(txtSecond))
				focus(txtSecond);
			else{
				float a = Float.parseFloat(txtFirst.getText());
				float b = Float.parseFloat(txtSecond.getText());
				if(add.isSelected())
					txtResult.setText(String.format("%.2f", a + b));
				else if(sub.isSelected())
					txtResult.setText(String.format("%.2f", a - b));
				else if(mul.isSelected())
					txtResult.setText(String.format("%.2f", a * b));
				else if(div.isSelected())
					txtResult.setText(String.format("%.2f", a / b));
				else{
					JOptionPane.showMessageDialog(null, "Ch�?n phép tính !");
				}
			}
			
		}
		if(o.equals(changeBlue)){
			shapeColor.setBackground(Color.decode("#78a7e5"));
			squarePan.setBackground(Color.decode("#78a7e5"));
		}else if(o.equals(changeRed)){
			shapeColor.setBackground(Color.decode("#e77474"));
			squarePan.setBackground(Color.decode("#e77474"));
		}else if(o.equals(changeYellow)){
			shapeColor.setBackground(Color.decode("#e3e578"));
			squarePan.setBackground(Color.decode("#e3e578"));
		}
	}
	
	private boolean isInt(JTextField text) {
		boolean result = true;
		try{
			Integer.parseInt(text.getText());
		}catch(NumberFormatException ex) {
			result = false;
		}
		return result;
	}
	
	private void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "Lỗi nhập liệu !");
		text.selectAll();
		text.requestFocus();
	}

}
