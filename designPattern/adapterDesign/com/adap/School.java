package adapterDesign.com.adap;

import adapterDesign.AssignmentWork;

public interface School {

	public static void main(String[] args) {
		//PilotPen pp = new PilotPen();
		PenAdapter p = new PenAdapter();
		AssignmentWork aw = new AssignmentWork();
		aw.setP(p);
		aw.writeAssignment("got a assignment.");
	}
}
