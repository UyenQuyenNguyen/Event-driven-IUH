package nguyenUyenQuyen_211124421_Week1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaiPhuongTrinhBacHai extends JFrame implements ActionListener {
	private JLabel Title = new JLabel("Giải Phương Trình Bậc Hai"), labelA = new JLabel("Nhập a: "),
			labelB = new JLabel("Nhập b: "), labelC = new JLabel("Nhập c: "), labelResult = new JLabel("Kết quả: ");
	private JTextField numberA = new JTextField(), numberB = new JTextField(), numberC = new JTextField(),
			ketQua = new JTextField();
	private JButton butGiai = new JButton("Giải"), butXoa = new JButton("Xóa rỗng"), butExit = new JButton("Thoát");

	public GiaiPhuongTrinhBacHai() {
		setTitle("Giải Phương Trình Bậc Hai");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createUI();

	}

	private void createUI() {
		JPanel panelNorth;
		add(panelNorth = new JPanel(), BorderLayout.NORTH);
		panelNorth.add(Title);
		Title.setFont(new Font("Arial", Font.BOLD, 24));
		panelNorth.setBackground(Color.PINK);

		JPanel panelCenter;
		add(panelCenter = new JPanel(), BorderLayout.CENTER);
		panelCenter.setLayout(null);
		panelCenter.add(labelA);
		int x = 80, y = 30, height = 30, width = 50;
		labelA.setBounds(x, y, width, height);

		panelCenter.add(labelB);
		y += 50;
		labelB.setBounds(x, y, width, height);

		panelCenter.add(labelC);
		y += 50;
		labelC.setBounds(x, y, width, height);

		panelCenter.add(labelResult);
		y += 50;
		labelResult.setBounds(x, y, width, height);

		panelCenter.add(numberA);
		y = 30;
		width = 250;
		x += 50;
		numberA.setBounds(x, y, width, height);

		panelCenter.add(numberB);
		y += 50;
		numberB.setBounds(x, y, width, height);

		panelCenter.add(numberC);
		y += 50;
		numberC.setBounds(x, y, width, height);

		panelCenter.add(ketQua);
		y += 50;
		ketQua.setBounds(x, y, width, height);
		ketQua.setEditable(false);

		JPanel panelSouth;
		add(panelSouth = new JPanel(), BorderLayout.SOUTH);
		panelSouth.setBorder(BorderFactory.createTitledBorder("Ch�?n tác vụ"));
		panelSouth.add(butGiai);
		panelSouth.add(butXoa);
		panelSouth.add(butExit);

		butGiai.addActionListener(this);
		butXoa.addActionListener(this);
		butExit.addActionListener(this);
	}

	public static void main(String[] args) {
		new GiaiPhuongTrinhBacHai().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(butExit)) {
			System.exit(0);
		} else if (o.equals(butXoa)) {
			numberA.setText("");
			numberB.setText("");
			numberC.setText("");
			ketQua.setText("");
		} else if (o.equals(butGiai)) {
			if (!isInt(numberA))
				focus(numberA);
			else if (!isInt(numberB))
				focus(numberB);
			else if (!isInt(numberC))
				focus(numberC);
			else {
				int a = Integer.parseInt(numberA.getText());
				int b = Integer.parseInt(numberB.getText());
				int c = Integer.parseInt(numberC.getText());
				if (a == 0) {
					GiaiPhuongTrinhBacNhat(b, c);
				} else {
					float delta = b * b - 4 * a * c;
					if (delta < 0)
						ketQua.setText("Vô nghiệm !");
					else if (delta == 0)
						ketQua.setText("Nghiệm kép: " + -b / 2 * a);
					else
						ketQua.setText(String.format("  X1 = %.2f | X2 = %.2f", (-b - Math.sqrt(delta)) / (2 * a),
								(-b + Math.sqrt(delta)) / (2 * a)));
				}

			}
		}

	}

	private void GiaiPhuongTrinhBacNhat(int b, int c) {
		if (b != 0)
			ketQua.setText("Nghiệm x = " + -c / (float) b);
		else if (c == 0)
			ketQua.setText("Vô số nghiệm");
		else
			ketQua.setText("Vô nghiệm");

	}

	private boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		} catch (NumberFormatException ex) {
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
