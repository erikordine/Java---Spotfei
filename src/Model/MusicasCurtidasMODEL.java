
package Model;

public class MusicasCurtidasMODEL {
    private int id_curtida;
    private int id_usuario;
    private int id_musica;
   
    // Construtor
    public MusicasCurtidasMODEL(int id_curtida, int id_usuario, int id_musica) {
        this.id_curtida = id_curtida;
        this.id_usuario = id_usuario;
        this.id_musica = id_musica;
    }

    // Getter and Setter
    public int getId_curtida() {
        return id_curtida;
    }

    public void setId_curtida(int id_curtida) {
        this.id_curtida = id_curtida;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_musica() {
        return id_musica;
    }

    public void setId_musica(int id_musica) {
        this.id_musica = id_musica;
    }
    
    
}
