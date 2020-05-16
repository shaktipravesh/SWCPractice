package factoryDesign;

import factoryDesign.com.phone.OS;
import factoryDesign.com.phone.OperationSystemFactory;

public class FactoryMain {

	public static void main(String[] args) {
		OperationSystemFactory myOSF = new OperationSystemFactory();
		myOSF.getInstance("Open").spec();
		OS os = myOSF.getInstance("Close");
		os.spec();
	}

}
