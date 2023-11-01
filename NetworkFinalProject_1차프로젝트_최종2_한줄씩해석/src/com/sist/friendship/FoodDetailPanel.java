package com.sist.friendship;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import com.sist.vo.*;
import com.sist.common.ImageChange;
import com.sist.manager.*;
import java.net.*;
public class FoodDetailPanel extends JPanel implements ActionListener{
	JLabel posterLa;
	JLabel nameLa,summuryLa;
	JLabel contentLa,priceLa;
//	JLabel timeLa,parkingLa,priceLa;
//	JLabel menuLa;
	JButton b;
	ControllPanel cp;
	JLabel la1,la2,la3,la4,la5;
	JLabel contentLabel;
	
	public FoodDetailPanel(ControllPanel cp)
	{
		this.cp=cp;
		posterLa=new JLabel();
		nameLa=new JLabel();
		summuryLa=new JLabel();
		contentLa=new JLabel();
		priceLa=new JLabel();
//		typeLa=new JLabel();
//		timeLa=new JLabel();
//		parkingLa=new JLabel();
//		priceLa=new JLabel();
//		menuLa=new JLabel();
		
		b=new JButton("목록");
		
		la1=new JLabel("가격"); 
		la2=new JLabel("내용"); 
		la3=new JLabel("간단설명"); 
		la4=new JLabel("가격"); 
//		la5=new JLabel("주차"); 
//		la6=new JLabel("영업시간"); 
//		la7=new JLabel("메뉴"); 
		
		// 배치 
		setLayout(null);
		posterLa.setBounds(60, 120, 300, 300);
		add(posterLa);
		nameLa.setBounds(410, 120, 300 , 45);
		//scoreLa.setBounds(630, 15, 40, 35);
		
		add(nameLa);//add(scoreLa);
		
		
		//la3.setBounds(480, 150, 100, 50); // 간단설명
		//la3.setFont(new Font("맑은 고딕",Font.PLAIN, 20));
		priceLa.setBounds(410, 170, 500, 50); // 간단설명 내용
		priceLa.setFont(new Font("맑은 고딕",Font.PLAIN, 16));
		//add(la3);
		add(priceLa);
		
		
//		la1.setBounds(410, 220, 70, 35); // 가격
//		la1.setFont(new Font("맑은 고딕",Font.PLAIN, 20));
		summuryLa.setBounds(410, 220, 500, 30); // 가격 내용
		summuryLa.setFont(new Font("맑은 고딕",Font.BOLD, 20));
		summuryLa.setForeground(Color.RED);
//		add(la1);
		add(summuryLa);
		
//		la2.setBounds(100, 420, 70, 35); //내용
//		la2.setFont(new Font("맑은 고딕",Font.PLAIN, 20));
//		contentLa.setBounds(410, 270, 300, 80); // 내용 내용
//		contentLa.setFont(new Font("맑은 고딕",Font.PLAIN, 16));
//		add(la2);
		contentLabel = new JLabel();
        contentLabel.setBounds(410, 270, 400, 100);
        contentLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        contentLabel.setVerticalAlignment(SwingConstants.TOP); // 텍스트를 위쪽으로 정렬
        add(contentLabel);
		//add(contentLa);
		
		
		
//		la4.setBounds(320, 180, 70, 35);
//		priceLa.setBounds(395,180, 400, 35);
//		add(la1);add(priceLa);
//		
//		la5.setBounds(320, 220, 70, 35);
//		parkingLa.setBounds(395, 220, 400, 35);
//		add(la5);add(parkingLa);
//		
//		la6.setBounds(320, 260, 70, 35);
//		timeLa.setBounds(395, 260, 400, 35);
//		add(la6);add(timeLa);
//		
//		la7.setBounds(320, 300, 70, 35);
//		menuLa.setBounds(395, 300, 400, 35);
//		add(la7);add(menuLa);
		
		b.setBounds(750,650, 100, 35);
		add(b);
		
		b.addActionListener(this);
		
		
	}
	public void foodprint(FoodHouseVO vo)
	{
		
		try
		{
			
			
			
			
			nameLa.setText(vo.getName());
			nameLa.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			//scoreLa.setText(String.valueOf(vo.getName()));
			summuryLa.setText(vo.getPrice());
			contentLa.setText(vo.getContent());
			priceLa.setText(vo.getSummary());
			//timeLa.setText(vo.getContent());
//			parkingLa.setText(vo.getParking());
//			priceLa.setText(vo.getPrice());
//			menuLa.setText(vo.getMenu());
			System.out.println(vo.getPoster());
			URL url=new URL(vo.getPoster());
			Image image=ImageChange.getImage(new ImageIcon(url), 300, 300);
			posterLa.setIcon(new ImageIcon(image));
			contentLabel.setText("<html>" + vo.getContent().replaceAll("\n", "<br>") + "</html>"); // <br> 태그로 줄바꿈 처리
		}catch(Exception ex) {
			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
	{
		cp.card.show(cp, "home");
	}
	}
}