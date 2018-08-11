public class vehicle {


	public int vin;
	public VehicleSpec spec;
	public int Velocity;
	public DoubleGauge xometer;
	public DoubleGauge yometer;
	public Point2D memoGaugePosition;

	public getVin(){
		return vin;
	}

	public void setVin(int vin){
		this.vin = vin;

	}
	public VehicleSpec getSpec(){
		return spec;
	}

	public double gaugeTime(){
		return clock.read();
	}

	public double guageVelocity(){
		return speedometer.read();
	}

	public Point2D getPointAtMiddleFront(double delta){
		Point2D p = new Point2D.Double(movement.getPosition().getX() + delta * Math.cos(movement.getHeading()),movement.getPosition().getY() + delta * Math.sin(movement.getHeading()));


		return p;
	}

	public Point2D gaugePointAtMiddleFront(double delta){
		Point2D mp = gaugePosition();
		double h = gaugeHeading();
		Point2D p = new Point2D.Double(mp.getX() + delta * Math.cos(h), mp.getY() + delta * Math.sin(h));

	}

	public void removeAccelSchedule() {
		if(Debug.isPrintVehicleHighLevelOfControlVIN(vin)) {
			System.err.printf("vin %d removeAccelSchedule()\n", vin);
		}
		switchToMovingTargetVelocityMovement();
	}
	
	}
}