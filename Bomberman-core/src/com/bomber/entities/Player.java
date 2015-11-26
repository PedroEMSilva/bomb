package com.bomber.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.bomber.Game;

import handlers.GameKeys;

public class Player extends B2DSprite {

	private float time;
	private float x1;
	private float y1;
	private int estado;
	
	
	
	
	public Player(Body body) {
		super(body);
		Texture tex = Game.res.getTexture("bunny");
		TextureRegion[] sprites = TextureRegion.split(tex, 32, 32)[0];

		setAnimation(sprites, 1 / 12f);
		estado = 0;

	}

	public void update(float dt) {
		animation.update(dt);
		//System.out.println(this.getPosition().x+","+this.getPosition().y);
		//System.out.println(estado+"    antes");
		atualizaEstado();
		//System.out.println(estado+"   depois");
	}

//	public void moveUpRight() {
//
//		this.getBody().setLinearVelocity(1500f, 1500f);
//
//	}
//
//	public void moveUpLeft() {
//
//		this.getBody().setLinearVelocity(-1500f, 1500f);
//
//	}
//
//	public void moveDownLeft() {
//
//		this.getBody().setLinearVelocity(-1500f, -1500f);
//
//	}
//
//	public void moveDownRight() {
//
//		this.getBody().setLinearVelocity(1500f, -1500f);
//
//	}

	public void moveRight() {
		x1 = this.getPosition().x+32;
		y1 = this.getPosition().y;
		//this.getBody().setLinearVelocity(1500f, 0);
		this.estado=GameKeys.RIGHT;
	}

	public void moveLeft() {
		x1 = this.getPosition().x-32;
		y1 = this.getPosition().y;
		this.estado=GameKeys.LEFT;
		//this.getBody().setLinearVelocity(-1500f, 0);

	}

	public void moveUp() {
		
		x1 = this.getPosition().x;
		y1 = this.getPosition().y+32;
		
			this.estado=GameKeys.UP;
		
		//this.getBody().setLinearVelocity(0, 15f);

	}

	public void moveDown() {
		x1 = this.getPosition().x;
		y1 = this.getPosition().y-32;
		
			this.estado=GameKeys.DOWN;
		//this.getBody().setLinearVelocity(0, -1500f);

	}
	public boolean estaParado(){
		if(estado==0){
			return true;
		}else{
			return false;
		}
	}
		
	private void atualizaEstado(){
		if(estado==0){
			return;
		}else if(estado==GameKeys.UP){
			if(this.getPosition().y<y1){
				//System.out.println(this.getPosition().y);
				this.getBody().setLinearVelocity(0, 15000f);
			}else{
				this.estado=0;
			}
			
			
		}else if(estado==GameKeys.DOWN){
			if(this.getPosition().y>y1){
				//System.out.println(this.getPosition().y);
				this.getBody().setLinearVelocity(0, -15000f);
			}else{
				this.estado=0;
			}
			
			
		}else if(estado==GameKeys.LEFT){
			if(this.getPosition().x>x1){
				//System.out.println(this.getPosition().y);
				this.getBody().setLinearVelocity(-15000f, 0);
			}else{
				this.estado=0;
			}
			
			
		}else if(estado==GameKeys.RIGHT){
			if(this.getPosition().x<x1){
				//System.out.println(this.getPosition().y);
				this.getBody().setLinearVelocity(15000f, 0);
			}else{
				this.estado=0;
			}
			
			
		}
		
		
		
	}
	
		
		
	}
	
	



