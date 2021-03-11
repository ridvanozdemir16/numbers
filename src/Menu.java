import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;

public class Menu {
	   //public enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard");
	   public TextMouseListener tmlis; 
	   public KeyListener klis; 

	   // ------ Standard variables for mouse and keyboard ------
	   public int mousepr;          // mouse pressed?
	   public int mousex, mousey;   // mouse text coords.
	   public int keypr;   // key pressed?
	   public int rkey;    // key   (for press/release)
	   // ----------------------------------------------------
	public Menu(enigma.console.Console cn) throws Exception {
		// ------ Standard code for mouse and keyboard ------ Do not change
	      tmlis=new TextMouseListener() {
	         public void mouseClicked(TextMouseEvent arg0) {}
	         public void mousePressed(TextMouseEvent arg0) {
	            if(mousepr==0) {
	               mousepr=1;
	               mousex=arg0.getX();
	               mousey=arg0.getY();
	            }
	         }
	         public void mouseReleased(TextMouseEvent arg0) {}
	      };
	      cn.getTextWindow().addTextMouseListener(tmlis);
	    
	      klis=new KeyListener() {
	         public void keyTyped(KeyEvent e) {}
	         public void keyPressed(KeyEvent e) {
	            if(keypr==0) {
	               keypr=1;
	               rkey=e.getKeyCode();
	            }
	         }
	         public void keyReleased(KeyEvent e) {}
	      };
	      cn.getTextWindow().addKeyListener(klis);
	      // ----------------------------------------------------
	      

	      int px=5,py=5;
	      
	      menuDisplay(cn);
	      cn.getTextWindow().setCursorPosition(35, 14);
	      cn.getTextWindow().output("| Play |");
	      cn.getTextWindow().setCursorPosition(33, 16);
	      cn.getTextWindow().output("| Tutorial |");
	      cn.getTextWindow().setCursorPosition(35, 18);
	      cn.getTextWindow().output("| Exit |");
	      boolean menuFlag=true;
	      boolean playFlag=true;
	      boolean gameModeFlag=false;
	      boolean tutorial1Flag=true;
	      boolean tutorial2Flag=true;
	      boolean exitFlag=true;
	      
	      /*cn.getTextWindow().setCursorPosition(0, 1);
  		  cn.getTextWindow().output("1.Easy Mode( )");*/
	      while(true) {
	    	  
	         if(mousepr==1) {  // if mouse button pressed
	            //cn.getTextWindow().output(mousex,mousey,'#');  // write a char to x,y position without changing cursor position
	            px=mousex; py=mousey;
	            //System.out.println(px+" "+py);
	            if(((px>=35 && px<=42) && py==14) && playFlag) {
	              clear(cn);
	        	  menuDisplay(cn);
	        	  cn.getTextWindow().setCursorPosition(35, 15);
	      	      cn.getTextWindow().output("| Easy |");
	      	      cn.getTextWindow().setCursorPosition(33, 17);
	      	      cn.getTextWindow().output("| Normal |");
	      	      cn.getTextWindow().setCursorPosition(35, 19);
	      	      cn.getTextWindow().output("| Hard |");
	      	      gameModeFlag=true;
	      	      tutorial1Flag=false;
	      	      playFlag=false;
	      	      menuFlag=false;
	      	      exitFlag=false;
	            }
	            if((((px>=62 && px<=69) && py==22) || ((px>=3 && px<=10) && py==27))&& menuFlag) {
	            	clear(cn);
	            	menuDisplay(cn);
	      	      	cn.getTextWindow().setCursorPosition(35, 14);
	      	      	cn.getTextWindow().output("| Play |");
	      	      	cn.getTextWindow().setCursorPosition(33, 16);
	      	      	cn.getTextWindow().output("| Tutorial |");
	      	      	cn.getTextWindow().setCursorPosition(35, 18);
	      	      	cn.getTextWindow().output("| Exit |");
	      	      	gameModeFlag=false;
	      	      	tutorial1Flag=true;
	      	      	tutorial2Flag=false;
	      	      	playFlag=true;
	      	      	menuFlag=false;
	      	      	exitFlag=true;
	            }
	            if(((px>=33 && px<=44) && py==16) && tutorial1Flag) {
	            	clear(cn);
	            	tutorial1(cn);
	            	menuFlag=true;
	            	playFlag=false;
	            	gameModeFlag=false;
	            	tutorial1Flag=false;
	            	tutorial2Flag=true;
	            	exitFlag=false;
      	      }
	            if(((px>=2 && px<=11) && py==22) && tutorial1Flag ) {
	            	clear(cn);
	            	tutorial1(cn);
	            	menuFlag=true;
	            	playFlag=false;
	            	gameModeFlag=false;
	            	tutorial1Flag=false;
	            	tutorial2Flag=true;
	            	exitFlag=false;
	            }
	            if(((px>=60 && px<=67) && py==27) && tutorial2Flag) {
	            	clear(cn);
	            	tutorial2(cn);
	            	menuFlag=true;
	            	playFlag=false;
	            	gameModeFlag=false;
	            	tutorial2Flag=false;
	            	tutorial1Flag=true;
	            	exitFlag=false;
      	      }
	            if(((px>=35 && px<=42) && py==15) && gameModeFlag) {
	            	clear(cn);
	            	Number game= new Number();
	            	game.easyRun();
      	      }
	            if(((px>=34 && px<=43) && py==17) && gameModeFlag) {
	            	clear(cn);
	            	Number game= new Number();
	            	game.normalRun();
      	      }
	            if(((px>=35 && px<=42) && py==19) && gameModeFlag) {
	            	clear(cn);
	            	Number game= new Number();
	            	game.hardRun();
      	      }
	            if(((px>=35 && px<=42) && py==18) && exitFlag) {
	            	System.exit(1);
      	      }
	      	   
	            mousepr=0;     // last action  
	         }
	         /*if(keypr==1) {    // if keyboard button pressed
	            if(rkey==KeyEvent.VK_LEFT) px--;   
	            if(rkey==KeyEvent.VK_RIGHT) px++;
	            if(rkey==KeyEvent.VK_UP) py--;
	            if(rkey==KeyEvent.VK_DOWN) py++;
	            
	            char rckey=(char)rkey;
	            //        left          right          up            down
	            if(rckey=='%' || rckey=='\'' || rckey=='&' || rckey=='(') cn.getTextWindow().output(px,py,'P'); // VK kullanmadan test teknigi
	            else cn.getTextWindow().output(rckey);
	            
	            if(rkey==KeyEvent.VK_SPACE) {
	               String str;         
	               str=cn.readLine();     // keyboardlistener running and readline input by using enter 
	               cn.getTextWindow().setCursorPosition(5, 20);
	               cn.getTextWindow().output(str);
	            }
	            
	            keypr=0;    // last action  
	         }*/
	         Thread.sleep(20);
	      }
	   }
	public void stars(int count)
	{
	    for (int i = 0; i < count; ++i)
	        System.out.print("*");
	}
	public void reverseStars(int count)
	{
	    for (int i = count; i >= 0; i--)
	        System.out.print("*");
	}
	 
