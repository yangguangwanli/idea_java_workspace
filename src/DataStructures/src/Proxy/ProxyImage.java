package Proxy;

public class ProxyImage implements Image {
	
	private RealImage realImage;//代理类中拥有要被代理的对象
	
	private String fileName;
	
	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void display() {
		if(realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}

}
