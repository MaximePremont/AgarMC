package net.lnfinity.AgarMC.cells.core;

import net.lnfinity.AgarMC.AgarMC;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.Vector;

public abstract class Cell {

	protected int mass;
	protected final ArmorStand armorStand;
	protected boolean invinsible = false;
	
	public Cell(int mass, double x, double y) {
		this.mass = mass;
		
		/** Armor Stand **/
		armorStand = AgarMC.get().getWorld().spawn(new Location(AgarMC.get().getWorld(), x, 128, y), ArmorStand.class);
		armorStand.setVisible(false);
		armorStand.setSmall(true);
	}
	
	public Cell(int mass, ArmorStand armorStand) {
		this.mass = mass;
		
		this.armorStand = armorStand;
	}
	
	public abstract void recalculateSize();
	
	public double getRadius() {
		return Math.cbrt(mass * 0.125);
	}
	
	public void remove() {
		armorStand.remove();
	}
	
	public void increaseMass(int mass) {
		this.mass += mass;
		recalculateSize();
	}
	
	public void setMass(int mass) {
		this.mass = mass;
		recalculateSize();
	}
	
	public void move(double x, double y) {
		Vector vector = new Vector(x, 0, y);
		addVelocity(vector);
	}

	public boolean isInvinsible() {
		return invinsible;
	}

	public void setInvinsible(boolean invinsible) {
		this.invinsible = invinsible;
	}

	public int getMass() {
		return mass;
	}
	
	public Vector getVelocity() {
		return armorStand.getVelocity();
	}
	
	public void setVelocity(Vector vector) {
		armorStand.setVelocity(vector);
	}
	
	public void addVelocity(Vector vector) {
		armorStand.setVelocity(armorStand.getVelocity().add(vector));
	}
	
	public double getX() {
		return armorStand.getLocation().getX();
	}
	
	public double getY() {
		return armorStand.getLocation().getZ();
	}
}