	public void spaces(int count)
	{
	    for (int i = 0; i < count; ++i)
	    	System.out.print(" ");
	}
	public void reverseSpaces(int count)
	{
	    for (int i = count; i >=0; --i)
	    	System.out.print(" ");
	}
	public void tutorial1(enigma.console.Console cn) {
		cn.getTextWindow().setCursorPosition(2, 1);
    	cn.getTextWindow().output("########  ##    ##  ########  ##########  ######  ##  ########  ##");
    	cn.getTextWindow().setCursorPosition(2, 2);
    	cn.getTextWindow().output("########  ##    ##  ########  ##      ##  ##      ##  ##    ##  ##");
    	cn.getTextWindow().setCursorPosition(2, 3); 
    	cn.getTextWindow().output("   ##     ##    ##     ##     ##      ##  ##      ##  ########  ##");
    	cn.getTextWindow().setCursorPosition(2, 4);
    	cn.getTextWindow().output("   ##     ##    ##     ##     ##      ##  ##      ##  ##    ##  ##");
    	cn.getTextWindow().setCursorPosition(2, 5);
    	cn.getTextWindow().output("   ##     ##    ##     ##     ##      ##  ##      ##  ##    ##  ##");
    	cn.getTextWindow().setCursorPosition(1, 6);
    	cn.getTextWindow().output("########################################################################");
    	cn.getTextWindow().setCursorPosition(22, 8);
    	cn.getTextWindow().output("FIGHT AGAINST COMPUTER AI  ");
    	cn.getTextWindow().setCursorPosition(5, 9);
    	cn.getTextWindow().output("A random target number between 100-999 is determined initially.  ");
    	cn.getTextWindow().setCursorPosition(3, 10);
    	cn.getTextWindow().output("Players will try to reach this target number in 30 seconds. Players ");
    	cn.getTextWindow().setCursorPosition(3, 11);
    	cn.getTextWindow().output("use five random small numbers between 1-9, and one big number (25,50,");
    	cn.getTextWindow().setCursorPosition(3, 12);
    	cn.getTextWindow().output("75 or 100) and 4 basic operations (* / + -) to reach this target.  ");
    	cn.getTextWindow().setCursorPosition(21, 14);
    	cn.getTextWindow().output("GAME PLAYING RULES / STAGES  ");
    	cn.getTextWindow().setCursorPosition(12, 15);
    	cn.getTextWindow().output("1. Target number is choosen randomly (100-999).   ");
    	cn.getTextWindow().setCursorPosition(11, 16);
    	cn.getTextWindow().output("2. Five choosen number is choosen randomly (1-9).   ");
    	cn.getTextWindow().setCursorPosition(9, 17);
    	cn.getTextWindow().output("3. One big number is choosen randomly (25/50/75/100).   ");
    	cn.getTextWindow().setCursorPosition(18, 18);
    	cn.getTextWindow().output("4. 30-second countdown starts.   ");
    	cn.getTextWindow().setCursorPosition(5, 19);
    	cn.getTextWindow().output("5. During this time, human player make calculations in his mind or.   ");
    	cn.getTextWindow().setCursorPosition(1, 20);
    	cn.getTextWindow().output("with pen and paper.Computer tries to reach the target by using operations.   ");
    	cn.getTextWindow().setCursorPosition(20, 21);
    	cn.getTextWindow().output("6. Rules for operations: ");
    	cn.getTextWindow().setCursorPosition(8, 22);
    	cn.getTextWindow().output("# Players can use each number only once(given or calculated).   ");
    	cn.getTextWindow().setCursorPosition(14, 23);
    	cn.getTextWindow().output("# Players do not have to use all the numbers.   ");
    	cn.getTextWindow().setCursorPosition(3, 24);
    	cn.getTextWindow().output("#. If parenthesis are not used, multiplication and division have higher   ");
    	cn.getTextWindow().setCursorPosition(1, 25);
    	cn.getTextWindow().output("priority. Operations are calculated from left to right.   ");
    	cn.getTextWindow().setCursorPosition(58, 27);
    	cn.getTextWindow().output("| NEXT | ");
    	cn.getTextWindow().setCursorPosition(3, 27);
    	cn.getTextWindow().output("| MENU | ");
	}
	public void tutorial2(enigma.console.Console cn) {
		cn.getTextWindow().setCursorPosition(2, 1);
    	cn.getTextWindow().output("########  ##    ##  ########  ##########  ######  ##  ########  ##");
    	cn.getTextWindow().setCursorPosition(2, 2);
    	cn.getTextWindow().output("########  ##    ##  ########  ##      ##  ##      ##  ##    ##  ##");
    	cn.getTextWindow().setCursorPosition(2, 3); 
    	cn.getTextWindow().output("   ##     ##    ##     ##     ##      ##  ##      ##  ########  ##");
    	cn.getTextWindow().setCursorPosition(2, 4);
    	cn.getTextWindow().output("   ##     ##    ##     ##     ##      ##  ##      ##  ##    ##  ##");
    	cn.getTextWindow().setCursorPosition(2, 5);
    	cn.getTextWindow().output("   ##     ##    ##     ##     ##      ##  ##      ##  ##    ##  ##");
    	cn.getTextWindow().setCursorPosition(1, 6);
    	cn.getTextWindow().output("########################################################################");
    	cn.getTextWindow().setCursorPosition(4, 8);
    	cn.getTextWindow().output("7. When the time is up, players will announce their result number.  ");
    	cn.getTextWindow().setCursorPosition(1, 9);
    	cn.getTextWindow().output("8. The player with the closest number explains how he reached this number.  ");
    	cn.getTextWindow().setCursorPosition(4, 10);
    	cn.getTextWindow().output("9. If the explanation is correct he gets the point; if it is wrong,  ");
    	cn.getTextWindow().setCursorPosition(2, 11);
    	cn.getTextWindow().output("then his opponent gets that point.  ");
    	cn.getTextWindow().setCursorPosition(10, 12);
    	cn.getTextWindow().output("10. The one who reaches 100 points first wins the game.  ");
    	cn.getTextWindow().setCursorPosition(32, 14);
    	cn.getTextWindow().output("SCORING   ");
    	cn.getTextWindow().setCursorPosition(30, 15);
    	cn.getTextWindow().output("¯¯¯¯¯¯¯¯¯¯¯  ");
    	cn.getTextWindow().setCursorPosition(14, 16);
    	cn.getTextWindow().output("1. If the difference is less than or equals to 10;   ");
    	cn.getTextWindow().setCursorPosition(11, 17);
    	cn.getTextWindow().output("-- point = 15 - Abs(TargetNumber - CalculatedNumber) --  ");
    	cn.getTextWindow().setCursorPosition(16, 18);
    	cn.getTextWindow().output("2. If the difference is greater than 10;   ");
    	cn.getTextWindow().setCursorPosition(27, 19);
    	cn.getTextWindow().output("-- point = 5 --  ");
    	cn.getTextWindow().setCursorPosition(4, 22);
    	cn.getTextWindow().output("| BACK |");
    	cn.getTextWindow().setCursorPosition(60, 22);
    	cn.getTextWindow().output("| MENU |");
    	
    	
	}
	public void menuDisplay(enigma.console.Console cn) {
		  cn.getTextWindow().setCursorPosition(2, 1);
	      cn.getTextWindow().output("########   ##    ##   ##############   ##         ######   ######   ######");
	      cn.getTextWindow().setCursorPosition(2, 2);
	      cn.getTextWindow().output("##    ##   ##    ##   ##    ##    ##   ##         ##       ##       ##");
	      cn.getTextWindow().setCursorPosition(2, 3);
	      cn.getTextWindow().output("##    ##   ##    ##   ##    ##    ##   ########   ######   ##       ######");
	      cn.getTextWindow().setCursorPosition(2, 4);
	      cn.getTextWindow().output("##    ##   ##    ##   ##    ##    ##   ##    ##   ##       ##           ##");
	      cn.getTextWindow().setCursorPosition(2, 5);
	      cn.getTextWindow().output("##    ##   ########   ##    ##    ##   ########   ######   ##       ######"  );
   
   
    
    int n=8;
    for(int i=0;i<n;i++) {
  	  cn.getTextWindow().setCursorPosition(22, 8+i);
  	  stars(i+1);
  	  spaces(n-i-1);
  	  stars(n-i+1);
  	  spaces(2*i);
  	  stars(n-i);
  	  spaces(n-i-1);
  	  stars(i+1);
  	  System.out.println();
    }
    int m=0;
    for(int i=7;i>=0;i--) {
  	  cn.getTextWindow().setCursorPosition(22, 18+m);
  	  reverseStars(i);
  	  reverseSpaces(n-i-2);
  	  reverseStars(n-i);
  	  reverseSpaces(2*i-1);
  	  reverseStars(n-i-1);
  	  reverseSpaces(n-i-2);
  	  reverseStars(i);
  	  m++;
  	  System.out.println();
    }
	}
	public void clear(enigma.console.Console cn) {
		for(int i=0;i<100;i++) {
			System.out.println();
		}
		cn.getTextWindow().setCursorPosition(0, 0);
	}
}

