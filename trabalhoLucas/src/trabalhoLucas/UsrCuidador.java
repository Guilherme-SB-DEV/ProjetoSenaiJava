package trabalhoLucas;
import java.util.Date;
public class UsrCuidador extends Usr{
	private enum tipoContrato{
		clt,
		autonomo,
	}
	private String descricaoEspecialidade;
	private String dddEmergencial;
	private String numeroEmergencial;
	
	public String getDescricaoEspecialidade() {
		return descricaoEspecialidade;
	}
	public void setDescricaoEspecialidade(String descricaoEspecialidade) {
		this.descricaoEspecialidade = descricaoEspecialidade;
	}
	public String getDddEmergencial() {
		return dddEmergencial;
	}
	public void setDddEmergencial(String dddEmergencial) {
		this.dddEmergencial = dddEmergencial;
	}
	public String getNumeroEmergencial() {
		return numeroEmergencial;
	}
	public void setNumeroEmergencial(String numeroEmergencial) {
		this.numeroEmergencial = numeroEmergencial;
	}
	
	
	

}
