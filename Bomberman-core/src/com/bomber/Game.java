package com.bomber;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import handlers.Content;
import handlers.GameInputProcessor;
import handlers.GameKeys;
import handlers.GameStateManager;


public class Game implements ApplicationListener {
	
	
	public static final String TITLE = "Bomber-Cueio";
	public static final int WIDHT = 350;
	public static final int  HEIGHT = 350;
	public static final int  SCALE = 2;
	
	public static final float STEP = 1/60f ;
	private float accum;
	
	
	
	private SpriteBatch sb;
	private OrthographicCamera cam;
	private OrthographicCamera hudCam;
	private GameStateManager gsm;
	
	public static Content res;
	
	
	public SpriteBatch getSpriteBatch(){return sb;}
	public OrthographicCamera getCamera(){return cam;}
	public OrthographicCamera getHudCamera(){return hudCam;}
	
public void create (){

	
	Gdx.input.setInputProcessor(new GameInputProcessor());
	
	res = new Content();
	res.loadTexture("player.png", "player");
	res.loadTexture("bunny.png", "bunny");
	res.loadTexture("bomba.png", "bomba");
	res.loadTexture("bomba2.png", "bomba2");
	res.loadTexture("red.jpg", "red");
	sb = new SpriteBatch();
	cam = new OrthographicCamera();
	cam.setToOrtho(false,480,480);
	hudCam = new OrthographicCamera();
	hudCam.setToOrtho(false,480,480);
	gsm = new GameStateManager(this);
}
public void render ()	{
	
	accum += Gdx.graphics.getDeltaTime();
	
	while(accum>=STEP){
		accum -= STEP;
		gsm.update(STEP);
		gsm.render();
		GameKeys.update();
	//Gdx.gl.glClearColor(0, 0, 0, 1);
	//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
	//gsm.update(Gdx.graphics.getDeltaTime());
	//gsm.draw();
	
	}
	
	
}
public void resize(int w,int h){

}
public void pause () {

}
public void resume()	{

}
public void dispose(){

}

}
