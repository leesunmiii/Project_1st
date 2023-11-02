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
//   JLabel timeLa,parkingLa,priceLa;
//   JLabel menuLa;
   JButton b,b1,b2;
  // RoundedButton rb1;
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

      b=new JButton("목록");
      b1= new JButton("♡MY메뉴");
      b2= new JButton("원산지 정보");
      //rb1=new RoundedButton("F"); // 원 버튼 추가
      
      la1=new JLabel("가격"); 
      la2=new JLabel("내용"); 
      la3=new JLabel("간단설명"); 
      la4=new JLabel("가격"); 
      
      // 배치 
      setLayout(null);
      posterLa.setBounds(60, 120, 300, 300);
      add(posterLa);
      nameLa.setBounds(410, 120, 300 , 45);

      
      add(nameLa);
      
      
      //la3.setBounds(480, 150, 100, 50); // 간단설명
      //la3.setFont(new Font("맑은 고딕",Font.PLAIN, 20));
      priceLa.setBounds(410, 170, 500, 50); // 간단설명 내용
      priceLa.setFont(new Font("맑은 고딕",Font.PLAIN, 16));
      //add(la3);
      add(priceLa);
      
      
//      la1.setBounds(410, 220, 70, 35); // 가격
//      la1.setFont(new Font("맑은 고딕",Font.PLAIN, 20));
      summuryLa.setBounds(410, 220, 500, 30); // 가격 내용
      summuryLa.setFont(new Font("맑은 고딕",Font.BOLD, 20));
      summuryLa.setForeground(Color.RED);
//      add(la1);
      add(summuryLa);
      
//      la2.setBounds(100, 420, 70, 35); //내용
//      la2.setFont(new Font("맑은 고딕",Font.PLAIN, 20));
//      contentLa.setBounds(410, 270, 300, 80); // 내용 내용
//      contentLa.setFont(new Font("맑은 고딕",Font.PLAIN, 16));
//      add(la2);
      
        contentLabel = new JLabel();
        contentLabel.setBounds(410, 270, 400, 100);
        contentLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        contentLabel.setVerticalAlignment(SwingConstants.TOP); // 텍스트를 위쪽으로 정렬
        add(contentLabel);
      //add(contentLa);
      
      b.setBounds(750,650, 100, 35);
      add(b);
      
      b.addActionListener(this);
      
      b1.setBounds(590,220, 100, 35);
      b1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      add(b1);
      
      b1.addActionListener(this);
      
      b2.setBounds(700,220, 100, 35);
      b2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      add(b2);
      
      b2.addActionListener(this);
      
      // 원 버튼 추가
//      rb1.setBounds(750,500, 35, 35);
//      rb1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
//      add(rb1);
//      
//      rb1.addActionListener(this);
      
   }
   public void foodprint(FoodHouseVO vo)
   {
      
      try
      {
         nameLa.setText(vo.getName());
         nameLa.setFont(new Font("맑은 고딕", Font.BOLD, 30));
         
         summuryLa.setText(vo.getPrice());
         contentLa.setText(vo.getContent());
         priceLa.setText(vo.getSummary());
         
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