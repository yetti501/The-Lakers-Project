package guimain;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * Sets and obtains the version automatically based off of the serialized version of the class.
 * @author Lakers Project Team
 */
public class Version {
	
	/** Current Project class */
	public DIYProjectMain myProj;
	
	/** Grabs the serialized version of the object. */
	private ByteArrayOutputStream verCounter;
	
	/**
	 * Instantiates the class parameters.
	 * @param proj Current project class to work with.
	 */
	public Version(DIYProjectMain proj) {
		verCounter = new ByteArrayOutputStream();
		myProj = proj;
		
	}
	
	/** Gets version id consisting of hashcode of bitstream rounded to 2 decimal places. */
	public double getVersion() {
		return BigDecimal.valueOf(Math.abs(verCounter.toString().hashCode() / 1000000.0))
			    .setScale(2, RoundingMode.HALF_UP)
			    .doubleValue();
	}
	
	/** Gets the serialized version of the class and ByteArrayOutputStream. */
	public void setVersion() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(verCounter);
			out.writeObject(myProj);
			System.out.println("Object ID Generated Successfully! BitStream HashCode: " + verCounter.toString().hashCode());
		} catch (IOException e) {
			System.err.println("Error Generating Version ID!");
		}
	}
	
}
