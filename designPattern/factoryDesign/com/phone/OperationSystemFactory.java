package factoryDesign.com.phone;

public class OperationSystemFactory {

	public OS getInstance(String strOS) {
		if("Open".equals(strOS)) {
			return new Android();
		} if("Close".equals(strOS)) {
			return new IOS();
		} else
		return new Windows(); 
	}
}
