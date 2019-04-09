package emirim.thread;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import emirim.view.SlideShowView;

public class SlideShowThread extends Thread {
	private SlideShowView ssv;
	private JLabel lblImg;
	private int sleepTime = 500;
	
	public SlideShowThread(SlideShowView ssv) {
		super();
		this.ssv = ssv;
		lblImg = ssv.getLblImg();
	}
	
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}


	@Override
	public void run() {
		int i = 0;
		while (true) {
			i++;
			if (i == 8)
				i = 1;
			String filename = "imgs/hn" + i + ".png";
			ImageIcon image = new ImageIcon(filename);
			lblImg.setIcon(image);
			try {
				sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
