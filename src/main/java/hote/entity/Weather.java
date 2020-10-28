package hote.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather{

	@JsonProperty("postalCodes")
	private List<PostalCodesItem> postalCodes;

	public void setPostalCodes(List<PostalCodesItem> postalCodes){
		this.postalCodes = postalCodes;
	}

	public List<PostalCodesItem> getPostalCodes(){
		return postalCodes;
	}

	@Override
 	public String toString(){
		return 
			"Weather{" + 
			"postalCodes = '" + postalCodes + '\'' + 
			"}";
		}
}