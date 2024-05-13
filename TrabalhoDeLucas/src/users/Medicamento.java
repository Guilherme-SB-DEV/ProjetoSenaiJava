package users;

public class Medicamento {
    private String Tipo;
    private String NomeMedicamento;
    private float dosagem;
    private int periodicidade;
    private int horarioInicial;
    private int duracaoTratamento;

    /**
     * @return the dosagem
     */
    public float getDosagem() {
        return dosagem;
    }

    /**
     * @param dosagem the dosagem to set
     */
    public void setDosagem(float dosagem) {
        this.dosagem = dosagem;
    }

    /**
     * @return the periodicidade
     */
    public int getPeriodicidade() {
        return periodicidade;
    }

    /**
     * @param periodicidade the periodicidade to set
     */
    public void setPeriodicidade(int periodicidade) {
        this.periodicidade = periodicidade;
    }

    /**
     * @return the NomeMedicamento
     */
    public String getNomeMedicamento() {
        return NomeMedicamento;
    }

    /**
     * @param NomeMedicamento the NomeMedicamento to set
     */
    public void setNomeMedicamento(String NomeMedicamento) {
        this.NomeMedicamento = NomeMedicamento;
    }


    /**
     * @return the Tipo
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return the horarioInicial
     */
    public int getHorarioInicial() {
        return horarioInicial;
    }

    /**
     * @param horarioInicial the horarioInicial to set
     */
    public void setHorarioInicial(int horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    /**
     * @return the duracaoTratamento
     */
    public int getDuracaoTratamento() {
        return duracaoTratamento;
    }

    /**
     * @param duracaoTratamento the duracaoTratamento to set
     */
    public void setDuracaoTratamento(int duracaoTratamento) {
        this.duracaoTratamento = duracaoTratamento;
    }
    
}
