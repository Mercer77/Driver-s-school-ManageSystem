package entity;

/**
 * Traincar entity. @author MyEclipse Persistence Tools
 */

public class Traincar implements java.io.Serializable {

	// Fields

	private TraincarId id;

	// Constructors

	/** default constructor */
	public Traincar() {
	}

	/** full constructor */
	public Traincar(TraincarId id) {
		this.id = id;
	}

	// Property accessors

	public TraincarId getId() {
		return this.id;
	}

	public void setId(TraincarId id) {
		this.id = id;
	}

}