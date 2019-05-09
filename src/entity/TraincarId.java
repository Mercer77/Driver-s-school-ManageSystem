package entity;

/**
 * TraincarId entity. @author MyEclipse Persistence Tools
 */

public class TraincarId implements java.io.Serializable {

	// Fields

	private Coaches coaches;
	private Car car;

	// Constructors

	/** default constructor */
	public TraincarId() {
	}

	/** full constructor */
	public TraincarId(Coaches coaches, Car car) {
		this.coaches = coaches;
		this.car = car;
	}

	// Property accessors

	public Coaches getCoaches() {
		return this.coaches;
	}

	public void setCoaches(Coaches coaches) {
		this.coaches = coaches;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TraincarId))
			return false;
		TraincarId castOther = (TraincarId) other;

		return ((this.getCoaches() == castOther.getCoaches()) || (this.getCoaches() != null
				&& castOther.getCoaches() != null && this.getCoaches().equals(castOther.getCoaches())))
				&& ((this.getCar() == castOther.getCar()) || (this.getCar() != null && castOther.getCar() != null
						&& this.getCar().equals(castOther.getCar())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCoaches() == null ? 0 : this.getCoaches().hashCode());
		result = 37 * result + (getCar() == null ? 0 : this.getCar().hashCode());
		return result;
	}

}