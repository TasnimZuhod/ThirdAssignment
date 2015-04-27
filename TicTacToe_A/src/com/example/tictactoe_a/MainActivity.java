package com.example.tictactoe_a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    
	Tic mygame;
	ImageButton imgbtn1, imgbtn2, imgbtn3, imgbtn4, imgbtn5, imgbtn6, imgbtn7, imgbtn8, imgbtn9;
	int r=0, c=0;
	TextView rslt;
	String player = "";
	int scoreX=0, scoreO=0;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addListener();
        
        Dialog dialog = selectPlayer();
        dialog.show();
   
    }
    
    public void disableBoard(){
    	
    	imgbtn1.setOnClickListener(null);
    	imgbtn2.setOnClickListener(null);
    	imgbtn3.setOnClickListener(null);
    	imgbtn4.setOnClickListener(null);
    	imgbtn5.setOnClickListener(null);
    	imgbtn6.setOnClickListener(null);
    	imgbtn7.setOnClickListener(null);
    	imgbtn8.setOnClickListener(null);
    	imgbtn9.setOnClickListener(null);
    	
    }
    
    
    public boolean checkBoard(){
    	if(mygame.winner() == '_')
    		return true;
    	
    	disableBoard();
    	
    	char win = mygame.winner();
    	
    	if (win == 'T'){
    		rslt = (TextView)findViewById(R.id.result);
    		rslt.setText("Both of you played to a tie.");
    	}
    	else{
            rslt = (TextView)findViewById(R.id.result);
    		
    		if(mygame.whosePiece(win).equals("X")){
    			scoreX++;
    			rslt.setText(mygame.whosePiece(win)+": Congratulations, you have won the game."
    					+"\nScore: "+scoreX);
    		}
    		else{
    			scoreO++;
    			rslt.setText(mygame.whosePiece(win)+": Congratulations, you have won the game."
    					+"\nScore: "+scoreO);
    		}
    		color();
    	}
    	Dialog dialog = playAgainAlert();
        dialog.show();
    	
    	return false;
    }
    
    public void color(){
    	
    	if(Tic.flag.equals("row")){
    		switch(Tic.index){
    		case 0:
    			imgbtn1.setBackgroundColor(Color.CYAN);
    			imgbtn2.setBackgroundColor(Color.CYAN);
    			imgbtn3.setBackgroundColor(Color.CYAN);
    			break;
    		case 1:
    			imgbtn4.setBackgroundColor(Color.CYAN);
    			imgbtn5.setBackgroundColor(Color.CYAN);
    			imgbtn6.setBackgroundColor(Color.CYAN);
    			break;
    		case 2:
    			imgbtn7.setBackgroundColor(Color.CYAN);
    			imgbtn8.setBackgroundColor(Color.CYAN);
    			imgbtn9.setBackgroundColor(Color.CYAN);
    			break;
    		}
    	}
    	else if(Tic.flag.equals("col")){
    		switch(Tic.index){
    		case 0:
    			imgbtn1.setBackgroundColor(Color.CYAN);
    			imgbtn4.setBackgroundColor(Color.CYAN);
    			imgbtn7.setBackgroundColor(Color.CYAN);
    			break;
    		case 1:
    			imgbtn2.setBackgroundColor(Color.CYAN);
    			imgbtn5.setBackgroundColor(Color.CYAN);
    			imgbtn8.setBackgroundColor(Color.CYAN);
    			break;
    		case 2:
    			imgbtn3.setBackgroundColor(Color.CYAN);
    			imgbtn6.setBackgroundColor(Color.CYAN);
    			imgbtn9.setBackgroundColor(Color.CYAN);
    			break;
    		}
    	}
    	else if(Tic.flag.equals("fordiag")){
    			imgbtn1.setBackgroundColor(Color.CYAN);
    			imgbtn5.setBackgroundColor(Color.CYAN);
    			imgbtn9.setBackgroundColor(Color.CYAN);
    			}
    	else if(Tic.flag.equals("backdiag")){
			imgbtn3.setBackgroundColor(Color.CYAN);
			imgbtn5.setBackgroundColor(Color.CYAN);
			imgbtn7.setBackgroundColor(Color.CYAN);
			}
    }
    
    public void play(){
    	
    	if( ! mygame.move(r,c) )
    		;
    	// Change who's turn it is.
    	mygame.changeturn();
    		
    }
    
    
    String turn = "";
    public void addListener() {
    	 
    	imgbtn1 = (ImageButton) findViewById(R.id.imageButton1); 
    	imgbtn2 = (ImageButton) findViewById(R.id.imageButton2);
    	imgbtn3 = (ImageButton) findViewById(R.id.imageButton3);
    	imgbtn4 = (ImageButton) findViewById(R.id.imageButton4);
    	imgbtn5 = (ImageButton) findViewById(R.id.imageButton5);
    	imgbtn6 = (ImageButton) findViewById(R.id.imageButton6);
    	imgbtn7 = (ImageButton) findViewById(R.id.imageButton7);
    	imgbtn8 = (ImageButton) findViewById(R.id.imageButton8);
    	imgbtn9 = (ImageButton) findViewById(R.id.imageButton9);
 
    	imgbtn1.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				
				if( !checkBoard() )
					return;
				
				r = 0;
				c = 0;
				
				turn = mygame.getCurrentPlayer();

				if(turn.equals("X")) 
					imgbtn1.setImageResource(R.drawable.x);
				else
					imgbtn1.setImageResource(R.drawable.o);
				
				play();
				checkBoard();
			}
 
		});
    	
    	imgbtn2.setOnClickListener(new OnClickListener() {
    		 
			@Override
			public void onClick(View arg0) { 
				
				if( !checkBoard() )
					return;
				
				r = 0;
				c = 1;
				
				turn = mygame.getCurrentPlayer();

				if(turn.equals("X")) 
					imgbtn2.setImageResource(R.drawable.x);
				else
					imgbtn2.setImageResource(R.drawable.o);
				
				play();
				checkBoard();
			}
 
		});
    	
    	imgbtn3.setOnClickListener(new OnClickListener() {
    		 
			@Override
			public void onClick(View arg0) {
				
				if( !checkBoard() )
					return;
				
				r = 0;
				c = 2;
				
				turn = mygame.getCurrentPlayer();

				if(turn.equals("X")) 
					imgbtn3.setImageResource(R.drawable.x);
				else
					imgbtn3.setImageResource(R.drawable.o);
				
				play();
				checkBoard();
			}
 
		});
    	
    	imgbtn4.setOnClickListener(new OnClickListener() {
    		 
			@Override
			public void onClick(View arg0) {
				
				if( !checkBoard() )
					return;
				
				r = 1;
				c = 0;
				
				turn = mygame.getCurrentPlayer();

				if(turn.equals("X")) 
					imgbtn4.setImageResource(R.drawable.x);
				else
					imgbtn4.setImageResource(R.drawable.o);
				
				play();
				checkBoard();
			}
 
		});
    	
    	imgbtn5.setOnClickListener(new OnClickListener() {
    		 
			@Override
			public void onClick(View arg0) {
				
				if( !checkBoard() )
					return;
				
				r = 1;
				c = 1;
				
				turn = mygame.getCurrentPlayer();

				if(turn.equals("X")) 
					imgbtn5.setImageResource(R.drawable.x);
				else
					imgbtn5.setImageResource(R.drawable.o);
				
				play();
				checkBoard();
			}
 
		});
    	
    	imgbtn6.setOnClickListener(new OnClickListener() {
    		 
			@Override
			public void onClick(View arg0) {
				
				if( !checkBoard() )
					return;
				
				r = 1;
				c = 2;
				
				turn = mygame.getCurrentPlayer();

				if(turn.equals("X")) 
					imgbtn6.setImageResource(R.drawable.x);
				else
					imgbtn6.setImageResource(R.drawable.o);
				
				play();
				checkBoard();
			}
 
		});
    	
    	imgbtn7.setOnClickListener(new OnClickListener() {
   		 
			@Override
			public void onClick(View arg0) {
				
				if( !checkBoard() )
					return;
				
				r = 2;
				c = 0;
				
				turn = mygame.getCurrentPlayer();

				if(turn.equals("X")) 
					imgbtn7.setImageResource(R.drawable.x);
				else
					imgbtn7.setImageResource(R.drawable.o);
				
				play();
				checkBoard();
			}
 
		});
    	
    	imgbtn8.setOnClickListener(new OnClickListener() {
   		 
			@Override
			public void onClick(View arg0) {
				
				if( !checkBoard() )
					return;
				
				r = 2;
				c = 1;
				
				turn = mygame.getCurrentPlayer();

				if(turn.equals("X")) 
					imgbtn8.setImageResource(R.drawable.x);
				else
					imgbtn8.setImageResource(R.drawable.o);
				
				play();
				checkBoard();
			}
 
		});
    	
    	imgbtn9.setOnClickListener(new OnClickListener() {
   		 
			@Override
			public void onClick(View arg0) {
				
				if( !checkBoard() )
					return;
				
				r = 2;
				c = 2;
				
				turn = mygame.getCurrentPlayer();

				if(turn.equals("X")) 
					imgbtn9.setImageResource(R.drawable.x);
				else
					imgbtn9.setImageResource(R.drawable.o);
				
				play();
				checkBoard();
			}
 
		});
 
	}
    
    
    public Dialog selectPlayer(){

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		CharSequence[] array = {"X", "O"};

		builder.setTitle("Select the player")
		.setSingleChoiceItems(array, 1, new DialogInterface.OnClickListener() {

		@Override
		public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub

		}
		})

		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int id) {
			
			int selectedPosition = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
			
			switch(selectedPosition)
            {
                case 0:
                	player = "X";
                	break;
                case 1:
                	player = "O"; 
                	break;
                
            }
			if(player.equals("X"))
				mygame = new Tic(player, "O");
			else
				mygame = new Tic(player, "X");
		}
		});
		
		return builder.create();
		}
    
    
    public Dialog playAgainAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do You Want To Play Again?")
               .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   playAgain();
                   }
               })
               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   
                   }
               });
        return builder.create();
    }
    
	public void newGame(){
    	
    	setContentView(R.layout.activity_main);
    	addListener();
    	player = "";
    	scoreO=0;
    	scoreX=0;
    	r=0;
    	c=0;
    	Dialog dialog = selectPlayer();
        dialog.show();
        
    }
    
	public void playAgain(){
		
		setContentView(R.layout.activity_main);
    	addListener();
    	r=0;
    	c=0;
    	if(player.equals("X"))
			mygame = new Tic(player, "O");
		else
			mygame = new Tic(player, "X");
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater = getMenuInflater(); //read XML
    	inflater.inflate(R.menu.main, menu);
    	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
        case R.id.exit:
        	finish();
            return true;
        case R.id.newg:
        	newGame();
        	return true;
        case R.id.play:
        	playAgain();
            return true;
            
        default:
            return super.onOptionsItemSelected(item);
            }
    }
    
    
    public void print(String msg){
    	Toast.makeText(getBaseContext(), msg ,Toast.LENGTH_LONG).show();
    }
    
}
