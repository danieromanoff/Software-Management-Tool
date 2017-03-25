package softwaremanagementtool.agile;

import javax.xml.bind.annotation.XmlAttribute;

public class Stats {
	private Integer val;
	@XmlAttribute
	private String state;
	
	public Stats() {
		val = 0;
		state ="None";
	}
	
	public Integer getVal() {
		return val;
	}
	public void setVal(Integer v) {
		val = v;
	}
	
	public void setState(String s) {
		state = s;
	}
}
