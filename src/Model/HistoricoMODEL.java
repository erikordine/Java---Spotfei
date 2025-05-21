
package Model;

public class HistoricoMODEL {
    private int id_historico;
    private int id_usuario;
    private String termo;
    private String tipo;

    public HistoricoMODEL() {}
    
    public HistoricoMODEL(int id_historico, int id_usuario, String termo, String tipo) {
        this.id_historico = id_historico;
        this.id_usuario = id_usuario;
        this.termo = termo;
        this.tipo = tipo;
    }

    public HistoricoMODEL(int id_usuario, String termo, String tipo) {
        this.id_usuario = id_usuario;
        this.termo = termo;
        this.tipo = tipo;
    }
    

    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
